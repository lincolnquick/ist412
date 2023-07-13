package com.buffettinc.hrms.model.training;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.Manager;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a Task to be assigned by a {@link Manager} to an {@link Employee} of Buffett Inc.
 * Each Task consists of a taskID, a name, description, dueDate, a reference to the assigned, and to the assigned employee,
 * and whether the task was completed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="task")
public class Task implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID taskID;
    @Column(name="name")
    private String name;
    @Column(name="description")
    private String description;
    @Column(name="due")
    private LocalDate dueDate;
    @ManyToOne
    @JoinColumn(name="assignedBy", referencedColumnName = "employeeID")
    private Employee assignedBy;
    @ManyToOne
    @JoinColumn(name="assignedTo", referencedColumnName = "employeeID")
    private Employee assignedTo;
    @Column(name="isCompleted")
    private boolean isCompleted;

    public Task(String name, String description, LocalDate dueDate, Employee assignedBy, Employee assignedTo) {
        this.taskID = UUID.randomUUID();
        this.name = name;
        this.description = description;
        this.dueDate = dueDate;
        this.assignedBy = assignedBy;
        this.assignedTo = assignedTo;
        this.isCompleted = false;
    }

    public Task() {
        this.taskID = UUID.randomUUID();
        this.name = null;
        this.description = null;
        this.dueDate = LocalDate.MIN;
        this.assignedBy = null;
        this.assignedTo = null;
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

    public Employee getAssignedBy() {
        return assignedBy;
    }

    public void setAssignedBy(Employee assignedBy) {
        this.assignedBy = assignedBy;
    }

    public Employee getAssignedTo() {
        return assignedTo;
    }

    public void setAssignedTo(Employee assignedTo) {
        this.assignedTo = assignedTo;
    }

    public boolean isCompleted() {
        return isCompleted;
    }

    public void setCompleted(boolean completed) {
        isCompleted = completed;
    }
}
