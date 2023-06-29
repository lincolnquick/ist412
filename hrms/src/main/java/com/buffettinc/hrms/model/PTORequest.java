package com.buffettinc.hrms.model;

import java.time.LocalDate;

public class PTORequest {
    private LocalDate startDate;
    private LocalDate endDate;
    private PTOReason reason;
    private PTOStatus status;

    public PTORequest(LocalDate startDate, LocalDate endDate, PTOReason reason) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = PTOStatus.PENDING;
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
