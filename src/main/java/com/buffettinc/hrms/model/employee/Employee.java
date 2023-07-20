package com.buffettinc.hrms.model.employee;

import com.buffettinc.hrms.model.communication.Message;
import com.buffettinc.hrms.model.communication.Notification;
import com.buffettinc.hrms.model.payroll.Payroll;
import com.buffettinc.hrms.model.pto.PTOBalance;
import com.buffettinc.hrms.model.pto.PTOCalendar;
import com.buffettinc.hrms.model.pto.PTOReason;
import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.model.time.ShiftEntry;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.model.training.EmployeeTrainingRecord;
import com.buffettinc.hrms.model.user.User;
import jakarta.persistence.*;
import org.springframework.lang.NonNull;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents an Employee for Buffett Inc.
 * Each employee has an employeeID, first name, last name, address and contact info, a hire date,
 * department, position, and a reference to their manager, as well as PTOBalance and Payroll objects to manager
 * PTO balances and payroll information.
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name="employee")
public class Employee implements Serializable{
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @NonNull
    private Long employeeID;

    @OneToOne(mappedBy = "employee", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private User user;

    @Column(name="firstName")
    private String firstName;
    @Column(name="lastName")
    private String lastName;
    @Column(name="streetAddress")
    private String streetAddress;
    @Column(name="city")
    private String city;
    @Column(name="state")
    private String state;
    @Column(name="zip")
    private String zip;
    @Column(name="phone")
    private String phone;
    @Column(name="email")
    private String email;
    @Column(name="hireDate")
    private LocalDate hireDate;
    @Column(name="department")
   private String department;
    @Column(name="position")
   private String position;
    @ManyToOne
    @JoinColumn(name="managerID")
    private Manager manager;

    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL)
    private List<PTORequest> ptoRequests = new ArrayList<>();

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "ptobalance_emp", referencedColumnName = "employeeID")
    private PTOBalance ptoBalance;

    @OneToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "payroll_emp", referencedColumnName = "employeeID")
    private Payroll payrollInfo;

    @OneToMany(mappedBy = "sender", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> sentMessages = new ArrayList<>();
    @OneToMany(mappedBy = "recipient", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Message> receivedMessages = new ArrayList<>();
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Notification> notifications = new ArrayList<>();
    @OneToMany(mappedBy = "employee", cascade = CascadeType.ALL, orphanRemoval = true)
    private List<EmployeeTrainingRecord> trainingRecords = new ArrayList<>();


    public Employee(String firstName, String lastName, String streetAddress, String city, String state, String zip,
                    String phone, String email, LocalDate hireDate, String department, String position,
                    Manager manager) {
        this.employeeID = ThreadLocalRandom.current().nextLong(1, 1000);
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
    }

    public Employee(){
        this.employeeID = ThreadLocalRandom.current().nextLong(1, 1000);
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
    }

    public Message sendMessage(Employee recipient, String title, String message){
        Message newMessage = new Message(this, recipient, title, message);
        sentMessages.add(newMessage);
        return newMessage;
    }

    public Notification newNotification(String message){
        Notification newNotification = new Notification(this, message);
        notifications.add(newNotification);
        return newNotification;
    }

    public EmployeeTrainingRecord completeTraining(Long trainingID){
        EmployeeTrainingRecord newTrainingRecord = new EmployeeTrainingRecord(this, trainingID);
        this.trainingRecords.add(newTrainingRecord);
        return newTrainingRecord;
    }

    public Long getEmployeeID() {
        return employeeID;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public List<PTORequest> getPtoRequests() {
        return ptoRequests;
    }

    public void setPtoRequests(List<PTORequest> ptoRequests) {
        this.ptoRequests = ptoRequests;
    }

    public Payroll getPayrollInfo() {
        return payrollInfo;
    }

    public void setPayrollInfo(Payroll payrollInfo) {
        this.payrollInfo = payrollInfo;
    }

    public List<Message> getSentMessages() {
        return sentMessages;
    }

    public void setSentMessages(List<Message> sentMessages) {
        this.sentMessages = sentMessages;
    }

    public List<Message> getReceivedMessages() {
        return receivedMessages;
    }

    public void setReceivedMessages(List<Message> receivedMessages) {
        this.receivedMessages = receivedMessages;
    }

    public List<Notification> getNotifications() {
        return notifications;
    }

    public void setNotifications(List<Notification> notifications) {
        this.notifications = notifications;
    }

    public List<EmployeeTrainingRecord> getTrainingRecords() {
        return trainingRecords;
    }

    public void setTrainingRecords(List<EmployeeTrainingRecord> trainingRecords) {
        this.trainingRecords = trainingRecords;
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

    public Manager getManager() {
        return manager;
    }

    public void setManager(Manager manager) {
        this.manager = manager;
    }

    public void setEmployeeID(Long employeeID) {
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
        return new Timesheet(this.payrollInfo, periodStart, periodEnd);
    }
    public ShiftEntry enterTime(LocalDateTime startTime, LocalDateTime endTime){
        return new ShiftEntry(startTime, endTime);
    }

    public PTOCalendar viewPTOBalance(){
        return null;
    }

    public PTORequest requestPTO(LocalDate startDate, LocalDate endDate, PTOReason reason){
        return new PTORequest(this, startDate, endDate, reason);
    }

}
