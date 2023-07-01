package com.buffettinc.hrms.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a Payment made for a Paycheck for an Employee of Buffett Inc.
 * Payment objects include a name of the receiving banking institution, a routing number, an account number, and amount,
 * a postedDate, and the employeeID of the recipient.
 */
public class Payment {
    private String institution;
    private String routingNumber;
    private String accountNumber;
    private LocalDate postedDate;
    private float amount;
    private UUID employeeID;

    public Payment(String institution, String routingNumber, String accountNumber, LocalDate postedDate, float amount, UUID employeeID) {
        this.institution = institution;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.postedDate = postedDate;
        this.amount = amount;
        this.employeeID = employeeID;
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

    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
    }

    public void directDepositTransfer(){

    }

    public void directDepositAcknowledge(){

    }

    public void writeCheck(){

    }
}
