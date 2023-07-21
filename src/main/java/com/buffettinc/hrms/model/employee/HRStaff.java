package com.buffettinc.hrms.model.employee;

import com.buffettinc.hrms.model.communication.Notification;
import com.buffettinc.hrms.model.job.Applicant;
import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.model.job.JobOpening;
import com.buffettinc.hrms.model.training.TrainingModule;
import jakarta.persistence.*;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import com.buffettinc.hrms.model.communication.Observer;

/**
 * This class represents an HR Staff employee. This class contains all the properties and methods of the {@link Employee}
 * as well as a permissionLevel.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="hrstaff")
public class HRStaff extends Employee implements Observer{
    @Column(name="permission")
    private String permissionLevel;

    public HRStaff(){
        super();
        permissionLevel = "";
    }

    public HRStaff(String lastName, String firstName, String streetAddress, String city, String state, String zip,
                   String phone, String email, LocalDate hireDate, String department, String position,
                   Manager manager){
        super(lastName, firstName, streetAddress, city, state, zip, phone, email, hireDate, department, position,
                manager);
        this.permissionLevel = "";
    }


    @Override
    public void update(Notification notification) {
        System.out.println(this.toString() + " received notification: " + notification.getMessage());
    }

    @Override
    public String toString(){
        return "HR Staff: " + this.getUser().getUsername() + " - " + this.getFirstName() + " " + this.getLastName();
    }
}
