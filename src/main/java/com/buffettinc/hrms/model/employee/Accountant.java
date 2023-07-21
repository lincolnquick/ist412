package com.buffettinc.hrms.model.employee;

import com.buffettinc.hrms.model.communication.Notification;
import com.buffettinc.hrms.model.payroll.Payment;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents an Accountant for Buffett Inc. An accountant is a specialized type of {@link Employee}.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="accountant")
public class Accountant extends Employee{
    @Column(name="permission")
    private String permissionLevel;
//    @ManyToMany
//    private ArrayList<Payment> payments;

    public Accountant(){
        super();
        permissionLevel = "";
    }
    public Accountant(String lastName, String firstName, String streetAddress, String city, String state, String zip,
                   String phone, String email, LocalDate hireDate, String department, String position,
                   Manager manager){
        super(lastName, firstName, streetAddress, city, state, zip, phone, email, hireDate, department, position,
                manager);
        this.permissionLevel = "";
    }

    public Payment addPayment(String institution, String routingNumber, String accountNumber, LocalDate postedDate, float amount, Long employeeID){
        Payment newPayment = new Payment(institution, routingNumber, accountNumber, postedDate, amount, employeeID);
       // payments.add(newPayment);
        return newPayment;

    }

    public void viewEmployeePay(Employee employee){

    }

    public void approvePayment(){

    }

    @Override
    public void update(Notification notification) {
        System.out.println(this.toString() + " received notification: " + notification.getMessage());
    }

    @Override
    public String toString(){
        return "Accountant: " + this.getUser().getUsername() + ": " + this.getFirstName() + " " + this.getLastName();
    }

}
