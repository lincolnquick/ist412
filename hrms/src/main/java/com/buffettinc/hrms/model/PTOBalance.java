package com.buffettinc.hrms.model;

public class PTOBalance {
    private float vacationTime;
    private float personalTime;
    private float sickTime;

    public PTOBalance(float vacationTime, float personalTime, float sickTime) {
        this.vacationTime = vacationTime;
        this.personalTime = personalTime;
        this.sickTime = sickTime;
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
