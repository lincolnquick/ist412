package com.buffett.hrms.model.payroll;
import java.time.LocalDate;

/**
 * Represents a timesheet for an employee for one pay period.
 */
public class Timesheet {
    private LocalDate startDate;
    private LocalDate endDate;
    private double hoursWorked;
    private double hourlyRate;

    public Timesheet(LocalDate startDate, LocalDate endDate, double hoursWorked, double hourlyRate) {
        this.startDate = startDate;
        this.endDate = endDate;
        this.hoursWorked = hoursWorked;
        this.hourlyRate = hourlyRate;
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

    public double getHoursWorked() {
        return hoursWorked;
    }

    public void setHoursWorked(double hoursWorked) {
        this.hoursWorked = hoursWorked;
    }

    public double getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(double hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    




}
