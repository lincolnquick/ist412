package com.buffettinc.hrms.service.employee;

import com.buffettinc.hrms.model.communication.Observer;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.Manager;
import com.buffettinc.hrms.model.job.Applicant;
import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.model.job.JobOpening;
import com.buffettinc.hrms.model.pto.PTOBalance;
import com.buffettinc.hrms.model.pto.PTOCalendar;
import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.model.training.Task;
import com.buffettinc.hrms.repository.communication.MessageRepository;
import com.buffettinc.hrms.repository.communication.NotificationRepository;
import com.buffettinc.hrms.repository.employee.EmployeeRepository;
import com.buffettinc.hrms.repository.employee.ManagerRepository;
import com.buffettinc.hrms.repository.job.JobApplicationRepository;
import com.buffettinc.hrms.repository.job.JobOpeningRepository;
import com.buffettinc.hrms.repository.time.TimesheetRepository;
import com.buffettinc.hrms.repository.training.TaskRepository;
import com.buffettinc.hrms.service.JobApplicationService;
import com.buffettinc.hrms.service.communication.MessageService;
import com.buffettinc.hrms.service.communication.NotificationService;
import com.buffettinc.hrms.service.job.JobOpeningService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
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

    private final JobOpeningService jobOpeningService;
    private final TaskRepository taskRepository;


    private final NotificationService notificationService;

    private List<Observer> observers;

    public ManagerServiceImpl(ManagerRepository managerRepository, EmployeeRepository employeeRepository,
                              JobApplicationRepository jobApplicationRepository,
                              JobOpeningService jobOpeningService,
                              TaskRepository taskRepository,
                              NotificationService notificationService) {
        this.managerRepository = managerRepository;
        this.employeeRepository = employeeRepository;
        this.jobApplicationRepository = jobApplicationRepository;
        this.jobOpeningService = jobOpeningService;
        this.taskRepository = taskRepository;
        this.notificationService = notificationService;
        this.observers = new ArrayList<>();
    }

    @Override
    public void registerObserver(Observer observer){
        observers.add(observer);
    }

    @Override
    public void registerObservers(List<Observer> observers){
        for (Observer o : observers){
            this.observers.add(o);
        }
    }

    @Override
    public void removeObservers(List<Observer> observers){
        for (Observer o : observers){
            this.observers.remove(o);
        }
    }
    @Override
    public void removeObserver(Observer observer){
        observers.remove(observer);
    }

    @Override
    public List<Manager> getAllManagers() {
        return this.managerRepository.findAll();
    }

    public void hire(Applicant applicant, Manager hiringManager){
        applicant.setStatus(JobApplication.JobApplicationStatus.APPROVED_BY_MANAGER);
        // Hiring Logic
        Optional<Manager> manager = managerRepository.findByEmployeeID(hiringManager.getEmployeeID());
        // create new employee based on applicant info

        Employee newEmployee = convertApplicantToEmployee(applicant, manager.orElse(null));
        employeeRepository.save(newEmployee);
        Optional<Employee> savedEmployee = employeeRepository.findByEmployeeID(newEmployee.getEmployeeID());

        if (savedEmployee.isEmpty()){
            throw new RuntimeException("Error in saving new employee. ");
        }

        // Notify applicant about the outcome
        notificationService.sendNotification(savedEmployee.get(), "Congratulations! You have been hired.");

    }

    private Employee convertApplicantToEmployee(Applicant applicant, Manager hiringManager){

        String firstName = applicant.getFirstName();
        String lastName = applicant.getLastName();
        String streetAddress = applicant.getStreetAddress();
        String city = applicant.getCity();
        String state = applicant.getState();
        String zip = applicant.getZip();
        String phone = applicant.getPhone();
        String email = applicant.getEmail();
        String position = "New Hire";
        String department = "Department";
        Long jobID = applicant.getJobID();
        Optional<JobOpening> jobOpening = jobOpeningService.getJobOpeningByID(jobID);

        if (jobOpening.isPresent()){
            position = jobOpening.get().getTitle();
            department = jobOpening.get().getDepartment();
        }
        Employee newEmployee = new Employee(lastName, firstName, streetAddress, city, state, zip, phone, email,
                LocalDate.now(),department,position, hiringManager);

        return newEmployee;

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
