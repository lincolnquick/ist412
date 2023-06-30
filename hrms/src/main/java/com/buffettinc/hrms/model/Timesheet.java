package com.buffettinc.hrms.model;

import java.time.*;
import java.util.*;

public class Timesheet {
    private int employeeNumber;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private ArrayList<ShiftEntry> shifts;
    private boolean isApproved;
    private int approverID;

    public Timesheet(int employeeNumber, LocalDate periodStart, LocalDate periodEnd) {
        this.employeeNumber = employeeNumber;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.shifts = new ArrayList<>();
        this.isApproved = false;
        this.approverID = -1;
    }

    public void addShift(ShiftEntry shift){
        shifts.add(shift);
    }

    public void removeShift(ShiftEntry shift){
        shifts.remove(shift);
    }

    public void approveTimesheet(int managerID){
        this.isApproved = true;
        this.approverID = managerID;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public LocalDate getPeriodStart() {
        return periodStart;
    }

    public void setPeriodStart(LocalDate periodStart) {
        this.periodStart = periodStart;
    }

    public LocalDate getPeriodEnd() {
        return periodEnd;
    }

    public void setPeriodEnd(LocalDate periodEnd) {
        this.periodEnd = periodEnd;
    }

    public ArrayList<ShiftEntry> getShifts() {
        return shifts;
    }

    public void setShifts(ArrayList<ShiftEntry> shifts) {
        this.shifts = shifts;
    }

    public boolean isApproved() {
        return isApproved;
    }

    public void setApproved(boolean approved) {
        isApproved = approved;
    }

    public int getApproverID() {
        return approverID;
    }

    public void setApproverID(int approverID) {
        this.approverID = approverID;
    }
}
