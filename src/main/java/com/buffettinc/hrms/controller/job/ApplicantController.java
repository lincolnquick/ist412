package com.buffettinc.hrms.controller.job;

import com.buffettinc.hrms.model.job.Applicant;
import com.buffettinc.hrms.service.job.ApplicantService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import java.net.URL;
import java.util.List;
import java.util.UUID;

/**
 * REST Controller for managing job applicants in the HRMS.
 * Provides endpoints for performing CRUD operations on job applicants.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@RestController
@RequestMapping("/applicants")
public class ApplicantController {

    private final ApplicantService applicantService;

    @Autowired
    public ApplicantController(ApplicantService applicantService) {
        this.applicantService = applicantService;
    }

    /**
     * Endpoint for creating a new applicant.
     * @return template name
     */
    @PostMapping
    public String createApplicant(@RequestParam String firstName, @RequestParam String lastName,
                                  @RequestParam String streetAddress, @RequestParam String city,
                                  @RequestParam String state, @RequestParam String zip,
                                  @RequestParam String phone, @RequestParam String email,
                                  @RequestParam Long jobID, @RequestParam URL resume) {
        Applicant applicant = applicantService.createApplicant(firstName, lastName, streetAddress, city, state, zip, phone, email, jobID, resume);
        return "applicantDetails"; // Assuming this is the template showing the details of the created applicant
    }

    /**
     * Endpoint for retrieving an applicant by ID.
     * @return template name
     */
    @GetMapping("/{applicantID}")
    public String getApplicantByID(Model model, @PathVariable Long applicantID) {
        Applicant applicant = applicantService.getApplicantByID(applicantID);
        model.addAttribute("applicant", applicant);
        return "applicantDetails"; // Assuming this is the template showing the details of the retrieved applicant
    }

    /**
     * Endpoint for retrieving all applicants.
     * @return template name
     */
    @GetMapping
    public String getAllApplicants(Model model) {
        List<Applicant> applicants = applicantService.getAllApplicants();
        model.addAttribute("applicants", applicants);
        return "applicantsList"; // Assuming this is the template showing a list of all applicants
    }

    /**
     * Endpoint for updating an existing applicant.
     * @return template name
     */
    @PutMapping("/{applicantID}")
    public String updateApplicant(@PathVariable Long applicantID, @RequestParam String firstName,
                                  @RequestParam String lastName, @RequestParam String streetAddress,
                                  @RequestParam String city, @RequestParam String state,
                                  @RequestParam String zip, @RequestParam String phone,
                                  @RequestParam String email, @RequestParam Long jobID,
                                  @RequestParam URL resume) {
        Applicant applicant = applicantService.updateApplicant(applicantID, firstName, lastName, streetAddress, city, state, zip, phone, email, jobID, resume);
        return "applicantDetails"; // Assuming this is the template showing the details of the updated applicant
    }

    /**
     * Endpoint for deleting an applicant.
     * @return template name
     */
    @DeleteMapping("/{applicantID}")
    public String deleteApplicant(@PathVariable Long applicantID) {
        boolean success = applicantService.deleteApplicant(applicantID);
        return "applicantDeleted"; // Assuming this is the template showing a confirmation of the deletion
    }
}
