package com.buffettinc.hrms.model.job;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a single Job Application submited for a prospective Employee of Buffett Inc.
 * Each JobApplication consists of an applicationID, jobID, applicantID, applicationDate, and ApplicationStatus.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="jobApplication")
public class JobApplication implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID applicationID;
    @Column(name="jobOpeningID")
    private UUID jobOpeningID;
    @Column(name="applicant")
    private UUID applicantID;
    @Column(name="date")
    private LocalDate applicationDate;
    @Column(name="status")
    private JobApplicationStatus status;

    public JobApplication(UUID jobOpeningID, UUID applicantID, LocalDate applicationDate, JobApplicationStatus status) {
        this.applicationID = UUID.randomUUID();
        this.jobOpeningID = jobOpeningID;
        this.applicantID = applicantID;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    public JobApplication() {
        this.applicationID = UUID.randomUUID();
        this.jobOpeningID = null;
        this.applicantID = null;
        this.applicationDate = null;
        this.status = JobApplicationStatus.SUBMITTED;
    }

    public UUID getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(UUID applicationID) {
        this.applicationID = applicationID;
    }

    public UUID getJobOpeningID() {
        return jobOpeningID;
    }

    public void setJobOpeningID(UUID jobID) {
        this.jobOpeningID = jobID;
    }

    public UUID getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(UUID applicantID) {
        this.applicantID = applicantID;
    }

    public LocalDate getApplicationDate() {
        return applicationDate;
    }

    public void setApplicationDate(LocalDate applicationDate) {
        this.applicationDate = applicationDate;
    }

    public JobApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(JobApplicationStatus status) {
        this.status = status;
    }

    public enum JobApplicationStatus {
        SUBMITTED, IN_REVIEW_BY_HR, APPROVED_BY_HR, DENIED_BY_HR, IN_REVIEW_BY_MANAGER, APPROVED_BY_MANAGER,
        DENIED_BY_MANAGER, PENDING_INTERVIEW, DECLINED, ACCEPTED
    }
}
