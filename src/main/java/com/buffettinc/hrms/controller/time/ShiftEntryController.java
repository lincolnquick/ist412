package com.buffettinc.hrms.controller.time;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.time.ShiftEntry;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.service.employee.EmployeeService;
import com.buffettinc.hrms.service.time.ShiftEntryService;
import com.buffettinc.hrms.service.time.TimesheetService;
import com.buffettinc.hrms.service.user.CustomUserDetails;
import com.buffettinc.hrms.service.user.CustomUserDetailsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * This class is a Spring MVC Controller for handling ShiftEntry-related requests.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/shiftentry")
public class ShiftEntryController {
    @Autowired
    private ShiftEntryService shiftEntryService;

    @Autowired
    private TimesheetService timesheetService;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @GetMapping("/all")
    public String shiftEntryPage(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) {
        Long employeeID = userDetails.getEmployeeID();
        Employee loggedInEmployee = employeeService.getEmployeeById(employeeID);
        LocalDateTime lastPunch = shiftEntryService.getLastPunch(loggedInEmployee);
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss");

        String lastPunchFormatted = lastPunch.format(formatter);
        boolean isPunchedIn = shiftEntryService.isEmployeePunchedIn(loggedInEmployee);
        Timesheet currentTimesheet = timesheetService.getCurrentTimesheetForEmployee(loggedInEmployee).get();
        double totalHours = timesheetService.getTotalHoursForTimesheet(currentTimesheet);

        model.addAttribute("employee", loggedInEmployee);
        model.addAttribute("lastPunch", lastPunchFormatted);
        model.addAttribute("isPunchedIn", isPunchedIn);
        model.addAttribute("totalHours", totalHours);

        return "shiftentry/all";
    }


    @PostMapping("/punchIn")
    public String punchIn(@AuthenticationPrincipal CustomUserDetails userDetails) {
        Long employeeID = userDetails.getEmployeeID();
        Employee employee = employeeService.getEmployeeById(employeeID);
        try {
            // punch in
            shiftEntryService.punchIn(employee);
        } catch (RuntimeException e) {
            // Handle the exception
            System.err.println("Error punching in: " + e.getMessage());
            return "errorPage";
        }

        // If everything went well, redirect to the current shiftentry page
        return "redirect:/shiftentry/all";
    }

    @PostMapping("/punchOut")
    public String punchOut(@AuthenticationPrincipal CustomUserDetails userDetails){
        Long employeeID = userDetails.getEmployeeID();
        Employee employee = employeeService.getEmployeeById(employeeID);
        try {
            shiftEntryService.punchOut(employee);
        } catch (RuntimeException e){
            System.err.println("Error punching out: " + e.getMessage());
            return "errorPage";
        }
        return "redirect:/shiftentry/all";
    }





    /**
     * Retrieves the view for creating or updating a ShiftEntry.
     *
     * @param shiftID the ID of the ShiftEntry to be updated, or null for creating a new ShiftEntry.
     * @param model the Model to bind data to the view.
     * @return the view for creating or updating a ShiftEntry.
     */
    @GetMapping({"/edit", "/edit/{id}"})
    public String viewEditShiftEntry(@PathVariable(value = "id", required = false) Long shiftID, Model model) {
        ShiftEntry shiftEntry = (shiftID != null) ? shiftEntryService.getShiftEntryById(shiftID) : new ShiftEntry();
        model.addAttribute("shiftEntry", shiftEntry);
        return "redirect:/shiftentry/all"; // return to main shift entry landing
    }


    /**
     * Handles the submission of creating or updating a ShiftEntry.
     *
     * @param shiftEntry the ShiftEntry to be created or updated.
     * @return the view for displaying all ShiftEntries.
     */
    @PostMapping("/edit")
    public String submitEditShiftEntry(@ModelAttribute ShiftEntry shiftEntry) {
        shiftEntryService.saveOrUpdateShiftEntry(shiftEntry);
        return "redirect:/shiftentry/all"; // return to main shift entry landing
    }

    /**
     * Handles the deletion of a ShiftEntry.
     *
     * @param shiftID the ID of the ShiftEntry to be deleted.
     * @return the view for displaying all ShiftEntries.
     */
    @PostMapping("/delete")
    public String deleteShiftEntry(@RequestParam Long shiftID) {
        shiftEntryService.deleteShiftEntry(shiftID);
        return "redirect:/shiftentry/all"; // return to main shift entry landing
    }
}
