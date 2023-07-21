package com.buffettinc.hrms.model.employee;

import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.model.pto.PTOCalendar;
import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.model.training.Task;
import jakarta.persistence.*;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.UUID;

/**
 * This class represents a Manager employee for Buffett Inc. This class consists of all the properties and methods
 * of the {@link Employee} class as well as a permissionLevel.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="manager")
public class Manager extends Employee{
    @Column(name="permission")
    private String permissionLevel;

    @OneToMany(mappedBy = "manager")
    private List<Employee> subordinates = new ArrayList<>();


    public Manager() {
        super();
        this.permissionLevel = "";
    }

    public Manager(String lastName, String firstName, String streetAddress, String city, String state, String zip,
                   String phone, String email, LocalDate hireDate, String department, String position,
                   Manager manager){
        super(lastName, firstName, streetAddress, city, state, zip, phone, email, hireDate, department, position,
                manager);
        this.permissionLevel = "";
    }


    public Task assignTask(Employee employee, String name, String description, LocalDate dueDate){
        Task newTask = new Task(name, description, dueDate, this, employee);
        //tasks.put(employee.getEmployeeID(), newTask);
        return newTask;
    }

    public void addSubordinate(Employee employee){
        subordinates.add(employee);
        employee.setManager(this);
    }

    public void removeSubordinate(Employee employee){
        subordinates.remove(employee);
        employee.setManager(null);
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
