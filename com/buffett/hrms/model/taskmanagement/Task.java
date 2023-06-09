package com.buffett.hrms.model.taskmanagement;

import java.time.LocalDate;
import java.util.UUID;

import com.buffett.hrms.model.Employee;

/**
 * Represents a task in the HRMS to be created, modified, and assigned by a manager to an employee.
 * 
 * @author Group 5
 * @version 1.0.0
 */
public class Task {
    private UUID taskId;
    private String taskName;
    private String taskDescription;
    private LocalDate dueDate;
    private Employee assignedEmployee;
    private TaskStatus status;
    
    public Task(String taskName, String taskDescription, LocalDate dueDate, Employee assignedEmployee, TaskStatus status) {
        this.taskId = UUID.randomUUID();
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.assignedEmployee = assignedEmployee;
        this.status = status;
    }

    public Task(String taskName, String taskDescription, LocalDate dueDate, Employee assignedEmployee){
        this.taskId = UUID.randomUUID();
        this.taskName = taskName;
        this.taskDescription = taskDescription;
        this.dueDate = dueDate;
        this.assignedEmployee = assignedEmployee;
        this.status = TaskStatus.NOT_STARTED;
    }

    public UUID getTaskId() {
        return taskId;
    }

    public void setTaskId(UUID taskId) {
        this.taskId = taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public void setTaskName(String taskName) {
        this.taskName = taskName;
    }

    public String getTaskDescription() {
        return taskDescription;
    }

    public void setTaskDescription(String taskDescription) {
        this.taskDescription = taskDescription;
    }

    public LocalDate getDueDate() {
        return dueDate;
    }

    public void setDueDate(LocalDate dueDate) {
        this.dueDate = dueDate;
    }

    public Employee getAssignedEmployee() {
        return assignedEmployee;
    }

    public void setAssignedEmployee(Employee assignedEmployee) {
        this.assignedEmployee = assignedEmployee;
    }

    public TaskStatus getStatus() {
        return status;
    }

    public void setStatus(TaskStatus status) {
        this.status = status;
    }

    
    
}

enum TaskStatus {
    NOT_STARTED, IN_PROGRESS, COMPLETED
}
