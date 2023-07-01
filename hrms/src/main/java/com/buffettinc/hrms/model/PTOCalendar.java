package com.buffettinc.hrms.model;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.UUID;

/**
 * This class represents a calendar of all Employee's PTO requests.
 * The PTOCalendar contains a reference to view the calendar as well as a collection of all
 * PTORequests for each EmployeeID.
 */
public class PTOCalendar {
    private String calendarURL;
    private HashMap<UUID, ArrayList<PTORequest>> employeePTO;

    public PTOCalendar(){
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
