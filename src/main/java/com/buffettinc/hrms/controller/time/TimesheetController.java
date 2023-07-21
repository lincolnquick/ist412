package com.buffettinc.hrms.controller.time;

import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.service.time.TimesheetService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * This class is a Spring MVC Controller for handling Timesheet-related requests.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/timesheets")
public class TimesheetController {
    @Autowired
    private TimesheetService timesheetService;

    /**
     * Retrieves the view for displaying all Timesheets.
     *
     * @param model the Model to bind data to the view.
     * @return the view for displaying all Timesheets.
     */
    @GetMapping("/all")
    public String viewAllTimesheets(Model model) {
        model.addAttribute("timesheets", timesheetService.getAllTimesheets());
        return "displayAllTimesheets";
    }

    /**
     * Retrieves the view for creating or updating a Timesheet.
     *
     * @param timesheetID the ID of the Timesheet to be updated, or null for creating a new Timesheet.
     * @param model the Model to bind data to the view.
     * @return the view for creating or updating a Timesheet.
     */
    @GetMapping({"/edit", "/edit/{id}"})
    public String viewEditTimesheet(@PathVariable(value = "id", required = false) Long timesheetID, Model model) {
        Timesheet timesheet = (timesheetID != null) ? timesheetService.getTimesheetById(timesheetID) : new Timesheet();
        model.addAttribute("timesheet", timesheet);
        return "editTimesheet";
    }

    /**
     * Handles the submission of creating or updating a Timesheet.
     *
     * @param timesheet the Timesheet to be created or updated.
     * @return the view for displaying all Timesheets.
     */
    @PostMapping("/edit")
    public String submitEditTimesheet(@ModelAttribute Timesheet timesheet) {
        timesheetService.saveOrUpdateTimesheet(timesheet);
        return "redirect:/timesheet/all";
    }

    /**
     * Handles the deletion of a Timesheet.
     *
     * @param timesheetID the ID of the Timesheet to be deleted.
     * @return the view for displaying all Timesheets.
     */
    @PostMapping("/delete")
    public String deleteTimesheet(@RequestParam Long timesheetID) {
        timesheetService.deleteTimesheet(timesheetID);
        return "redirect:/timesheet/all";
    }

    /**
     * Time sheets landing page
     *
     * @return Sting of Thymeleaf template file.
     */
    @GetMapping("/timesheets")
    public String timesheetsLanding(){
        return "timesheets/timesheets";
    }
}
