package com.buffettinc.hrms.model;

import java.util.UUID;

public class Payroll {
    private UUID employeeID;
    private float hourlyRate;
    private String institutionName;
    private String routingNumber;
    private String accountNumber;

    public Payroll(UUID employeeID, float hourlyRate, String institutionName, String routingNumber, String accountNumber) {
        this.employeeID = employeeID;
        this.hourlyRate = hourlyRate;
        this.institutionName = institutionName;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
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
