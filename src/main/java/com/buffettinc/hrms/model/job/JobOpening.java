package com.buffettinc.hrms.model.job;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;
import java.time.LocalDate;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents a job opening for Buffett Inc.
 * A job opening consists of a jobID, a title, department, description, and posting date.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="jobOpening")
public class JobOpening implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long jobID;
    @Column(name="title")
    private String title;
    @Column(name="deptartment")
    private String department;
    @Column(name="description")
    private String description;
    @Column(name="date")
    private LocalDate postingDate;

    public JobOpening(String title, String department, String description, LocalDate postingDate) {
        this.jobID = ThreadLocalRandom.current().nextLong(1, 1000);
        this.title = title;
        this.department = department;
        this.description = description;
        this.postingDate = postingDate;
    }

    public JobOpening() {
        this.jobID = ThreadLocalRandom.current().nextLong(1, 1000);
        this.title = null;
        this.department = null;
        this.description = null;
        this.postingDate = LocalDate.MIN;
    }

    public Long getJobID() {
        return jobID;
    }

    public void setJobID(Long jobID) {
        this.jobID = jobID;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getPostingDate() {
        return postingDate;
    }

    public void setPostingDate(LocalDate postingDate) {
        this.postingDate = postingDate;
    }
}
