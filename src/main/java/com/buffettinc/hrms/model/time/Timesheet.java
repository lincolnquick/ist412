package com.buffettinc.hrms.model.time;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.payroll.Payroll;
import com.buffettinc.hrms.model.time.ShiftEntry;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.*;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents a Timesheet to be used by {@link Employee} of Buffett Inc.
 * Each timesheet consists of a reference to the Employee with their employeeID, the pay period start date, end date,
 * a list of ShiftEntries representing individual {@link ShiftEntry} by a single Employee, whether the Timesheet
 * was approved, and a reference of the approver.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="timesheet")
public class Timesheet implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long timesheetID;
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
        this.payroll = payroll;
        this.periodStart = periodStart;
        this.periodEnd = periodEnd;
        this.shifts = new ArrayList<>();
        this.isApproved = false;
        this.approver = null;
    }

    public Timesheet() {
        this.payroll = null;
        this.periodStart = null;
        this.periodEnd = null;
        this.shifts = new ArrayList<>();
        this.isApproved = false;
        this.approver = null;
    }

    public Long getTimesheetID() {
        return timesheetID;
    }

    public void setTimesheetID(Long timesheetID) {
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
