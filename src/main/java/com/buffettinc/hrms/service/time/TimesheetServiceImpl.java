package com.buffettinc.hrms.service.time;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.payroll.Payroll;
import com.buffettinc.hrms.model.time.ShiftEntry;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.repository.time.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.DayOfWeek;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class implements the {@link TimesheetService} interface, providing concrete
 * implementations for each method.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class TimesheetServiceImpl implements TimesheetService {
    @Autowired
    private TimesheetRepository timesheetRepository;

    @Override
    public void logShift(Payroll payroll, LocalDate periodStart, LocalDate periodEnd, ShiftEntry shiftEntry) {
        // Get the corresponding timesheet for the given payroll and period dates
        Optional<Timesheet> optionalTimesheet = findByPayrollAndPeriod(payroll, periodStart, periodEnd);

        if (optionalTimesheet.isPresent()) {
            Timesheet timesheet = optionalTimesheet.get();
            // Add the new shift entry to the timesheet
            timesheet.getShifts().add(shiftEntry);
            // Save the updated timesheet
            timesheetRepository.save(timesheet);
        } else {
            // Handle the case where no timesheet is found for the given criteria
            // This could be creating a new timesheet or throwing an exception
            // For simplicity, let's just throw an exception for now
            throw new RuntimeException("No timesheet found for the given period and payroll.");
        }
    }

    @Override
    public Optional<Timesheet> findByPayrollAndPeriod(Payroll payroll, LocalDate periodStart, LocalDate periodEnd) {
        // Adjust periodStart to be the nearest preceding Sunday
        if (periodStart.getDayOfWeek() != DayOfWeek.SUNDAY) {
            periodStart = periodStart.with(TemporalAdjusters.previous(DayOfWeek.SUNDAY));
        }

        // Adjust periodEnd to be the Saturday 6 days after periodStart
        periodEnd = periodStart.plusDays(6);

        // Try to find the existing timesheet
        Optional<Timesheet> existingTimesheet = Optional.ofNullable(timesheetRepository.findByPayrollAndPeriodStartAndPeriodEnd(payroll, periodStart, periodEnd));

        // If the timesheet doesn't exist, create and save a new one
        if (!existingTimesheet.isPresent()) {
            Timesheet newTimesheet = new Timesheet(payroll, periodStart, periodEnd);
            timesheetRepository.save(newTimesheet);
            return Optional.of(newTimesheet);
        }

        return existingTimesheet;
    }

    @Autowired
    private ShiftEntryService shiftEntryService;
    /**
     * {@inheritDoc}
     */
    @Override
    public Timesheet saveOrUpdateTimesheet(Timesheet timesheet) {
        return timesheetRepository.save(timesheet);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Timesheet getTimesheetById(Long timesheetID) {
        return timesheetRepository.findById(timesheetID).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Timesheet> getAllTimesheets() {
        return timesheetRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteTimesheet(Long timesheetID) {
        timesheetRepository.deleteById(timesheetID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void approveTimesheet(Long timesheetID, Employee manager) {
        Timesheet timesheet = getTimesheetById(timesheetID);
        if (timesheet != null) {
            timesheet.approveTimesheet(manager);
            timesheetRepository.save(timesheet);
        }
    }
}
