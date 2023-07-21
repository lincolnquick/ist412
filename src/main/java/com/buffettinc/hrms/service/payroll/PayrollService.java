package com.buffettinc.hrms.service.payroll;

import com.buffettinc.hrms.model.payroll.Payroll;
import com.buffettinc.hrms.model.time.Timesheet;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface defines the contract for managing the Payroll details of Buffett Inc.
 * It provides CRUD operations on Payroll as well as operations for adding and approving timesheets.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface PayrollService {

    /**
     * Save or update a Payroll entry.
     *
     * @param payroll Payroll object to be saved or updated.
     * @return Saved or updated Payroll object.
     */
    Payroll saveOrUpdatePayroll(Payroll payroll);

    /**
     * Get a Payroll entry by its ID.
     *
     * @param payrollID UUID of the Payroll entry.
     * @return Payroll object if found, else Optional.empty.
     */
    Optional<Payroll> getPayrollById(Long payrollID);

    /**
     * Get all Payroll entries.
     *
     * @return List of all Payroll entries.
     */
    List<Payroll> getAllPayrolls();

    /**
     * Delete a Payroll entry.
     *
     * @param payrollID UUID of the Payroll entry to be deleted.
     */
    void deletePayroll(Long payrollID);

    /**
     * Get all Timesheets of a Payroll entry.
     *
     * @param payrollID UUID of the Payroll entry.
     * @return List of Timesheets.
     */
    List<Timesheet> getTimesheetsForPayroll(Long payrollID);

    /**
     * Add a Timesheet to a Payroll entry.
     *
     * @param payrollID UUID of the Payroll entry.
     * @param timesheet Timesheet to be added.
     * @return Updated Payroll entry.
     */
    Payroll addTimesheetToPayroll(Long payrollID, Timesheet timesheet);

    /**
     * Approve a Timesheet of a Payroll entry.
     *
     * @param payrollID UUID of the Payroll entry.
     * @param timesheetID UUID of the Timesheet to be approved.
     * @return Updated Payroll entry.
     */
    Payroll approveTimesheet(Long payrollID, Long timesheetID);
}
