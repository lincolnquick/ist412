package com.buffettinc.hrms.model.payroll;

import com.buffettinc.hrms.model.employee.Employee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a Payment made for a Paycheck for an {@link Employee} of Buffett Inc.
 * Payment objects include a name of the receiving banking institution, a routing number, an account number, and amount,
 * a postedDate, and the employeeID of the recipient.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="payment")
public class Payment implements Serializable {
    @Id
    @GeneratedValue(strategy=GenerationType.UUID)
    private UUID paymentID;
    @Column(name="institution")
    private String institution;
    @Column(name="routing")
    private String routingNumber;
    @Column(name="account")
    private String accountNumber;
    @Column(name="postedDate")
    private LocalDate postedDate;
    @Column(name="amount")
    private float amount;
    @Column(name="employee")
    private UUID employeeID;

    public Payment(String institution, String routingNumber, String accountNumber, LocalDate postedDate, float amount, UUID employeeID) {
        this.paymentID = UUID.randomUUID();
        this.institution = institution;
        this.routingNumber = routingNumber;
        this.accountNumber = accountNumber;
        this.postedDate = postedDate;
        this.amount = amount;
        this.employeeID = employeeID;
    }

    public Payment() {
        this.paymentID = UUID.randomUUID();
        this.institution = null;
        this.routingNumber = null;
        this.accountNumber = null;
        this.postedDate = LocalDate.MIN;
        this.amount = 0.0f;
        this.employeeID = null;
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
