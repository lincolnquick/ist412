package com.buffettinc.hrms.model.payroll;

import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.model.employee.Employee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents the Payroll information for an {@link Employee} of Buffett Inc.
 * Each Payroll object consists of a reference to the employee with an employeeID,
 * the employee's hourly rate, their direct deposit information including the institution name, routing number,
 * and account number, and a list of all the employee's {@link Timesheet}.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */

@Entity
@Table(name="payroll")
public class Payroll implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long payrollID;

    @OneToOne
    @JoinColumn(name="employeeID")
    private Employee employee;
    @Column(name="hourlyRate")
    private float hourlyRate;
    @Column(name="institution")
    private String institutionName;
    @Column(name="routing")
    private String routingNumber;
    @Column(name="account")
    private String accountNumber;

    @OneToMany(cascade = CascadeType.ALL, mappedBy="payroll")
    private List<Timesheet> timesheetList = new ArrayList<>();

    @OneToMany(cascade = CascadeType.ALL, mappedBy="payroll")
    private List<Timesheet> approvedTimesheetList;

    public Payroll(Employee employee, float hourlyRate, String institutionName, String routingNumber, String accountNumber) {
        this.employee = employee;
        this.hourlyRate = hourlyRate;
        this.institutionName = institutionName;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
    }

    public Payroll() {
        this.employee = null;
        this.hourlyRate = 0.0f;
        this.institutionName = null;
        this.routingNumber = null;
        this.accountNumber = null;
    }

    public Long getPayrollID() {
        return payrollID;
    }

    public void setPayrollID(Long payrollID) {
        this.payrollID = payrollID;
    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public List<Timesheet> getTimesheetList() {
        return timesheetList;
    }

    public void setTimesheetList(List<Timesheet> timesheetList) {
        this.timesheetList = timesheetList;
    }

    public List<Timesheet> getApprovedTimesheetList() {
        return approvedTimesheetList;
    }

    public void setApprovedTimesheetList(List<Timesheet> approvedTimesheetList) {
        this.approvedTimesheetList = approvedTimesheetList;
    }

    public float getHourlyRate() {
        return hourlyRate;
    }

    public void setHourlyRate(float hourlyRate) {
        this.hourlyRate = hourlyRate;
    }

    public String getInstitutionName() {
        return institutionName;
    }

    public void setInstitutionName(String institutionName) {
        this.institutionName = institutionName;
    }

    public String getRoutingNumber() {
        return routingNumber;
    }

    public void setRoutingNumber(String routingNumber) {
        this.routingNumber = routingNumber;
    }

    public String getAccountNumber() {
        return accountNumber;
    }

    public void setAccountNumber(String accountNumber) {
        this.accountNumber = accountNumber;
    }
}
