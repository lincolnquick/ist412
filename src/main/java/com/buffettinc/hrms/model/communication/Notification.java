package com.buffettinc.hrms.model.communication;

import com.buffettinc.hrms.model.employee.Employee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

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
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long notificationID;
    @ManyToOne
    @JoinColumn(name="employee", referencedColumnName = "employeeID")
    private Employee employee;
    @Column(name="message")
    private String message;
    @Column(name="timestamp")
    private LocalDateTime timestamp;

    @Column(name="isRead")
    private boolean isRead;

    public Notification(Employee employee, String message) {
        this.notificationID = ThreadLocalRandom.current().nextLong(1000);
        this.employee = employee;
        this.message = message;
        this.timestamp = LocalDateTime.now();
        this.isRead = false;
    }

    public Notification() {
        this.notificationID = ThreadLocalRandom.current().nextLong(1,1000);
        this.employee = null;
        this.message = null;
        this.timestamp = LocalDateTime.now();
        this.isRead = false;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }

    public Long getNotificationID() {
        return notificationID;
    }

    public void setNotificationID(Long notificationID) {
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
