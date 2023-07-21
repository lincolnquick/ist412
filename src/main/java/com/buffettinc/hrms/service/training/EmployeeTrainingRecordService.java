package com.buffettinc.hrms.service.training;

import com.buffettinc.hrms.model.training.EmployeeTrainingRecord;

import java.util.List;
import java.util.UUID;

/**
 * This interface provides a contract for the EmployeeTrainingRecordService. It includes CRUD methods for
 * handling Employee Training Records.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface EmployeeTrainingRecordService {

    /**
     * Saves or updates an employee training record.
     *
     * @param employeeTrainingRecord The employee training record to be saved or updated.
     * @return The saved or updated employee training record.
     */
    EmployeeTrainingRecord saveOrUpdateEmployeeTrainingRecord(EmployeeTrainingRecord employeeTrainingRecord);

    /**
     * Gets an employee training record by ID.
     *
     * @param recordID The ID of the employee training record.
     * @return The employee training record.
     */
    EmployeeTrainingRecord getEmployeeTrainingRecordById(Long recordID);

    /**
     * Gets all employee training records.
     *
     * @return A list of all employee training records.
     */
    List<EmployeeTrainingRecord> getAllEmployeeTrainingRecords();

    /**
     * Deletes an employee training record.
     *
     * @param recordID The ID of the employee training record to delete.
     */
    void deleteEmployeeTrainingRecord(Long recordID);
}
