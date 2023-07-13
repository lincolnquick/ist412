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
    @ManyToMany(cascade = CascadeType.MERGE)
    @JoinTable(name = "employee_ptocalendar",
        joinColumns = {@JoinColumn(name="employeeID")},
            inverseJoinColumns = {@JoinColumn(name = "employeeID")})

    private HashMap<UUID, List<PTORequest>> employeePTO;

    public PTOCalendar(){
        this.calendarID = UUID.randomUUID();
        this.employeePTO = new HashMap<>();
    }

    public void addPTORequest(UUID employeeID, PTORequest request){
        ArrayList<PTORequest> requests = this.employeePTO.getOrDefault(employeeID, new ArrayList<>());
        requests.add(request);
        this.employeePTO.put(employeeID, requests);
    }

    public void removePTORequest(UUID employeeID, PTORequest request){
        ArrayList<PTORequest> requests = this.employeePTO.get(employeeID);
        if (requests != null){
            requests.remove(request);
            this.employeePTO.put(employeeID, requests);
        }
    }

    public void updatePTORequest(UUID employeeID, PTORequest previousRequest, PTORequest newRequest){
        ArrayList<PTORequest> requests = this.employeePTO.get(employeeID);
        if (requests != null && requests.contains(previousRequest)) {
            int index = requests.indexOf(previousRequest);
            requests.set(index, newRequest);
            this.employeePTO.put(employeeID, requests);
        }
    }

}
