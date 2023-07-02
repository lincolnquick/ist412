package com.buffettinc.hrms.model;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

public class Accountant extends Employee{
    private String permissionLevel;
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
