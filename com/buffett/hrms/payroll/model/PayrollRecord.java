package com.buffett.hrms.payroll.model;

import java.util.List;

/**
 * Represents a payroll record for an employee.
 */
public class PayrollRecord {
    private String employeeId;
    private List<PayPeriod> payPeriods;

    public String getEmployeeId() {
        return employeeId;
    }
    public void setEmployeeId(String employeeId) {
        this.employeeId = employeeId;
    }
    public List<PayPeriod> getPayPeriods() {
        return payPeriods;
    }
    public void setPayPeriods(List<PayPeriod> payPeriods) {
        this.payPeriods = payPeriods;
    }

    
}

