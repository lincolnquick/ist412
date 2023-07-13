package com.buffettinc.hrms.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * This class represents a Notification sent within Buffett Inc's HRMS to an {@link Employee}.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="notification")
public class Notification implements Serializable {
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID notificationID;
    @ManyToOne
    @JoinColumn(name="employee", referencedColumnName = "employeeID")
    private Employee employee;
    @Column(name="message")
    private String message;
    @Column(name="timestamp")
    private LocalDateTime timestamp;

    public Notification(Employee employee, String message) {
        this.notificationID = UUID.randomUUID();
        this.employee = employee;
        this.message = message;
        this.timestamp = LocalDateTime.now();
    }

    public Notification() {
        this.notificationID = UUID.randomUUID();
        this.employee = null;
        this.message = null;
        this.timestamp = LocalDateTime.now();
    }

    public UUID getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(UUID notificationID) {
        this.notificationID = notificationID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
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
