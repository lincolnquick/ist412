package com.buffettinc.hrms.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.net.URL;
import java.time.Duration;
import java.util.UUID;

/**
 * This class represents a Training Module to be used by {@link Employee} of Buffett Inc.
 * Each TrainingModule consists of a trainingID, a name, description, the URL to view the training, its estimated
 * duration (time to complete by an employee), and the employeeID of the author.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="trainingModule")
public class TrainingModule implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID trainingID;
    @Column(name="name")
    private String trainingName;
    @Column(name="description")
    private String description;
    @Column(name="url")
    private URL trainingURL;
    @Column(name="duration")
    private Duration estimatedDuration;
    @Column(name="author")
    private UUID authorID;

    public TrainingModule(String trainingName, String description, URL trainingURL, Duration estimatedDuration, UUID authorID) {
        this.trainingID = UUID.randomUUID();
        this.trainingName = trainingName;
        this.description = description;
        this.trainingURL = trainingURL;
        this.estimatedDuration = estimatedDuration;
        this.authorID = authorID;
    }

    public TrainingModule() {
        this.trainingID = UUID.randomUUID();
        this.trainingName = null;
        this.description = null;
        this.trainingURL = null;
        this.estimatedDuration = Duration.ZERO;
        this.authorID = null;
    }

    public UUID getTrainingID() {
        return trainingID;
    }

    public void setTrainingID(UUID trainingID) {
        this.trainingID = trainingID;
    }

    public String getTrainingName() {
        return trainingName;
    }

    public void setTrainingName(String trainingName) {
        this.trainingName = trainingName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public URL getTrainingURL() {
        return trainingURL;
    }

    public void setTrainingURL(URL trainingURL) {
        this.trainingURL = trainingURL;
    }

    public Duration getEstimatedDuration() {
        return estimatedDuration;
    }

    public void setEstimatedDuration(Duration estimatedDuration) {
        this.estimatedDuration = estimatedDuration;
    }

    public UUID getAuthorID() {
        return authorID;
    }

    public void setAuthorID(UUID authorID) {
        this.authorID = authorID;
    }
}
