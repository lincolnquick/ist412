package com.buffettinc.hrms.model;

import java.net.URL;
import java.time.Duration;
import java.util.UUID;

/**
 * This class represents a Training Module to be used by employees of Buffett Inc.
 * Each TrainingModule consists of a trainingID, a name, description, the URL to view the training, its estimated
 * duration (time to complete by an employee), and the employeeID of the author.
 */
public class TrainingModule {
    private UUID trainingID;
    private String trainingName;
    private String description;
    private URL trainingURL;
    private Duration estimatedDuration;
    private UUID authorID;

    public TrainingModule(UUID trainingID, String trainingName, String description, URL trainingURL, Duration estimatedDuration, UUID authorID) {
        this.trainingID = trainingID;
        this.trainingName = trainingName;
        this.description = description;
        this.trainingURL = trainingURL;
        this.estimatedDuration = estimatedDuration;
        this.authorID = authorID;
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
