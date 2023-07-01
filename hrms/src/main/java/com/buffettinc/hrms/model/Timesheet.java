package com.buffettinc.hrms.model;

import java.time.*;
import java.util.*;

/**
 * This class represents a Timesheet to be used by Employees of Buffett Inc.
 * Each timesheet consists of a reference to the Employee with their employeeID, the pay period start date, end date,
 * a list of ShiftEntries representing individual shifts by a single Employee, whether the Timesheet was approved,
 * and the employeeID of the approver.
 *
 */
public class Timesheet {
    private UUID employeeID;
    private LocalDate periodStart;
    private LocalDate periodEnd;
    private ArrayList<ShiftEntry> shifts;
    private boolean isApproved;
    private UUID approverID;

    public Timesheet(UUID employeeID, LocalDate periodStart, LocalDate periodEnd) {
        this.employeeID = employeeID;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.shifts = new ArrayList<>();
        this.isApproved = false;
        this.approverID = null;
    }

    public void addShift(ShiftEntry shift){
        shifts.add(shift);
    }

    public void removeShift(ShiftEntry shift){
        shifts.remove(shift);
    }

    public void approveTimesheet(UUID managerID){
        this.isApproved = true;
        this.approverID = managerID;
    }

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
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

    public UUID getApproverID() {
        return approverID;
    }

    public void setApproverID(UUID approverID) {
        this.approverID = approverID;
    }
}
