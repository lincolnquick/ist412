package com.buffettinc.hrms.repository.job;

import com.buffettinc.hrms.model.job.JobApplication;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This is the repository interface for the {@link JobApplication} entity.
 * It extends {@link JpaRepository} to provide methods for CRUD operations.
 * Additional query methods can be defined here as needed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface JobApplicationRepository extends JpaRepository<JobApplication, UUID> {
    Optional<Object> findByJobOpeningIDAndApplicantID(UUID jobOpeningID, UUID applicantID);

    List<JobApplication> findByApplicantID(UUID applicantID);

    List<JobApplication> findByJobOpeningID(UUID jobOpeningID);

    List<JobApplication> findByStatus(JobApplication.JobApplicationStatus status);
    // custom methods if necessary
}