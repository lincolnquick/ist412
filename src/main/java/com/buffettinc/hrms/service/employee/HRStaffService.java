package com.buffettinc.hrms.service.employee;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.HRStaff;
import com.buffettinc.hrms.model.job.Applicant;
import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.model.job.JobOpening;
import com.buffettinc.hrms.model.training.TrainingModule;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing {@link HRStaff} employees.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface HRStaffService {

    /**
     * Adds a new training module.
     *
     * @param title        the title of the training module
     * @param description  the description of the training module
     * @param trainingURL  the URL of the training module
     * @param eta          the estimated time of completion for the training module
     * @return the created training module
     */
    TrainingModule addTrainingModule(String title, String description, URL trainingURL, Duration eta);

    /**
     * Posts a new job opening.
     *
     * @param title        the title of the job opening
     * @param department   the department of the job opening
     * @param description  the description of the job opening
     * @param postingDate  the posting date of the job opening
     * @return the created job opening
     */
    JobOpening postJobOpening(String title, String department, String description, LocalDate postingDate);

    /**
     * Adds a new applicant for a job opening.
     *
     * @param firstName    the first name of the applicant
     * @param lastName     the last name of the applicant
     * @param streetAddress  the street address of the applicant
     * @param city         the city of the applicant
     * @param state        the state of the applicant
     * @param zip          the ZIP code of the applicant
     * @param phone        the phone number of the applicant
     * @param email        the email address of the applicant
     * @param status       the status of the job application
     * @param jobID        the ID of the job opening
     * @param resume       the URL of the applicant's resume
     * @return the created applicant
     */
    Applicant addNewApplicant(String firstName, String lastName, String streetAddress, String city, String state,
                              String zip, String phone, String email, String status, Long jobID, URL resume);

    /**
     * Accepts a job application for a job opening.
     *
     * @param jobID       the ID of the job opening
     * @param applicantID the ID of the applicant
     * @return the created job application
     */
    JobApplication acceptApplication(Long jobID, Long applicantID);

    /**
     * Reviews a job application for a job opening.
     *
     * @param jobID       the ID of the job opening
     * @param applicantID the ID of the applicant
     * @return the reviewed job application
     */
    JobApplication reviewJobApplication(Long jobID, Long applicantID);

    /**
     * Approves a job application.
     *
     * @param application the job application to approve
     * @return the approved job application
     */
    JobApplication approveJobApplication(JobApplication application);

    /**
     * Gets all HRStaff employees
     * @return List of all HRStaff employees
     */
    List<HRStaff> getAllHRStaff();
    /**
     * Views employee data for a given employee.
     *
     * @param employee the employee to view data for
     */
    void viewEmployeeData(Employee employee);

    /**
     * Adds a new employee.
     */
    void addEmployee();

    /**
     * Views employee's PTO (Paid Time Off) information.
     */
    void viewEmployeePTO();

    /**
     * Views the PTO calendar.
     */
    void viewPTOCalendar();
}
