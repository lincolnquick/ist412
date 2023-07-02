package com.buffettinc.hrms.model;

import java.net.URL;
import java.util.UUID;

/**
 * This class represents a prospective Employee of Buffett Inc. who has submitted a job application.
 */
public class Applicant {
    private UUID applicantID;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private JobApplication.JobApplicationStatus status; // Status of the application
    private UUID jobID; // ID of the job applied for
    private URL resume; // Link of the applicant's resume

    public Applicant(String firstName, String lastName, String streetAddress, String city, String state, String zip, String phone, String email, JobApplication.JobApplicationStatus status, UUID jobID, URL resume) {
        this.applicantID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.status = status;
        this.jobID = jobID;
        this.resume = resume;
    }

    public UUID getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(UUID applicantID) {
        this.applicantID = applicantID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public JobApplication.JobApplicationStatus getStatus() {
        return status;
    }

    public void setStatus(JobApplication.JobApplicationStatus status) {
        this.status = status;
    }

    public UUID getJobID() {
        return jobID;
    }

    public void setJobID(UUID jobID) {
        this.jobID = jobID;
    }

    public URL getResume() {
        return resume;
    }

    public void setResume(URL resume) {
        this.resume = resume;
    }
}
