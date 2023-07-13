package com.buffettinc.hrms.model;

import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

@Entity
@Table(name="accountant")
public class Accountant extends Employee{
    @Column(name="permission")
    private String permissionLevel;
    @ManyToMany
    private ArrayList<Payment> payments;

    public Accountant(){
        super();
        permissionLevel = "";
        payments = new ArrayList<>();
    }

    public Payment addPayment(String institution, String routingNumber, String accountNumber, LocalDate postedDate, float amount, UUID employeeID){
        Payment newPayment = new Payment(institution, routingNumber, accountNumber, postedDate, amount, employeeID);
        payments.add(newPayment);
        return newPayment;

    }

    public void viewEmployeePay(Employee employee){

    }

    public void approvePayment(){

    }

}
