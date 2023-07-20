package com.buffettinc.hrms.controller.employee;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.service.JobApplicationService;
import com.buffettinc.hrms.service.employee.EmployeeService;
import com.buffettinc.hrms.service.employee.ManagerService;
import com.buffettinc.hrms.service.pto.PTORequestService;
import com.buffettinc.hrms.service.time.TimesheetService;
import jdk.jshell.spi.ExecutionControl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.Optional;
import java.util.UUID;

@Controller
@RequestMapping("/manager")
public class ManagerController {
    @Autowired
    private ManagerService managerService;
    @Autowired
    private JobApplicationService jobApplicationService;
    @Autowired
    private TimesheetService timesheetService;
    @Autowired
    private PTORequestService ptoRequestService;
    @Autowired
    private EmployeeService employeeService;

    @GetMapping
    public String getManagerHome(Model model){
        return "managerHome";
    }

    @PostMapping("/assignTask")
    public String assignTask(@RequestParam Long employeeID,
                             @RequestParam String name,
                             @RequestParam String description,
                             @RequestParam LocalDate dueDate,
                             Model model){
        model.addAttribute("task", managerService.assignTask(employeeID, name, description, dueDate));
        return "assignTask";
    }

    @GetMapping("/managedEmployees")
    public String getManagedEmployees(@RequestParam Long managerID, Model model){
        model.addAttribute("employees", managerService.getManagedEmployees(managerID, PageRequest.of(0, 20)));
        return "managedEmployees";
    }

    @PostMapping("/approveJobApplication")
    public String approveJobApplication(@RequestParam Long applicationID, Model model) {
        Optional<JobApplication> optional = jobApplicationService.getJobApplicationById(applicationID);
        if (optional.isPresent()){
            JobApplication approvedApplication = managerService.approveJobApplication(optional.get());
            model.addAttribute("jobApplication", approvedApplication);
            return "approveJobApplication";
        } else {
            throw new RuntimeException(" Job Application not found for id + " + applicationID);
        }

    }

    @PostMapping("/approveHours")
    public String approveHours(@RequestParam Long timesheetID, Model model){
        Timesheet timesheet = timesheetService.getTimesheetById(timesheetID);
        managerService.approveHours(timesheet);
        return "approveHours";
    }

    @PostMapping("/approvePTO")
    public String approvePTO(@RequestParam Long requestID, Model model){
        PTORequest request = ptoRequestService.getPTORequestById(requestID);
        managerService.approvePTO(request);
        return "approvePTO";
    }

    @GetMapping("/viewEmployeePTO")
    public String viewEmployeePTO(@RequestParam Long employeeID, Model model){
        Employee employee = employeeService.getEmployeeById(employeeID);
        model.addAttribute("ptoBalance", managerService.viewEmployeePTO(employee));
        return "viewEmployeePTO";
    }

    @GetMapping("/viewPTOCalendar")
    public String viewPTOCalendar(Model model){
        model.addAttribute("ptoCalendar", managerService.viewPTOCalendar());
        return "viewPTOCalendar";
    }
}
