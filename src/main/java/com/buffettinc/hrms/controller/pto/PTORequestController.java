package com.buffettinc.hrms.controller.pto;

import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.service.pto.PTORequestService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * The PTORequestController provides endpoints to handle PTORequest objects in the Buffett Inc. HRMS.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/ptorequests")
public class PTORequestController {
    private final PTORequestService ptoRequestService;

    public PTORequestController(PTORequestService ptoRequestService) {
        this.ptoRequestService = ptoRequestService;
    }

    /**
     * This method maps to the endpoint to view the details of a PTORequest.
     *
     * @param id    The ID of the PTORequest.
     * @param model The Model to be used.
     * @return The Thymeleaf template "ptorequestDetails".
     */
    @GetMapping("/{id}")
    public String viewPTORequestDetails(@PathVariable("id") UUID id, Model model) {
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
    @GetMapping("/new")
    public String showNewPTORequestForm(Model model) {
        model.addAttribute("ptoRequest", new PTORequest());
        return "newPtorequestForm";
    }

    /**
     * This method maps to the endpoint to save or update a PTORequest.
     *
     * @param ptoRequest The PTORequest to be saved or updated.
     * @return The Thymeleaf template "ptorequestDetails".
     */
    @PostMapping("/save")
    public String saveOrUpdatePTORequest(@ModelAttribute("ptoRequest") PTORequest ptoRequest) {
        PTORequest savedPTORequest = ptoRequestService.saveOrUpdatePTORequest(ptoRequest);
        return "redirect:/ptorequests/" + savedPTORequest.getRequestID();
    }

    /**
     * This method maps to the endpoint to delete a PTORequest.
     *
     * @param id The ID of the PTORequest to be deleted.
     * @return The Thymeleaf template "ptorequestList".
     */
    @PostMapping("/{id}/delete")
    public String deletePTORequest(@PathVariable("id") UUID id) {
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
    public String approvePTORequest(@PathVariable("id") UUID id) {
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
    public String denyPTORequest(@PathVariable("id") UUID id) {
        ptoRequestService.denyPTORequest(id);
        return "redirect:/ptorequests";
    }
}
