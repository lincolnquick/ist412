package com.buffettinc.hrms.model;

import java.time.LocalDate;
import java.util.UUID;

/**
 * This class represents a Manager employee for Buffett Inc. This class consists of all the properties and methods
 * of the Employee class as well as a permissionLevel.
 */
public class Manager extends Employee{
    private String permissionLevel;

    public Manager() {
        super();
        this.permissionLevel = "";
    }

    public Task assignTask(UUID employeeID, String name, String description, LocalDate dueDate){
        return new Task(name, description, dueDate, this.getEmployeeID(), employeeID);
    }
    public void reviewJobApplication(JobApplication application){

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
