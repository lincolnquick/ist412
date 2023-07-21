package com.buffettinc.hrms.service.job;

import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.repository.employee.ManagerRepository;
import com.buffettinc.hrms.repository.job.JobApplicationRepository;
import com.buffettinc.hrms.service.JobApplicationService;
import com.buffettinc.hrms.service.employee.HRStaffService;
import com.buffettinc.hrms.service.employee.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class is the implementation of the JobApplicationService interface for handling job applications at Buffett Inc.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class JobApplicationServiceImpl implements JobApplicationService {

    @Autowired
    private JobApplicationRepository jobApplicationRepository;

    @Autowired
    private JobOpeningService jobOpeningService;

    @Autowired
    private ManagerService managerService;

    @Autowired
    private ManagerRepository managerRepository;

    @Autowired
    private ApplicantService applicantService;

    @Autowired
    private HRStaffService hrStaffService;

    public void submitApplication(JobApplication jobApplication){
        // Save application to the database
        JobApplication savedApplication = jobApplicationRepository.save(jobApplication);

        // Add observers - all Managers in same department
        Long jobOpeningID = savedApplication.getJobOpeningID();
        String department = jobOpeningService.getJobOpeningByID(jobOpeningID).get().getDepartment();
        managerService.registerObservers(managerRepository.findAllByDepartment(department));

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JobApplication saveOrUpdateJobApplication(JobApplication jobApplication) {
        return jobApplicationRepository.save(jobApplication);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<JobApplication> getJobApplicationById(Long applicationID) {
        return jobApplicationRepository.findById(applicationID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<JobApplication> getAllJobApplications() {
        return jobApplicationRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteJobApplication(Long applicationID) {
        jobApplicationRepository.deleteById(applicationID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<JobApplication> getJobApplicationsByStatus(JobApplication.JobApplicationStatus status) {
        return jobApplicationRepository.findByStatus(status);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<JobApplication> getJobApplicationsForJobOpening(Long jobOpeningID) {
        return jobApplicationRepository.findByJobOpeningID(jobOpeningID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<JobApplication> getJobApplicationsByApplicant(Long applicantID) {
        return jobApplicationRepository.findByApplicantID(applicantID);
    }
}
