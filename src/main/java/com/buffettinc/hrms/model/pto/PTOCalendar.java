package com.buffettinc.hrms.model.pto;

import com.buffettinc.hrms.model.employee.Employee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.*;
import java.util.concurrent.ThreadLocalRandom;

/**
 * This class represents a calendar of all {@link Employee}'s {@link PTORequest}s.
 * The PTOCalendar contains a reference to view the calendar as well as a collection of all
 * PTORequests for each EmployeeID.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
public class PTOCalendar implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long calendarID;
    @Column(name="url")
    private String calendarURL;

    @OneToMany(mappedBy = "ptoCalendar", cascade = CascadeType.ALL)
    private List<PTORequest> employeePTO;

    public PTOCalendar(){
        this.employeePTO = new ArrayList<>();
    }

    public void addPTORequest(Long employeeID, PTORequest request){

    }

    public void removePTORequest(Long employeeID, PTORequest request){

    }

    public void updatePTORequest(Long employeeID, PTORequest previousRequest, PTORequest newRequest){

    }

}
