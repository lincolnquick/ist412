package com.buffettinc.hrms.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represents a Notification sent within Buffett Inc's HRMS to an Employee.
 */
@Entity
@Table(name="notification")
public class Notification implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID notificationID;
    @Column(name="employee")
    private UUID employeeID;
    @Column(name="message")
    private String message;
    @Column(name="timestamp")
    private LocalDateTime timestamp;

    public Notification(UUID employeeID, String message) {
        this.notificationID = UUID.randomUUID();
        this.employeeID = employeeID;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public Notification() {
        this.notificationID = UUID.randomUUID();
        this.employeeID = null;
        this.message = null;
        this.timestamp = LocalDateTime.now();
    }

    public UUID getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(UUID notificationID) {
        this.notificationID = notificationID;
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }
}
