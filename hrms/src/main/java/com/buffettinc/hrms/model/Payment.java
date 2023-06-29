package com.buffettinc.hrms.model;

import java.time.LocalDate;

public class Payment {
    private String institution;
    private String routingNumber;
    private String accountNumber;
    private LocalDate postedDate;
    private float amount;
    private int employeeNumber;

    public Payment(String institution, String routingNumber, String accountNumber, LocalDate postedDate, float amount, int employeeNumber) {
        this.institution = institution;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.postedDate = postedDate;
        this.amount = amount;
        this.employeeNumber = employeeNumber;
    }

    public String getInstitution() {
        return institution;
    }

    public void setInstitution(String institution) {
        this.institution = institution;
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

    public LocalDate getPostedDate() {
        return postedDate;
    }

    public void setPostedDate(LocalDate postedDate) {
        this.postedDate = postedDate;
    }

    public float getAmount() {
        return amount;
    }

    public void setAmount(float amount) {
        this.amount = amount;
    }

    public int getEmployeeNumber() {
        return employeeNumber;
    }

    public void setEmployeeNumber(int employeeNumber) {
        this.employeeNumber = employeeNumber;
    }

    public void directDepositTransfer(){

    }

    public void directDepositAcknowledge(){

    }

    public void writeCheck(){

    }
}
