package com.buffettinc.hrms.model;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.*;
import java.util.*;

/**
 * This class represents a Timesheet to be used by Employees of Buffett Inc.
 * Each timesheet consists of a reference to the Employee with their employeeID, the pay period start date, end date,
 * a list of ShiftEntries representing individual shifts by a single Employee, whether the Timesheet was approved,
 * and the employeeID of the approver.
 *
 */
@Entity
@Table(name="timesheet")
public class Timesheet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID timesheetID;
    @ManyToOne
    @JoinColumn(name="payrollID")
    private Payroll payroll;
    @Column(name = "start")
    private LocalDate periodStart;
    @Column(name = "end")
    private LocalDate periodEnd;
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(
            name = "timesheet_shifts",
            joinColumns = {@JoinColumn(name="timesheet_id", referencedColumnName = "timesheetID")},
            inverseJoinColumns = {@JoinColumn(name = "shift_id", referencedColumnName = "shiftID")}
    )
    private List<ShiftEntry> shifts;
    @Column(name="approved")
    private boolean isApproved;
    @ManyToOne
    @JoinColumn(name = "approverID")
    private Employee approver;

    public Timesheet(Payroll payroll, LocalDate periodStart, LocalDate periodEnd) {
        this.timesheetID = UUID.randomUUID();
        this.payroll = payroll;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.shifts = new ArrayList<>();
        this.isApproved = false;
        this.approver = null;
    }

    public Timesheet() {
        this.timesheetID = UUID.randomUUID();
        this.payroll = null;
        this.periodStart = null;
        this.periodEnd = null;
        this.shifts = new ArrayList<>();
        this.isApproved = false;
        this.approver = null;
    }

    public UUID getTimesheetID() {
        return timesheetID;
    }

    public void setTimesheetID(UUID timesheetID) {
        this.timesheetID = timesheetID;
    }

    public void addShift(ShiftEntry shift){
        shifts.add(shift);
    }

    public void removeShift(ShiftEntry shift){
        shifts.remove(shift);
    }

    public void approveTimesheet(Employee manager){
        this.isApproved = true;
        this.approver = manager;
    }

    public Payroll getPayroll() {
        return payroll;
    }

    public void setPayroll(Payroll payroll) {
        this.payroll = payroll;
    }

    public void setShifts(List<ShiftEntry> shifts) {
        this.shifts = shifts;
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

    public List<ShiftEntry> getShifts() {
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

    public Employee getApprover() {
        return approver;
    }

    public void setApprover(Employee approver) {
        this.approver = approver;
    }
}
