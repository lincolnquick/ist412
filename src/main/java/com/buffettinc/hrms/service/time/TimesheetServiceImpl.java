package com.buffettinc.hrms.service.time;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.repository.time.TimesheetRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
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
