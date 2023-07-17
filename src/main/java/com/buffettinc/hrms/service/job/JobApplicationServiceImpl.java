package com.buffettinc.hrms.service.job;

import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.repository.job.JobApplicationRepository;
import com.buffettinc.hrms.service.JobApplicationService;
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
    public Optional<JobApplication> getJobApplicationById(UUID applicationID) {
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
    public void deleteJobApplication(UUID applicationID) {
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
    public List<JobApplication> getJobApplicationsForJobOpening(UUID jobOpeningID) {
        return jobApplicationRepository.findByJobOpeningID(jobOpeningID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<JobApplication> getJobApplicationsByApplicant(UUID applicantID) {
        return jobApplicationRepository.findByApplicantID(applicantID);
    }
}
