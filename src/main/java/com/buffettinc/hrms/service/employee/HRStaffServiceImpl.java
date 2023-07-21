package com.buffettinc.hrms.service.employee;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.HRStaff;
import com.buffettinc.hrms.model.job.Applicant;
import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.model.job.JobOpening;
import com.buffettinc.hrms.model.training.TrainingModule;
import com.buffettinc.hrms.repository.employee.HRStaffRepository;
import com.buffettinc.hrms.repository.job.ApplicantRepository;
import com.buffettinc.hrms.repository.job.JobApplicationRepository;
import com.buffettinc.hrms.repository.job.JobOpeningRepository;
import com.buffettinc.hrms.repository.training.TrainingModuleRepository;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.UUID;

/**
 * Implementation of the {@link HRStaffService} interface.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class HRStaffServiceImpl implements HRStaffService {

    private final HRStaffRepository hrStaffRepository;
    private final TrainingModuleRepository trainingModuleRepository;
    private final JobOpeningRepository jobOpeningRepository;
    private final ApplicantRepository applicantRepository;
    private final JobApplicationRepository jobApplicationRepository;

    /**
     * {@inheritDoc}
     */
    public HRStaffServiceImpl(HRStaffRepository hrStaffRepository, TrainingModuleRepository trainingModuleRepository,
                              JobOpeningRepository jobOpeningRepository, ApplicantRepository applicantRepository,
                              JobApplicationRepository jobApplicationRepository) {
        this.hrStaffRepository = hrStaffRepository;
        this.trainingModuleRepository = trainingModuleRepository;
        this.jobOpeningRepository = jobOpeningRepository;
        this.applicantRepository = applicantRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public TrainingModule addTrainingModule(String title, String description, URL trainingURL, Duration eta) {
        TrainingModule newTraining = new TrainingModule(title, description, trainingURL, eta, null);
        trainingModuleRepository.save(newTraining);
        return newTraining;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public JobOpening postJobOpening(String title, String department, String description, LocalDate postingDate) {
        JobOpening newOpening = new JobOpening(title, department, description, postingDate);
        jobOpeningRepository.save(newOpening);
        return newOpening;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public Applicant addNewApplicant(String firstName, String lastName, String streetAddress, String city, String state,
                                     String zip, String phone, String email, String status, Long jobID, URL resume) {
        Applicant newApplicant = new Applicant(firstName, lastName, streetAddress, city, state, zip, phone, email,
                JobApplication.JobApplicationStatus.SUBMITTED, jobID, resume);
        applicantRepository.save(newApplicant);
        return newApplicant;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public JobApplication acceptApplication(Long jobID, Long applicantID) {
        JobApplication newApplication = new JobApplication(jobID, applicantID, LocalDate.now(),
                JobApplication.JobApplicationStatus.SUBMITTED);
        jobApplicationRepository.save(newApplication);
        return newApplication;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public JobApplication reviewJobApplication(Long jobID, Long applicantID) {
        return new JobApplication(jobID, applicantID, LocalDate.now(), null);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public JobApplication approveJobApplication(JobApplication application) {
        return null;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void viewEmployeeData(Employee employee) {
        // Implement the logic for viewing employee data
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void addEmployee() {
        // Implement the logic for adding a new employee
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void viewEmployeePTO() {
        // Implement the logic for viewing employee's PTO
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public void viewPTOCalendar() {
        // Implement the logic for viewing the PTO calendar
    }
}
