package com.buffettinc.hrms.service.pto;

import com.buffettinc.hrms.model.pto.PTOBalance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * This interface defines the services provided for handling the PTO (Paid Time Off) Balance of an employee.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */

public interface PTOBalanceService {

    /**
     * Saves or updates a PTOBalance object.
     *
     * @param ptobalance The PTOBalance object to be saved or updated.
     * @return The saved or updated PTOBalance object.
     */
    PTOBalance saveOrUpdatePTOBalance(PTOBalance ptobalance);

    /**
     * Fetches a PTOBalance object by its ID.
     *
     * @param employeeID The ID of the PTOBalance object to be fetched.
     * @return The fetched PTOBalance object.
     */
    PTOBalance getPTOBalanceById(UUID employeeID);

    /**
     * Fetches all PTOBalance objects.
     *
     * @return A List of all PTOBalance objects.
     */
    List<PTOBalance> getAllPTOBalances();

    /**
     * Deletes a PTOBalance object by its ID.
     *
     * @param employeeID The ID of the PTOBalance object to be deleted.
     */
    void deletePTOBalance(UUID employeeID);

    /**
     * Reduces the vacation balance of the employee by a specified amount of hours.
     *
     * @param employeeID The ID of the employee.
     * @param hours The amount of hours to be deducted from the vacation balance.
     */
    void useVacationTime(UUID employeeID, float hours);

    /**
     * Reduces the personal time balance of the employee by a specified amount of hours.
     *
     * @param employeeID The ID of the employee.
     * @param hours The amount of hours to be deducted from the personal time balance.
     */
    void usePersonalTime(UUID employeeID, float hours);

    /**
     * Reduces the sick time balance of the employee by a specified amount of hours.
     *
     * @param employeeID The ID of the employee.
     * @param hours The amount of hours to be deducted from the sick time balance.
     */
    void useSickTime(UUID employeeID, float hours);

    /**
     * Adds to the vacation balance of the employee by a specified amount of hours.
     *
     * @param employeeID The ID of the employee.
     * @param hours The amount of hours to be added to the vacation balance.
     */
    void accrueVacationTime(UUID employeeID, float hours);

    /**
     * Adds to the personal time balance of the employee by a specified amount of hours.
     *
     * @param employeeID The ID of the employee.
     * @param hours The amount of hours to be added to the personal time balance.
     */
    void accruePersonalTime(UUID employeeID, float hours);

    /**
     * Adds to the sick time balance of the employee by a specified amount of hours.
     *
     * @param employeeID The ID of the employee.
     * @param hours The amount of hours to be added to the sick time balance.
     */
    void accrueSickTime(UUID employeeID, float hours);
}
