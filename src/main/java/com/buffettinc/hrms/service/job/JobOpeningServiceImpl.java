package com.buffettinc.hrms.service.job;

import com.buffettinc.hrms.model.job.JobOpening;
import com.buffettinc.hrms.repository.job.JobOpeningRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Service implementation for managing {@link JobOpening} in Buffett Inc.
 * Implements methods to create, retrieve, update, and delete job openings.
 * Provides operations related to job openings.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class JobOpeningServiceImpl implements JobOpeningService {

    private final JobOpeningRepository jobOpeningRepository;

    @Autowired
    public JobOpeningServiceImpl(JobOpeningRepository jobOpeningRepository) {
        this.jobOpeningRepository = jobOpeningRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JobOpening createJobOpening(String title, String department, String description, LocalDate postingDate) {
        JobOpening jobOpening = new JobOpening(title, department, description, postingDate);
        return jobOpeningRepository.save(jobOpening);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JobOpening getJobOpeningByID(UUID jobID) {
        return jobOpeningRepository.findById(jobID).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<JobOpening> getAllJobOpenings() {
        return jobOpeningRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public JobOpening updateJobOpening(UUID jobID, String title, String department, String description, LocalDate postingDate) {
        JobOpening jobOpening = jobOpeningRepository.findById(jobID).orElse(null);
        if (jobOpening != null) {
            jobOpening.setTitle(title);
            jobOpening.setDepartment(department);
            jobOpening.setDescription(description);
            jobOpening.setPostingDate(postingDate);
            return jobOpeningRepository.save(jobOpening);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteJobOpening(UUID jobID) {
        JobOpening jobOpening = jobOpeningRepository.findById(jobID).orElse(null);
        if (jobOpening != null) {
            jobOpeningRepository.delete(jobOpening);
            return true;
        }
        return false;
    }
}
