package com.buffett.hrms.model.payroll;

import java.util.List;

import com.buffett.hrms.payroll.model.payroll.PayPeriod;

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

