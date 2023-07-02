package com.buffettinc.hrms.model;

import java.time.LocalDate;
import java.util.HashMap;
import java.util.UUID;

/**
 * This class represents a Manager employee for Buffett Inc. This class consists of all the properties and methods
 * of the Employee class as well as a permissionLevel.
 */
public class Manager extends Employee{
    private String permissionLevel;
    private HashMap<UUID, Task> tasks;

    public Manager() {
        super();
        this.permissionLevel = "";
        tasks = new HashMap<>();
    }

    public Task assignTask(UUID employeeID, String name, String description, LocalDate dueDate){
        Task newTask = new Task(name, description, dueDate, this.getEmployeeID(), employeeID);
        tasks.put(employeeID, newTask);
        return newTask;
    }
    public void reviewJobApplication(JobApplication application){

    }

    public JobApplication approveJobApplication (JobApplication application){
        return null;
    }

    public void approveHours(Timesheet timesheet){

    }
    public void approvePTO(PTORequest request){

    }
    public void viewEmployeePTO(Employee employee){

    }

    public PTOCalendar viewPTOCalendar(){
        return new PTOCalendar();
    }
}
