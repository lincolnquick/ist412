package com.buffett.hrms.model.payroll;

import java.util.List;
import java.util.UUID;

/**
 * Represents a payroll record for an employee.
 */
public class PayrollRecord {
    private UUID employeeId;
    private List<Timesheet> timesheets;

    public UUID getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }
    public List<Timesheet> getTimesheets() {
        return timesheets;
    }
    public void setTimesheets(List<Timesheet> timesheets) {
        this.timesheets = timesheets;
    }

    
}

