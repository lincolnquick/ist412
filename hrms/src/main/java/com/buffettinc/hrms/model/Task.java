package com.buffettinc.hrms.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a Task to be assigned by a Manager to an Employee of Buffett Inc.
 * Each Task consists of a taskID, a name, description, dueDate, a reference to the assigned, and to the assigned employee,
 * and whether the task was completed.
 */
public class Task {
    private UUID taskID;
    private String name;
    private String description;
    private LocalDate dueDate;
    private UUID assignedBy;
    private UUID assignedTo;
    private boolean isCompleted;

    public Task(String name, String description, LocalDate dueDate, UUID assignedBy, UUID assignedTo) {
        this.taskID = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.assignedBy = assignedBy;
        this.assignedTo = assignedTo;
        this.isCompleted = false;
    }

    public UUID getTaskID() {
        return taskID;
    }

    public void setTaskID(UUID taskID) {
        this.taskID = taskID;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public UUID getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(UUID assignedBy) {
        this.assignedBy = assignedBy;
    }

    public UUID getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(UUID assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
