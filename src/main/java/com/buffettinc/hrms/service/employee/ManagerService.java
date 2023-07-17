package com.buffettinc.hrms.service.employee;

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
import java.util.UUID;

/**
 * This interface defines the operations that can be performed by a {@link Manager}.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface ManagerService {

    /**
     * Assigns a task to an employee.
     *
     * @param employeeID  the ID of the employee to assign the task to
     * @param name        the name of the task
     * @param description the description of the task
     * @param dueDate     the due date of the task
     * @return the assigned task
     */
    Task assignTask(UUID employeeID, String name, String description, LocalDate dueDate);

    /**
     * Gets a list of employees managed by the manager.
     *
     * @param managerID the ID of the manager
     * @param pageable  the pageable object for pagination
     * @return a page of managed employees
     */
    Page<Employee> getManagedEmployees(UUID managerID, Pageable pageable);

    /**
     * Reviews a job application for a specific job opening.
     *
     * @param jobID      the ID of the job opening
     * @param applicantID the ID of the applicant
     * @return the reviewed job application
     */
    JobApplication reviewJobApplication(UUID jobID, UUID applicantID);

    /**
     * Approves a job application for a specific job opening.
     *
     * @param jobApplication the job application to approve
     * @return the approved job application
     */
    JobApplication approveJobApplication(JobApplication jobApplication);

    /**
     * Approves hours in a timesheet.
     *
     * @param timesheet the timesheet to approve
     */
    void approveHours(Timesheet timesheet);

    /**
     * Approves a PTO request.
     *
     * @param request the PTO request to approve
     */
    void approvePTO(PTORequest request);

    /**
     * Views the PTO balance of an employee.
     *
     * @param employee the employee to view the PTO balance of
     * @return the PTO balance of the employee
     */
    PTOBalance viewEmployeePTO(Employee employee);

    /**
     * Views the PTO calendar.
     *
     * @return the PTO calendar
     */
    PTOCalendar viewPTOCalendar();
}
