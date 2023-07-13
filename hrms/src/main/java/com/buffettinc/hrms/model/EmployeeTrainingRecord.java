package com.buffettinc.hrms.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a single record to keep track of an employee's completion status of a training module.
 * Each EmployeeTrainingRecord consists of a recordID, a reference to the employeeID and trainingModuleID,
 * a completion date, and whether the training was completed.
 */
@Entity
@Table(name="trainingRecord")
public class EmployeeTrainingRecord implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID recordID;
    @ManyToOne
    @JoinColumn(name="employee", referencedColumnName = "employeeID")
    private Employee employee;
    @Column(name="trainingModule")
    private UUID trainingModuleID;
    @Column(name="completionDate")
    private LocalDate completionDate;
    @Column(name="isCompleted")
    private boolean isCompleted;

    public EmployeeTrainingRecord(Employee employee, UUID trainingModuleID) {
        this.recordID = UUID.randomUUID();
        this.employee = employee;
        this.trainingModuleID = trainingModuleID;
        this.completionDate = null;
        this.isCompleted = false;
    }

    public EmployeeTrainingRecord() {
        this.recordID = UUID.randomUUID();
        this.employee = null;
        this.trainingModuleID = null;
        this.completionDate = null;
        this.isCompleted = false;
    }

    public UUID getRecordID() {
        return recordID;
    }

    public void setRecordID(UUID recordID) {
        this.recordID = recordID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
