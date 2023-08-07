package com.buffettinc.hrms.model.job;

import jakarta.persistence.*;

import java.io.Serializable;
import java.net.URL;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents a prospective Employee of Buffett Inc. who has submitted a job application.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="applicant")
public class Applicant implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long applicantID;
    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="streetAddress")
    private String streetAddress;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="zip")
    private String zip;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name="status")
    private JobApplication.JobApplicationStatus status; // Status of the application
    @Column(name="job")
    private Long jobID; // ID of the job applied for
    @Column(name="resume")
    private URL resume; // Link of the applicant's resume

    public Applicant(String firstName, String lastName, String streetAddress, String city, String state, String zip, String phone, String email, JobApplication.JobApplicationStatus status, Long jobID, URL resume) {
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

    public Applicant() {
        this.firstName = null;
        this.lastName = null;
        this.streetAddress = null;
        this.city = null;
        this.state = null;
        this.zip = null;
        this.phone = null;
        this.email = null;
        this.status = JobApplication.JobApplicationStatus.SUBMITTED;
        this.jobID = null;
        this.resume = null;
    }

    public Long getApplicantID() {
        return applicantID;
    }

    public void setApplicantID(Long applicantID) {
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

    public Long getJobID() {
        return jobID;
    }

    public void setJobID(Long jobID) {
        this.jobID = jobID;
    }

    public URL getResume() {
        return resume;
    }

    public void setResume(URL resume) {
        this.resume = resume;
    }
}
