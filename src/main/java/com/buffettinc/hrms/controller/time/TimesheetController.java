package com.buffettinc.hrms.controller.time;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.service.employee.EmployeeService;
import com.buffettinc.hrms.service.time.TimesheetService;
import com.buffettinc.hrms.service.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

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

    @Autowired
    private EmployeeService employeeService;


    /**
     * Retrieves the view for displaying all Timesheets.
     *
     * @param model the Model to bind data to the view.
     * @return the view for displaying all Timesheets.
     */
    @GetMapping("/all")
    public String viewAllTimesheets(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        System.out.println("TimesheetController.viewAllTimesheets(): /index");
        Long employeeID = userDetails.getEmployeeID();
        System.out.println("Logged in employee ID: " + employeeID);
        Employee loggedInEmployee = employeeService.getEmployeeById(employeeID);
        model.addAttribute("timesheets", timesheetService.getAllTimesheets());
        return "timesheets/all";
    }


    @GetMapping("/{timesheetID}/shifts")
    public String viewShiftsForTimesheet(@PathVariable Long timesheetID, Model model) {
        Timesheet timesheet = timesheetService.getTimesheetById(timesheetID);
        if (timesheet != null) {
            model.addAttribute("timesheet", timesheet);
            return "displayShiftsInTimesheet";
        } else {
            // Handle error (e.g., redirect to error page or back to the list with a message)
            return "redirect:/timesheets/all";
        }
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

}
