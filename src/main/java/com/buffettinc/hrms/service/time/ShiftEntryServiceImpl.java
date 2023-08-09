package com.buffettinc.hrms.service.time;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.time.ShiftEntry;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.repository.time.ShiftEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class implements the {@link ShiftEntryService} interface, providing concrete
 * implementations for each method.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class ShiftEntryServiceImpl implements ShiftEntryService {
    @Autowired
    private ShiftEntryRepository shiftEntryRepository;

    @Autowired
    @Lazy
    private TimesheetService timesheetService;

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean isEmployeePunchedIn(Employee employee) {
        List<ShiftEntry> shifts = shiftEntryRepository.findOpenShiftsForEmployeePayroll(employee.getPayrollInfo());
        return !shifts.isEmpty();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ShiftEntry punchIn(Employee employee) {
        ShiftEntry newShift = new ShiftEntry(LocalDateTime.now(), null);
        shiftEntryRepository.save(newShift);

        // Add the new shift to the current timesheet
        LocalDate today = LocalDate.now();
        Optional<Timesheet> optionalTimesheet = timesheetService.findByPayrollAndPeriod(employee.getPayrollInfo(), today,
                today.plusDays(6));
        if (optionalTimesheet.isPresent()){
            optionalTimesheet.get().addShift(newShift);
            return newShift;
        } else {
            throw new RuntimeException("Error punching out: could not locate or create new timesheet");
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ShiftEntry punchOut(Employee employee) {
        List<ShiftEntry> openShifts = shiftEntryRepository.findOpenShiftsForEmployeePayroll(employee.getPayrollInfo());
        if (openShifts.isEmpty()){
            return null;
        }

        ShiftEntry currentShift = openShifts.get(0);
        currentShift.setEnd(LocalDateTime.now());
        return shiftEntryRepository.save(currentShift);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public LocalDateTime getLastPunch(Employee employee) {
        List<ShiftEntry> shifts = shiftEntryRepository.findShiftsForEmployeePayroll(employee.getPayrollInfo());

        // Return null if no shifts are found
        if (shifts.isEmpty()) {
            return null;
        }

        // Sort the shifts by their end time in descending order to find the most recent
        shifts.sort(Comparator.comparing(ShiftEntry::getEnd).reversed());
        return shifts.get(0).getEnd();
    }


    /**
     * {@inheritDoc}
     */
    @Override
    public ShiftEntry saveOrUpdateShiftEntry(ShiftEntry shiftEntry) {
        return shiftEntryRepository.save(shiftEntry);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ShiftEntry getShiftEntryById(Long shiftID) {
        return shiftEntryRepository.findById(shiftID).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ShiftEntry> getAllShiftEntries() {
        return shiftEntryRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteShiftEntry(Long shiftID) {
        shiftEntryRepository.deleteById(shiftID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public double getShiftDurationInHours(Long shiftID) {
        ShiftEntry shiftEntry = getShiftEntryById(shiftID);
        return shiftEntry != null ? shiftEntry.getDurationInHours() : 0.0;
    }
}
