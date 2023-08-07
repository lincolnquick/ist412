package com.buffettinc.hrms.service.time;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.payroll.Payroll;
import com.buffettinc.hrms.model.time.ShiftEntry;
import com.buffettinc.hrms.model.time.Timesheet;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface provides a contract for the TimesheetService. It includes CRUD methods as well as
 * methods to manage shifts and approval status of a {@link Timesheet}.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface TimesheetService {

    /**
     * Saves or updates a timesheet.
     *
     * @param timesheet The timesheet to be saved or updated.
     * @return The saved or updated timesheet.
     */
    Timesheet saveOrUpdateTimesheet(Timesheet timesheet);

    /**
     * Allows an employee to log a shift to be added to the timesheet.
     * @param payroll data of employee to log the shift
     * @param periodStart start time of shift
     * @param periodEnd end time of shift
     */
    void logShift(Payroll payroll, LocalDate periodStart, LocalDate periodEnd, ShiftEntry shiftEntry);

    /**
     * Gets a timesheet by ID.
     *
     * @param timesheetID The ID of the timesheet.
     * @return The timesheet.
     */
    Timesheet getTimesheetById(Long timesheetID);

    /**
     * Finds the appropriate Timesheet based on an Employee's Payroll data and timesheet period start and end dates.
     * If one doesn't exist, a new one is created.
     * Enforces payroll to start on Sundays and end six days later on Saturday.
     *
     * @param payroll
     * @param periodStart
     * @param periodEnd
     * @return Timesheet
     */
    Optional<Timesheet> findByPayrollAndPeriod(Payroll payroll, LocalDate periodStart, LocalDate periodEnd);
    /**
     * Gets all timesheets.
     *
     * @return A list of all timesheets.
     */
    List<Timesheet> getAllTimesheets();

    /**
     * Deletes a timesheet.
     *
     * @param timesheetID The ID of the timesheet to delete.
     */
    void deleteTimesheet(Long timesheetID);

    /**
     * Approves a timesheet.
     *
     * @param timesheetID The ID of the timesheet to approve.
     * @param manager The employee who is approving the timesheet.
     */
    void approveTimesheet(Long timesheetID, Employee manager);
}
