package com.buffettinc.hrms.model;

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

    public void viewEmployeeData(Employee employee){

    }

    public void addEmployee(){

    }

    public void viewEmployeePTO(){

    }

    public void viewPTOCalendar(){

    }
}
