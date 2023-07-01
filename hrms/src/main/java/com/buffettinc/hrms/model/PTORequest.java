package com.buffettinc.hrms.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a PTORequest to be used by Employees of Buffett Inc.
 * Each PTORequest consists of a reference to the employee with their employeeID,
 * the start date of the request, end date, a reason, a status, and a reference to the approver.
 */
public class PTORequest {
    private UUID employeeID;
    private LocalDate startDate;
    private LocalDate endDate;
    private PTOReason reason;
    private PTOStatus status;
    private UUID approverID;

    public PTORequest(UUID employeeID, LocalDate startDate, LocalDate endDate, PTOReason reason) {
        this.employeeID = employeeID;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = PTOStatus.PENDING;
        this.approverID = null;
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
    }

    public UUID getApproverID() {
        return approverID;
    }

    public void setApproverID(UUID approverID) {
        this.approverID = approverID;
    }

    public LocalDate getStartDate() {
        return startDate;
    }

    public void setStartDate(LocalDate startDate) {
        this.startDate = startDate;
    }

    public LocalDate getEndDate() {
        return endDate;
    }

    public void setEndDate(LocalDate endDate) {
        this.endDate = endDate;
    }

    public PTOReason getReason() {
        return reason;
    }

    public void setReason(PTOReason reason) {
        this.reason = reason;
    }

    public PTOStatus getStatus() {
        return status;
    }

    public void setStatus(PTOStatus status) {
        this.status = status;
    }
}
 enum PTOReason {
    SICK, PERSONAL, VACATION, BEREAVEMENT, JURY_DUTY, MILITARY_LEAVE, LEAVE_OF_ABSENCE
}

enum PTOStatus {
    PENDING, APPROVED, DENIED
}
