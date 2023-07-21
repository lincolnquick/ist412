package com.buffettinc.hrms.model.pto;

import com.buffettinc.hrms.model.employee.Employee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents a PTORequest to be used by {@link Employee} of Buffett Inc.
 * Each PTORequest consists of a reference to the employee with their employeeID,
 * the start date of the request, end date, a reason, a status, and a reference to the approver.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="ptorequest")
public class PTORequest implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long requestID;
    @ManyToOne
    @JoinColumn(name="employeeID")
    private Employee employee;
    @Column(name="start")
    private LocalDate startDate;
    @Column(name="end")
    private LocalDate endDate;
    @Column(name="reason")
    private PTOReason reason;
    @Column(name="status")
    private PTOStatus status;
    @ManyToOne
    @JoinColumn(name="approver")
    private Employee approver;

    @ManyToOne
    @JoinColumn(name="calendarID")
    private PTOCalendar ptoCalendar;

    public PTORequest(Employee employee, LocalDate startDate, LocalDate endDate, PTOReason reason) {
        this.requestID = ThreadLocalRandom.current().nextLong(1, 1000);
        this.employee = employee;
        this.startDate = startDate;
        this.endDate = endDate;
        this.reason = reason;
        this.status = PTOStatus.PENDING;
        this.approver = null;
        this.ptoCalendar = null;
    }

    public PTORequest() {
        this.requestID = ThreadLocalRandom.current().nextLong(1, 1000);
        this.employee = null;
        this.startDate = LocalDate.MIN;
        this.endDate = LocalDate.MIN;
        this.reason = null;
        this.status = PTOStatus.PENDING;
        this.approver = null;
        this.ptoCalendar = null;
    }

    public Long getRequestID() {
        return requestID;
    }

    public void setRequestID(Long requestID) {
        this.requestID = requestID;
    }

    public Employee getEmployeeID() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public Employee getApprover() {
        return approver;
    }

    public void setApprover(Employee approver) {
        this.approver = approver;
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

    public PTOCalendar getPtoCalendar() {
        return ptoCalendar;
    }

    public void setPtoCalendar(PTOCalendar ptoCalendar) {
        this.ptoCalendar = ptoCalendar;
    }
}



