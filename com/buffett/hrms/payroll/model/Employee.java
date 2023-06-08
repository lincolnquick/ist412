package com.buffett.hrms.payroll.model;

/**
 * Represents an hourly employee
 */
public class Employee {
    private String employeeId;
    private String firstName;
    private String lastName;
    private double hourlyRate;

    public Employee(String employeeId, String firstName, String lastName, double hourlyRate) {
        this.employeeId = employeeId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
    }

    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public String getFirstName() {
        return firstName;
    }
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
    public String getLastName() {
        return lastName;
    }
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public double getHourlyRate() {
        return hourlyRate;
    }
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    
}
