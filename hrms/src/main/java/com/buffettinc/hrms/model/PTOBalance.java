package com.buffettinc.hrms.model;

import java.util.UUID;

/**
 * This class represents an object to keep track of an Employee's PTO (paid time off) balances for Buffett Inc.
 * Each PTOBalance object consists of a reference to the employee with the employeeID,
 * vacationTime, personalTime, and sickTime, as well as methods to accrue and use each time.
 *
 */
public class PTOBalance {
    private UUID employeeID;
    private float vacationTime;
    private float personalTime;
    private float sickTime;

    public PTOBalance(UUID employeeID, float vacationTime, float personalTime, float sickTime) {
        this.employeeID = employeeID;
        this.vacationTime = vacationTime;
        this.personalTime = personalTime;
        this.sickTime = sickTime;
    }
    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
    }

    public float getVacationTime() {
        return vacationTime;
    }

    public void setVacationTime(float vacationTime) {
        this.vacationTime = vacationTime;
    }

    public float getPersonalTime() {
        return personalTime;
    }

    public void setPersonalTime(float personalTime) {
        this.personalTime = personalTime;
    }

    public float getSickTime() {
        return sickTime;
    }

    public void setSickTime(float sickTime) {
        this.sickTime = sickTime;
    }

    // Methods to use time
    public void useVacationTime(float hours) {
        if (hours <= vacationTime) {
            vacationTime -= hours;
        } else {
            throw new IllegalArgumentException("Insufficient vacation time available.");
        }
    }

    public void usePersonalTime(float hours) {
        if (hours <= personalTime) {
            personalTime -= hours;
        } else {
            throw new IllegalArgumentException("Insufficient personal time available.");
        }
    }

    public void useSickTime(float hours) {
        if (hours <= sickTime) {
            sickTime -= hours;
        } else {
            throw new IllegalArgumentException("Insufficient sick time available.");
        }
    }

    // Methods to accrue time
    public void accrueVacationTime(float hours) {
        vacationTime += hours;
    }

    public void accruePersonalTime(float hours) {
        personalTime += hours;
    }

    public void accrueSickTime(float hours) {
        sickTime += hours;
    }
}
