package com.buffettinc.hrms.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a single Job Application submited for a prospective Employee of Buffett Inc.
 * Each JobApplication consists of an applicationID, jobID, applicantID, applicationDate, and ApplicationStatus.
 */
public class JobApplication {

    private UUID applicationID;
    private UUID jobID;
    private UUID applicantID;
    private LocalDate applicationDate;
    private JobApplicationStatus status;

    public JobApplication(UUID jobID, UUID applicantID, LocalDate applicationDate, JobApplicationStatus status) {
        this.applicationID = UUID.randomUUID();
        this.jobID = jobID;
        this.applicantID = applicantID;
        this.applicationDate = applicationDate;
        this.status = status;
    }

    public UUID getApplicationID() {
        return applicationID;
    }

    public void setApplicationID(UUID applicationID) {
        this.applicationID = applicationID;
    }

    public UUID getJobID() {
        return jobID;
    }

    public void setJobID(UUID jobID) {
        this.jobID = jobID;
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

    enum JobApplicationStatus {
        SUBMITTED, IN_REVIEW_BY_HR, APPROVED_BY_HR, DENIED_BY_HR, IN_REVIEW_BY_MANAGER, APPROVED_BY_MANAGER,
        DENIED_BY_MANAGER, PENDING_INTERVIEW, DECLINED, ACCEPTED
    }
}
