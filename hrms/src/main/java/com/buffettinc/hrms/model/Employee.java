package com.buffettinc.hrms.model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.UUID;

/**
 * This class represents an Employee for Buffett Inc.
 * Each employee has an employeeID, first name, last name, address and contact info, a hire date,
 * department, position, and a reference to their manager, as well as PTOBalance and Payroll objects to manager
 * PTO balances and payroll information.
 */
public class Employee {
    private UUID employeeID;
    private String firstName;
    private String lastName;
    private String streetAddress;
    private String city;
    private String state;
    private String zip;
    private String phone;
    private String email;
    private LocalDate hireDate;
    private String department;
    private String position;
    private UUID manager;
    private PTOBalance ptoBalance;
    private Payroll payrollInfo;
    private HashMap<UUID, Message> messages;

    public Employee(String firstName, String lastName, String streetAddress, String city, String state, String zip, String phone, String email, LocalDate hireDate, String department, String position, UUID manager) {
        this.employeeID = UUID.randomUUID();
        this.firstName = firstName;
        this.lastName = lastName;
        this.streetAddress = streetAddress;
        this.city = city;
        this.state = state;
        this.zip = zip;
        this.phone = phone;
        this.email = email;
        this.hireDate = hireDate;
        this.department = department;
        this.position = position;
        this.manager = manager;
        this.ptoBalance = new PTOBalance(employeeID, 0,0,0);
        this.payrollInfo = new Payroll(employeeID, 0, null, null, null);
        this.messages = new HashMap<>();
    }

    public Employee(){
        this.employeeID = UUID.randomUUID();
        this.firstName = "";
        this.lastName = "";
        this.streetAddress = "";
        this.city = "";
        this.state = "";
        this.zip = "";
        this.phone = "";
        this.email = "";
        this.hireDate = LocalDate.now();
        this.department = "";
        this.position = "";
        this.manager = null;
        this.ptoBalance = new PTOBalance(employeeID, 0,0,0);
        this.payrollInfo = new Payroll(employeeID, 0, null, null, null);
        this.messages = new HashMap<>();
    }

    public Message sendMessage(UUID recipientID, String title, String message){
        return new Message(employeeID, recipientID, title, message);
    }
    public UUID getEmployeeID() {
        return employeeID;
    }

    public void setEmployeeNumber(UUID employeeID) {
        this.employeeID = employeeID;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getStreetAddress() {
        return streetAddress;
    }

    public void setStreetAddress(String streetAddress) {
        this.streetAddress = streetAddress;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public UUID getManager() {
        return manager;
    }

    public void setManager(UUID manager) {
        this.manager = manager;
    }

    public void setEmployeeID(UUID employeeID) {
        this.employeeID = employeeID;
    }

    public LocalDate getHireDate() {
        return hireDate;
    }

    public void setHireDate(LocalDate hireDate) {
        this.hireDate = hireDate;
    }

    public PTOBalance getPtoBalance() {
        return ptoBalance;
    }

    public void setPtoBalance(PTOBalance ptoBalance) {
        this.ptoBalance = ptoBalance;
    }

    public Timesheet createTimesheet(LocalDate periodStart, LocalDate periodEnd){
        return new Timesheet(employeeID, periodStart, periodEnd);
    }
    public ShiftEntry enterTime(LocalDateTime startTime, LocalDateTime endTime){
        return new ShiftEntry(startTime, endTime);
    }

    public PTOCalendar viewPTOBalance(){
        return null;
    }

    public PTORequest requestPTO(LocalDate startDate, LocalDate endDate, PTOReason reason){
        return new PTORequest(employeeID, startDate, endDate, reason);
    }

}
