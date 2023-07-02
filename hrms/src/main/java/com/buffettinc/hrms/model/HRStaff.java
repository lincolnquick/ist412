package com.buffettinc.hrms.model;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.UUID;

/**
 * This class represents an HR Staff employee. This class contains all the properties and methods of the Employee class
 * as well as a permissionLevel.
 */
public class HRStaff extends Employee{
    private String permissionLevel;
    private ArrayList<JobApplication> jobApplications;
    private ArrayList<Applicant> applicants;
    private ArrayList<JobOpening> jobOpenings;
    private ArrayList<TrainingModule> trainingModules;

    public HRStaff(){
        super();
        permissionLevel = "";
        jobApplications = new ArrayList<>();
        applicants = new ArrayList<>();
        jobOpenings = new ArrayList<>();
        trainingModules = new ArrayList<>();
    }

    public TrainingModule addTrainingModule(String title, String description, URL trainingURL, Duration eta){
        TrainingModule newTraining = new TrainingModule(title, description, trainingURL, eta, this.getEmployeeID());
        trainingModules.add(newTraining);
        return newTraining;
    }

    public JobOpening postJobOpening(String title, String department, String description, LocalDate postingDate){
        JobOpening newOpening = new JobOpening(title, department, description, postingDate);
        jobOpenings.add(newOpening);
        return newOpening;
    }

    public Applicant addNewApplicant(String firstName, String lastName, String streetAddress, String city, String state, String zip, String phone, String email, String status, UUID jobID, URL resume){
        Applicant newApplicant = new Applicant(firstName, lastName, streetAddress, city, state, zip, phone, email, JobApplication.JobApplicationStatus.SUBMITTED, jobID, resume);
        applicants.add(newApplicant);
        return newApplicant;
    }

    public JobApplication acceptApplication(UUID jobID, UUID applicantID){
        JobApplication newApplication = new JobApplication(jobID, applicantID, LocalDate.now(), JobApplication.JobApplicationStatus.SUBMITTED);
        jobApplications.add(newApplication);
        return newApplication;
    }

    public JobApplication reviewJobApplication(UUID jobID, UUID applicantID){
        return new JobApplication(jobID, applicantID, LocalDate.now(), null);

    }
    public JobApplication approveJobApplication (JobApplication application){
        return null;
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
