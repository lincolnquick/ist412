package com.buffettinc.hrms.service;

import com.buffettinc.hrms.model.job.JobApplication;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface represents the service contract for handling {@link JobApplication}s at Buffett Inc.
 * It declares all the necessary CRUD operations related to JobApplication along with some additional methods.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface JobApplicationService {

    /**
     * Saves a new job application or updates an existing one.
     *
     * @param jobApplication the job application to save or update.
     * @return the saved or updated job application.
     */
    JobApplication saveOrUpdateJobApplication(JobApplication jobApplication);

    /**
     * Fetches a job application by its id.
     *
     * @param applicationID the id of the job application to fetch.
     * @return an Optional of the job application if found, or an empty Optional if not.
     */
    Optional<JobApplication> getJobApplicationById(Long applicationID);

    /**
     * Fetches all job applications.
     *
     * @return a list of all job applications.
     */
    List<JobApplication> getAllJobApplications();

    /**
     * Deletes a job application by its id.
     *
     * @param applicationID the id of the job application to delete.
     */
    void deleteJobApplication(Long applicationID);

    /**
     * Fetches all job applications by their status.
     *
     * @param status the status of the job applications to fetch.
     * @return a list of job applications with the given status.
     */
    List<JobApplication> getJobApplicationsByStatus(JobApplication.JobApplicationStatus status);

    /**
     * Fetches all job applications for a particular job opening.
     *
     * @param jobOpeningID the id of the job opening.
     * @return a list of job applications for the job opening.
     */
    List<JobApplication> getJobApplicationsForJobOpening(Long jobOpeningID);

    /**
     * Fetches all job applications submitted by a particular applicant.
     *
     * @param applicantID the id of the applicant.
     * @return a list of job applications submitted by the applicant.
     */
    List<JobApplication> getJobApplicationsByApplicant(Long applicantID);
}
