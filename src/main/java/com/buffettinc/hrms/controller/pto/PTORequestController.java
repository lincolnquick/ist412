package com.buffettinc.hrms.controller.pto;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.pto.PTOReason;
import com.buffettinc.hrms.service.employee.EmployeeService;
import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.service.employee.EmployeeServiceImpl;
import com.buffettinc.hrms.service.pto.PTORequestService;
import com.buffettinc.hrms.service.pto.PTORequestServiceImpl;
import com.buffettinc.hrms.service.user.CustomUserDetails;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

/**
 * The PTORequestController provides endpoints to handle PTORequest objects in the Buffett Inc. HRMS.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/pto")
public class PTORequestController {
    private final PTORequestServiceImpl ptoRequestService;
    private final EmployeeServiceImpl employeeService;

    public PTORequestController(PTORequestServiceImpl ptoRequestService, EmployeeServiceImpl employeeService) {
        this.ptoRequestService = ptoRequestService;
        this.employeeService = employeeService;
    }

    /**
     * This method maps to the endpoint to view the details of a PTORequest.
     *
     * @param id    The ID of the PTORequest.
     * @param model The Model to be used.
     * @return The Thymeleaf template "ptorequestDetails".
     */
    @GetMapping("/{id}")
    public String viewPTORequestDetails(@PathVariable("id") Long id, Model model) {
        PTORequest ptoRequest = ptoRequestService.getPTORequestById(id);
        model.addAttribute("ptoRequest", ptoRequest);
        return "ptorequestDetails";
    }

    /**
     * This method maps to the endpoint to create a new PTORequest.
     *
     * @param model The Model to be used.
     * @return The Thymeleaf template "newPtorequestForm".
     */
    @GetMapping("/newPTORequest")
    public String showNewPTORequestForm(@AuthenticationPrincipal CustomUserDetails userDetails, Model model){

        Long userID = userDetails.getEmployeeID();
        Employee ptoEmployee = employeeService.getEmployeeById(userID);

        model.addAttribute("ptoEmployee", ptoEmployee);
        model.addAttribute("startDate", LocalDate.now());
        model.addAttribute("endDate", LocalDate.now());
        model.addAttribute("endTime", LocalDateTime.now());
        model.addAttribute("reason", "");

        model.addAttribute("ptoRequest", new PTORequest());

        return "pto/newPTORequest";
    }

    /**
     * This method maps to the endpoint to save or update a PTORequest.
     *
     * @param ptoRequest The PTORequest to be saved or updated.
     * @return The Thymeleaf template "ptorequestDetails".
     */
    @PostMapping("/save")
    public String saveOrUpdatePTORequest(@RequestParam("startDate") LocalDate startDate,
                                         @RequestParam("endDate") LocalDate endDate,
                                         @RequestParam("employeeID") Long employeeID,
                                         @RequestParam("reason") String ptoReason,
                                         Model model){

        PTOReason newReason = PTOReason.valueOf(ptoReason);
        Employee ptoEmployee = employeeService.getEmployeeById(employeeID);
        PTORequest ptoRequest = new PTORequest(ptoEmployee, startDate, endDate, newReason);
        PTORequest savedPTORequest = ptoRequestService.saveOrUpdatePTORequest(ptoRequest);

        return "redirect:/pto/ptorequests";
    }

    /**
     * This method maps to the endpoint to delete a PTORequest.
     *
     * @param id The ID of the PTORequest to be deleted.
     * @return The Thymeleaf template "ptorequestList".
     */
    @PostMapping("/{id}/delete")
    public String deletePTORequest(@PathVariable("id") Long id) {
        ptoRequestService.deletePTORequest(id);
        return "redirect:/ptorequests";
    }

    /**
     * This method maps to the endpoint to approve a PTORequest.
     *
     * @param id The ID of the PTORequest to be approved.
     * @return The Thymeleaf template "ptorequestList".
     */
    @PostMapping("/{id}/approve")
    public String approvePTORequest(@PathVariable("id") Long id) {
        ptoRequestService.approvePTORequest(id);
        return "redirect:/ptorequests";
    }

    /**
     * This method maps to the endpoint to deny a PTORequest.
     *
     * @param id The ID of the PTORequest to be denied.
     * @return The Thymeleaf template "ptorequestList".
     */
    @PostMapping("/{id}/deny")
    public String denyPTORequest(@PathVariable("id") Long id) {
        ptoRequestService.denyPTORequest(id);
        return "redirect:/ptorequests";
    }

    @GetMapping("/ptorequests")
    public String ptoRequestsLandingPage(@AuthenticationPrincipal CustomUserDetails userDetails, Model model){
        Long userID = userDetails.getEmployeeID();
        Employee ptoEmployee = employeeService.getEmployeeById(userID);


        model.addAttribute("PTORequests", ptoRequestService.getPTORequestByEmployee(ptoEmployee.getEmployeeID()));
        model.addAttribute("employee", ptoEmployee);
        model.addAttribute("userID", userID);
        model.addAttribute("page", "ptorequests");

        return "pto/ptorequests";
    }

}
