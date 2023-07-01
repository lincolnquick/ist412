package com.buffettinc.hrms.model;

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

    public void approveHours(){

    }
    public void approvePTO(){

    }
    public void viewEmployeePTO(Employee employee){

    }

    public void viewPTOCalendar(){

    }
}
