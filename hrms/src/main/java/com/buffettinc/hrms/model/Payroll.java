package com.buffettinc.hrms.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
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
    private UUID employeeID;
    @Column(name="hourlyRate")
    private float hourlyRate;
    @Column(name="institution")
    private String institutionName;
    @Column(name="routing")
    private String routingNumber;
    @Column(name="account")
    private String accountNumber;
    @ManyToMany (cascade = CascadeType.MERGE)
    @JoinTable(name = "payroll_timesheets",
        joinColumns = {@JoinColumn(name= "employeeID")},
            inverseJoinColumns = {@JoinColumn(name = "employeeID")})

    private ArrayList<Timesheet> timesheetList;

    public Payroll(UUID employeeID, float hourlyRate, String institutionName, String routingNumber, String accountNumber) {
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
        this.institutionName = institutionName;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.timesheetList = new ArrayList<>();
    }

    public Payroll() {
        this.employeeID = null;
        this.hourlyRate = 0.0f;
        this.institutionName = null;
        this.routingNumber = null;
        this.accountNumber = null;
        this.timesheetList = new ArrayList<>();
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
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
