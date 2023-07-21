package com.buffettinc.hrms.service.employee;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.Manager;
import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.model.pto.PTOBalance;
import com.buffettinc.hrms.model.pto.PTOCalendar;
import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.model.training.Task;
import com.buffettinc.hrms.repository.employee.EmployeeRepository;
import com.buffettinc.hrms.repository.employee.ManagerRepository;
import com.buffettinc.hrms.repository.job.JobApplicationRepository;
import com.buffettinc.hrms.repository.time.TimesheetRepository;
import com.buffettinc.hrms.repository.training.TaskRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * This class implements the {@link ManagerService} interface and provides methods to manage employees as a Manager.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
@Transactional
public class ManagerServiceImpl implements ManagerService {

    private final ManagerRepository managerRepository;
    private final EmployeeRepository employeeRepository;
    private final JobApplicationRepository jobApplicationRepository;
    private final TimesheetRepository timesheetRepository;
    private final TaskRepository taskRepository;

    public ManagerServiceImpl(ManagerRepository managerRepository, EmployeeRepository employeeRepository,
                              JobApplicationRepository jobApplicationRepository, TimesheetRepository timesheetRepository,
                              TaskRepository taskRepository) {
        this.managerRepository = managerRepository;
        this.employeeRepository = employeeRepository;
        this.jobApplicationRepository = jobApplicationRepository;
        this.timesheetRepository = timesheetRepository;
        this.taskRepository = taskRepository;
    }

    @Override
    public List<Manager> getAllManagers() {
        return this.managerRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Task assignTask(Long employeeID, String name, String description, LocalDate dueDate) {
        Employee employee = employeeRepository.findById(employeeID)
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employeeID));
        Manager manager = (Manager) managerRepository.findByEmployeeID(employeeID)
                .orElseThrow(() -> new RuntimeException("Manager not found for employee with ID: " + employeeID));

        Task task = new Task(name, description, dueDate, manager, employee);
        taskRepository.save(task);
        return task;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Employee> getManagedEmployees(Long managerID, Pageable pageable) {
        Manager manager = managerRepository.findById(managerID)
                .orElseThrow(() -> new RuntimeException("Manager not found with ID: " + managerID));
        return employeeRepository.findByManager(manager, pageable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JobApplication reviewJobApplication(Long jobID, Long applicantID) {
        JobApplication jobApplication = (JobApplication) jobApplicationRepository.findByJobOpeningIDAndApplicantID(jobID, applicantID)
                .orElseThrow(() -> new RuntimeException("Job application not found for job ID: "
                        + jobID + " and applicant ID: " + applicantID));
        // Perform review operations
        return jobApplication;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JobApplication approveJobApplication(JobApplication jobApplication) {
        // Perform approval operations
        return jobApplication;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void approveHours(Timesheet timesheet) {
        // Perform approval operations
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void approvePTO(PTORequest request) {
        // Perform approval operations
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PTOBalance viewEmployeePTO(Employee employee) {
        // Retrieve and return the PTO balance of the employee
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PTOCalendar viewPTOCalendar() {
        // Retrieve and return the PTO calendar
        return null;
    }
}
