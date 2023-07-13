package com.buffettinc.hrms.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class represents the Payroll information for an Employee of Buffett Inc.
 * Each Payroll object consists of a reference to the employee with an employeeID,
 * the employee's hourly rate, their direct deposit information including the institution name, routing number,
 * and account number, and a list of all the employee's timesheets.
 */

@Entity
@Table(name="payroll")
public class Payroll implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID payrollID;

    @OneToOne
    @JoinColumn(name="employeeID")
    private Employee employee;
    @Column(name="hourlyRate")
    private float hourlyRate;
    @Column(name="institution")
    private String institutionName;
    @Column(name="routing")
    private String routingNumber;
    @Column(name="account")
    private String accountNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="payroll")
    private List<Timesheet> timesheetList;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="payroll")
    private List<Timesheet> approvedTimesheetList;

    public Payroll(Employee employee, float hourlyRate, String institutionName, String routingNumber, String accountNumber) {
        this.payrollID = UUID.randomUUID();
        this.employee = employee;
        this.hourlyRate = hourlyRate;
        this.institutionName = institutionName;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.timesheetList = new ArrayList<>();
    }

    public Payroll() {
        this.payrollID = UUID.randomUUID();
        this.employee = null;
        this.hourlyRate = 0.0f;
        this.institutionName = null;
        this.routingNumber = null;
        this.accountNumber = null;
        this.timesheetList = new ArrayList<>();
    }

    public UUID getPayrollID() {
        return payrollID;
    }

    public void setPayrollID(UUID payrollID) {
        this.payrollID = payrollID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Timesheet> getTimesheetList() {
        return timesheetList;
    }

    public void setTimesheetList(List<Timesheet> timesheetList) {
        this.timesheetList = timesheetList;
    }

    public List<Timesheet> getApprovedTimesheetList() {
        return approvedTimesheetList;
    }

    public void setApprovedTimesheetList(List<Timesheet> approvedTimesheetList) {
        this.approvedTimesheetList = approvedTimesheetList;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
