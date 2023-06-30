package com.buffettinc.hrms.model;

import java.time.LocalDate;
import java.util.UUID;

public class EmployeeTrainingRecord {
    private UUID recordID;
    private UUID employeeID;
    private UUID trainingModuleID;
    private LocalDate completionDate;
    private boolean isCompleted;

    public EmployeeTrainingRecord(UUID recordID, UUID employeeID, UUID trainingModuleID) {
        this.recordID = recordID;
        this.employeeID = employeeID;
        this.trainingModuleID = trainingModuleID;
        this.completionDate = null;
        this.isCompleted = false;
    }

    public UUID getRecordID() {
        return recordID;
    }

    public void setRecordID(UUID recordID) {
        this.recordID = recordID;
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
    }

    public UUID getTrainingModuleID() {
        return trainingModuleID;
    }

    public void setTrainingModuleID(UUID trainingModuleID) {
        this.trainingModuleID = trainingModuleID;
    }

    public LocalDate getCompletionDate() {
        return completionDate;
    }

    public void setCompletionDate(LocalDate completionDate) {
        this.completionDate = completionDate;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
