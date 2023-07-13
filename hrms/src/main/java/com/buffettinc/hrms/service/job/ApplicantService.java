package com.buffettinc.hrms.service.job;

import com.buffettinc.hrms.model.job.Applicant;

import java.net.URL;
import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing job applicants.
 * Provides methods to perform operations related to job applicants.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface ApplicantService {

    /**
     * Create a new applicant with the given details.
     *
     * @param firstName     the first name of the applicant
     * @param lastName      the last name of the applicant
     * @param streetAddress the street address of the applicant
     * @param city          the city of the applicant
     * @param state         the state of the applicant
     * @param zip           the ZIP code of the applicant
     * @param phone         the phone number of the applicant
     * @param email         the email address of the applicant
     * @param jobID         the ID of the job applied for
     * @param resume        the URL of the applicant's resume
     * @return the created applicant
     */
    Applicant createApplicant(String firstName, String lastName, String streetAddress, String city, String state,
                              String zip, String phone, String email, UUID jobID, URL resume);

    /**
     * Get an applicant by their ID.
     *
     * @param applicantID the ID of the applicant
     * @return the found applicant, or null if not found
     */
    Applicant getApplicantByID(UUID applicantID);

    /**
     * Get all applicants.
     *
     * @return a list of all applicants
     */
    List<Applicant> getAllApplicants();

    /**
     * Update the details of an existing applicant.
     *
     * @param applicantID   the ID of the applicant to update
     * @param firstName     the updated first name
     * @param lastName      the updated last name
     * @param streetAddress the updated street address
     * @param city          the updated city
     * @param state         the updated state
     * @param zip           the updated ZIP code
     * @param phone         the updated phone number
     * @param email         the updated email address
     * @param jobID         the updated job ID
     * @param resume        the updated resume URL
     * @return the updated applicant, or null if not found
     */
    Applicant updateApplicant(UUID applicantID, String firstName, String lastName, String streetAddress, String city,
                              String state, String zip, String phone, String email, UUID jobID, URL resume);

    /**
     * Delete an applicant by their ID.
     *
     * @param applicantID the ID of the applicant to delete
     * @return true if the applicant was successfully deleted, false otherwise
     */
    boolean deleteApplicant(UUID applicantID);
}
