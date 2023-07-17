package com.buffettinc.hrms.controller.job;

import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.service.JobApplicationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller for managing {@link JobApplication}s in Buffett Inc.
 * Provides endpoints to create, retrieve, update, and delete job applications.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/applications")
public class JobApplicationController {

    @Autowired
    private JobApplicationService jobApplicationService;

    @PostMapping
    public String saveOrUpdateJobApplication(JobApplication jobApplication) {
        jobApplicationService.saveOrUpdateJobApplication(jobApplication);
        return "jobApplicationSavedOrUpdated";
    }

    @GetMapping("/{id}")
    public String getJobApplicationByID(@PathVariable("id") UUID applicationID) {
        jobApplicationService.getJobApplicationById(applicationID);
        return "viewJobApplication";
    }

    @GetMapping
    public String getAllJobApplications() {
        jobApplicationService.getAllJobApplications();
        return "viewAllJobApplications";
    }

    @DeleteMapping("/{id}")
    public String deleteJobApplication(@PathVariable("id") UUID applicationID) {
        jobApplicationService.deleteJobApplication(applicationID);
        return "jobApplicationDeleted";
    }

    @GetMapping("/status/{status}")
    public String getJobApplicationsByStatus(@PathVariable("status") JobApplication.JobApplicationStatus status) {
        jobApplicationService.getJobApplicationsByStatus(status);
        return "viewJobApplicationsByStatus";
    }

    @GetMapping("/jobOpening/{jobOpeningID}")
    public String getJobApplicationsForJobOpening(@PathVariable("jobOpeningID") UUID jobOpeningID) {
        jobApplicationService.getJobApplicationsForJobOpening(jobOpeningID);
        return "viewJobApplicationsForJobOpening";
    }

    @GetMapping("/applicant/{applicantID}")
    public String getJobApplicationsByApplicant(@PathVariable("applicantID") UUID applicantID) {
        jobApplicationService.getJobApplicationsByApplicant(applicantID);
        return "viewJobApplicationsByApplicant";
    }
}
