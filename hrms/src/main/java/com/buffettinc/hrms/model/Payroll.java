package com.buffettinc.hrms.model;

import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents the Payroll information for an Employee of Buffett Inc.
 * Each Payroll object consists of a reference to the employee with an employeeID,
 * the employee's hourly rate, their direct deposit information including the institution name, routing number,
 * and account number, and a list of all the employee's timesheets.
 */
public class Payroll {
    private UUID employeeID;
    private float hourlyRate;
    private String institutionName;
    private String routingNumber;
    private String accountNumber;
    private ArrayList<Timesheet> timesheetList;

    public Payroll(UUID employeeID, float hourlyRate, String institutionName, String routingNumber, String accountNumber) {
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
        this.institutionName = institutionName;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
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
