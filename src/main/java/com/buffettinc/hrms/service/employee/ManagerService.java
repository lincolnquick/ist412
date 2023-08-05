package com.buffettinc.hrms.service.employee;

import com.buffettinc.hrms.model.communication.Observer;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.Manager;
import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.model.pto.PTOBalance;
import com.buffettinc.hrms.model.pto.PTOCalendar;
import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.model.training.Task;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * This interface defines the operations that can be performed by a {@link Manager}.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface ManagerService {

    Manager createManager(Manager manager);

    Manager updateManager(Manager manager);

    /**
     * Gets all Manager employees.
     * @return List of all Managers
     */
    List<Manager> getAllManagers();

    void registerObservers(List<Observer> observers);

    void removeObservers(List<Observer> observers);

    /**
     * Assigns a task to an employee.
     *
     * @param employeeID  the ID of the employee to assign the task to
     * @param name        the name of the task
     * @param description the description of the task
     * @param dueDate     the due date of the task
     * @return the assigned task
     */
    Task assignTask(Long employeeID, String name, String description, LocalDate dueDate);

    /**
     * Gets a list of employees managed by the manager.
     *
     * @param managerID the ID of the manager
     * @param pageable  the pageable object for pagination
     * @return a page of managed employees
     */
    Page<Employee> getManagedEmployees(Long managerID, Pageable pageable);

    /**
     * Reviews a job application for a specific job opening.
     *
     * @param jobID      the ID of the job opening
     * @param applicantID the ID of the applicant
     * @return the reviewed job application
     */
    JobApplication reviewJobApplication(Long jobID, Long applicantID);

}
