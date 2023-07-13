package com.buffettinc.hrms.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;

/**
 * This class represents a calendar of all Employee's PTO requests.
 * The PTOCalendar contains a reference to view the calendar as well as a collection of all
 * PTORequests for each EmployeeID.
 */
@Entity
public class PTOCalendar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID calendarID;
    @Column(name="url")
    private String calendarURL;

    @OneToMany(mappedBy = "ptoCalendar", cascade = CascadeType.ALL)
    private List<PTORequest> employeePTO;

    public PTOCalendar(){
        this.calendarID = UUID.randomUUID();
        this.employeePTO = new ArrayList<>();
    }

    public void addPTORequest(UUID employeeID, PTORequest request){

    }

    public void removePTORequest(UUID employeeID, PTORequest request){

    }

    public void updatePTORequest(UUID employeeID, PTORequest previousRequest, PTORequest newRequest){

    }

}
