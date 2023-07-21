package com.buffettinc.hrms.model.pto;

import com.buffettinc.hrms.model.employee.Employee;
import jakarta.persistence.*;

import java.util.UUID;
import java.io.Serializable;

/**
 * This class represents an object to keep track of an {@link Employee}'s PTO (paid time off) balances for Buffett Inc.
 * Each PTOBalance object consists of a reference to the employee with the employeeID,
 * vacationTime, personalTime, and sickTime, as well as methods to accrue and use each time.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */

@Entity
@Table(name="ptobalance")
public class PTOBalance implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long employeeID;

    @Column(name="vacation")
    private float vacationTime;
    @Column(name="personal")
    private float personalTime;
    @Column(name="sick")
    private float sickTime;

    public PTOBalance(Long employeeID, float vacationTime, float personalTime, float sickTime) {
        this.employeeID = employeeID;
        this.vacationTime = vacationTime;
        this.personalTime = personalTime;
        this.sickTime = sickTime;
    }

    public PTOBalance() {
        this.employeeID = null;
        this.vacationTime = 0.0f;
        this.personalTime = 0.0f;
        this.sickTime = 0.0f;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(Long employeeID) {
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
