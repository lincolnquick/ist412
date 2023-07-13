package com.buffettinc.hrms.controller.job;

import com.buffettinc.hrms.model.job.JobOpening;
import com.buffettinc.hrms.service.job.JobOpeningService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.util.UUID;

/**
 * REST Controller for managing {@link JobOpening}s in Buffett Inc.
 * Provides endpoints to create, retrieve, update, and delete job openings.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@RestController
@RequestMapping("/jobopenings")
public class JobOpeningController {

    @Autowired
    private JobOpeningService jobOpeningService;

    @PostMapping(consumes = MediaType.APPLICATION_FORM_URLENCODED_VALUE)
    public String createJobOpening(@RequestParam("title") String title,
                                   @RequestParam("department") String department,
                                   @RequestParam("description") String description,
                                   @RequestParam("date") LocalDate postingDate) {
        jobOpeningService.createJobOpening(title, department, description, postingDate);
        return "jobOpeningCreated";
    }

    @GetMapping("/{id}")
    public String getJobOpeningByID(@PathVariable("id") UUID jobID) {
        JobOpening jobOpening = jobOpeningService.getJobOpeningByID(jobID);
        return "viewJobOpening";
    }

    @GetMapping
    public String getAllJobOpenings() {
        jobOpeningService.getAllJobOpenings();
        return "viewAllJobOpenings";
    }

    @PutMapping("/{id}")
    public String updateJobOpening(@PathVariable("id") UUID jobID,
                                   @RequestParam("title") String title,
                                   @RequestParam("department") String department,
                                   @RequestParam("description") String description,
                                   @RequestParam("date") LocalDate postingDate) {
        jobOpeningService.updateJobOpening(jobID, title, department, description, postingDate);
        return "jobOpeningUpdated";
    }

    @DeleteMapping("/{id}")
    public String deleteJobOpening(@PathVariable("id") UUID jobID) {
        jobOpeningService.deleteJobOpening(jobID);
        return "jobOpeningDeleted";
    }
}
