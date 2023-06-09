package com.buffett.hrms.model;

import java.util.UUID;

/**
 * Represents a single hourly employee in the HRMS.
 * 
 * @author Group5
 * @version 1.0.0
 * 
 */
public class Employee {
    /**
     * The employee's unique identifier.
     */
    private UUID employeeId;

    /**
     * The employee's first name.
     */
    private String firstName;

    /**
     * The employee's last name.
     */
    private String lastName;

    /**
     * The employee's hourly rate of pay in USD
     */
    private double hourlyRate;

    /**
     * Creates a new employee with the given employeeId, firstName, lastName, and hourlyRate.
     * @param employeeId the unique identifier for the employee
     * @param firstName the employee's first name
     * @param lastName the employee's last name
     * @param hourlyRate the employee's hourly rate of pay in USD
     */
    public Employee(String firstName, String lastName, double hourlyRate) {
        this.employeeId = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.hourlyRate = hourlyRate;
    }

    /**
     * Returns the employee's unique identifier.
     * @return  the employee's unique identifier
     */
    public UUID getEmployeeId() {
        return employeeId;
    }

    /**
     * Sets the employee's unique identifier.
     * @param employeeId the employee's unique identifier
     */
    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    /**
     * Returns the employee's first name.
     * @return  the employee's first name
     */
    public String getFirstName() {
        return firstName;
    }

    /**
     * Sets the employee's first name.
     * @param firstName    the employee's first name
     */
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    /**
     * Returns the employee's last name.
     * @return  the employee's last name
     */
    public String getLastName() {
        return lastName;
    }

    /**
     * Sets the employee's last name.
     * @param lastName  the employee's last name
     */
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    /**
     * Returns the employee's hourly rate of pay in USD.
     * @return  the employee's hourly rate of pay in USD
     */
    public double getHourlyRate() {
        return hourlyRate;
    }

    /**
     * Sets the employee's hourly rate of pay in USD.
     * @param hourlyRate the employee's hourly rate of pay in USD
     */
    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    
}
