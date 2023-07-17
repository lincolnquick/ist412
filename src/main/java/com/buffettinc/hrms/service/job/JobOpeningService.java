package com.buffettinc.hrms.service.job;

import com.buffettinc.hrms.model.job.JobOpening;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing {@link JobOpening}s in Buffett Inc.
 * Defines methods to create, retrieve, update, and delete job openings.
 * Provides operations related to job openings.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface JobOpeningService {

    /**
     * Create a new job opening with the specified details.
     *
     * @param title        the title of the job opening
     * @param department   the department of the job opening
     * @param description  the description of the job opening
     * @param postingDate  the posting date of the job opening
     * @return the created job opening
     */
    JobOpening createJobOpening(String title, String department, String description, LocalDate postingDate);

    /**
     * Get a job opening by its unique ID.
     *
     * @param jobID  the ID of the job opening
     * @return the job opening with the specified ID, or null if not found
     */
    JobOpening getJobOpeningByID(UUID jobID);

    /**
     * Get all job openings.
     *
     * @return a list of all job openings
     */
    List<JobOpening> getAllJobOpenings();

    /**
     * Update a job opening with new details.
     *
     * @param jobID         the ID of the job opening to update
     * @param title         the new title of the job opening
     * @param department    the new department of the job opening
     * @param description   the new description of the job opening
     * @param postingDate   the new posting date of the job opening
     * @return the updated job opening, or null if the job opening with the specified ID is not found
     */
    JobOpening updateJobOpening(UUID jobID, String title, String department, String description, LocalDate postingDate);

    /**
     * Delete a job opening with the specified ID.
     *
     * @param jobID  the ID of the job opening to delete
     * @return true if the job opening is successfully deleted, false otherwise
     */
    boolean deleteJobOpening(UUID jobID);
}
