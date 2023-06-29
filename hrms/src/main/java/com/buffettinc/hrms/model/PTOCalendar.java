package com.buffettinc.hrms.model;

import java.util.ArrayList;
import java.util.HashMap;

public class PTOCalendar {
    private String calendarURL;
    private HashMap<Integer, ArrayList<PTORequest>> employeePTO;

    public PTOCalendar(){
        this.employeePTO = new HashMap<>();
    }

    public void addPTORequest(int employeeNumber, PTORequest request){
        ArrayList<PTORequest> requests = this.employeePTO.getOrDefault(employeeNumber, new ArrayList<>());
        requests.add(request);
        this.employeePTO.put(employeeNumber, requests);
    }

    public void removePTORequest(int employeeNumber, PTORequest request){
        ArrayList<PTORequest> requests = this.employeePTO.get(employeeNumber);
        if (requests != null){
            requests.remove(request);
            this.employeePTO.put(employeeNumber, requests);
        }
    }

    public void updatePTORequest(int employeeNumber, PTORequest previousRequest, PTORequest newRequest){
        ArrayList<PTORequest> requests = this.employeePTO.get(employeeNumber);
        if (requests != null && requests.contains(previousRequest)) {
            int index = requests.indexOf(previousRequest);
            requests.set(index, newRequest);
            this.employeePTO.put(employeeNumber, requests);
        }
    }

}
