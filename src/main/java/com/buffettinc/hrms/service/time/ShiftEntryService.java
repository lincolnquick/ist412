package com.buffettinc.hrms.service.time;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.time.ShiftEntry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * This interface provides a contract for the ShiftEntryService. It includes CRUD methods as well as
 * a method to calculate the duration of a shift in hours.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface ShiftEntryService {

    /**
     * Determines if an employee is currently punched in.
     * @param employee Employee to check
     * @return true if the employee is currently punched in, else false.
     */
    boolean isEmployeePunchedIn(Employee employee);

    /**
     * Punches the employee in by creating a new ShiftEntry with a start time and adding it to the current timesheet.
     * @param employee Employee to punch in
     * @return the new ShiftEntry
     */
    ShiftEntry punchIn(Employee employee);

    /**
     * Punches the employee out by setting the end time for the current ShiftEntry.
     * @param employee Employee to punch out
     * @return the updated ShiftEntry
     */
    ShiftEntry punchOut(Employee employee);

    /**
     * Returns the date and time of an Employee's last punch in or out.
     * @param employee Employee to find the last punch
     * @return the LocalDateTime of the punch
     */
    LocalDateTime getLastPunch(Employee employee);

    /**
     * Saves or updates a shift entry.
     *
     * @param shiftEntry The shift entry to be saved or updated.
     * @return The saved or updated shift entry.
     */
    ShiftEntry saveOrUpdateShiftEntry(ShiftEntry shiftEntry);

    /**
     * Gets a shift entry by ID.
     *
     * @param shiftID The ID of the shift entry.
     * @return The shift entry.
     */
    ShiftEntry getShiftEntryById(Long shiftID);

    /**
     * Gets all shift entries.
     *
     * @return A list of all shift entries.
     */
    List<ShiftEntry> getAllShiftEntries();

    /**
     * Deletes a shift entry.
     *
     * @param shiftID The ID of the shift entry to delete.
     */
    void deleteShiftEntry(Long shiftID);

    /**
     * Gets the duration of a shift in hours.
     *
     * @param shiftID The ID of the shift entry.
     * @return The duration of the shift in hours.
     */
    long getShiftDurationInHours(Long shiftID);
}
