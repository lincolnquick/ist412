package com.buffettinc.hrms.service.pto;

import com.buffettinc.hrms.model.pto.PTOCalendar;
import com.buffettinc.hrms.model.pto.PTORequest;

import java.util.List;
import java.util.UUID;

/**
 * This interface defines the services associated with the {@link PTOCalendar} object.
 * The PTOCalendar contains a collection of all {@link PTORequest}s for each EmployeeID.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface PTOCalendarService {
    /**
     * Save or update a PTOCalendar object.
     *
     * @param ptoCalendar the PTOCalendar to save or update
     * @return the saved or updated PTOCalendar
     */
    PTOCalendar saveOrUpdatePTOCalendar(PTOCalendar ptoCalendar);

    /**
     * Retrieve a PTOCalendar by its ID.
     *
     * @param calendarID the UUID of the PTOCalendar
     * @return the PTOCalendar with the provided ID or null if not found
     */
    PTOCalendar getPTOCalendarById(UUID calendarID);

    /**
     * Retrieve all existing PTOCalendar objects.
     *
     * @return a list of all PTOCalendars
     */
    List<PTOCalendar> getAllPTOCalendars();

    /**
     * Remove a PTOCalendar by its ID.
     *
     * @param calendarID the UUID of the PTOCalendar to remove
     */
    void deletePTOCalendar(UUID calendarID);

    /**
     * Add a PTORequest to a specific PTOCalendar.
     *
     * @param calendarID the UUID of the PTOCalendar
     * @param employeeID the UUID of the Employee
     * @param request the PTORequest to add
     */
    void addPTORequest(UUID calendarID, UUID employeeID, PTORequest request);

    /**
     * Remove a PTORequest from a specific PTOCalendar.
     *
     * @param calendarID the UUID of the PTOCalendar
     * @param employeeID the UUID of the Employee
     * @param request the PTORequest to remove
     */
    void removePTORequest(UUID calendarID, UUID employeeID, PTORequest request);

    /**
     * Update a PTORequest in a specific PTOCalendar.
     *
     * @param calendarID the UUID of the PTOCalendar
     * @param employeeID the UUID of the Employee
     * @param previousRequest the PTORequest to update
     * @param newRequest the updated PTORequest
     */
    void updatePTORequest(UUID calendarID, UUID employeeID, PTORequest previousRequest, PTORequest newRequest);
}
