package com.buffettinc.hrms.model;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;

/**
 * This class represents an HR Staff employee. This class contains all the properties and methods of the Employee class
 * as well as a permissionLevel.
 */
public class HRStaff extends Employee{
    private String permissionLevel;

    public HRStaff(){
        super();
        permissionLevel = "";
    }

    public TrainingModule addTrainingModule(String title, String description, URL trainingURL, Duration eta){
        return new TrainingModule(title, description, trainingURL, eta, this.getEmployeeID());
    }

    public JobOpening postJobOpening(String title, String department, String description, LocalDate postingDate){
        return new JobOpening(title, department, description, postingDate);
    }

    public void reviewJobApplication(JobApplication application){

    }

    public void viewEmployeeData(Employee employee){

    }

    public void addEmployee(){

    }

    public void viewEmployeePTO(){

    }

    public void viewPTOCalendar(){

    }
}
