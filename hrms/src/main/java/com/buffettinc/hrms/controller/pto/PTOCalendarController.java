package com.buffettinc.hrms.controller.pto;

import com.buffettinc.hrms.model.pto.PTOCalendar;
import com.buffettinc.hrms.service.pto.PTOCalendarService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * This class is a Spring MVC Controller for handling PTOCalendar-related requests.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/ptoCalendar")
public class PTOCalendarController {
    @Autowired
    private PTOCalendarService ptoCalendarService;

    /**
     * Retrieves the view for displaying all PTOCalendar.
     *
     * @param model the Model to bind data to the view.
     * @return the view for displaying all PTOCalendar.
     */
    @GetMapping("/all")
    public String viewAllPTOCalendars(Model model) {
        model.addAttribute("ptocalendars", ptoCalendarService.getAllPTOCalendars());
        return "displayAllPTOCalendars";
    }

    /**
     * Retrieves the view for creating or updating a PTOCalendar.
     *
     * @param calendarID the ID of the PTOCalendar to be updated, or null for creating a new PTOCalendar.
     * @param model the Model to bind data to the view.
     * @return the view for creating or updating a PTOCalendar.
     */
    @GetMapping({"/edit", "/edit/{id}"})
    public String viewEditPTOCalendar(@PathVariable(value = "id", required = false) UUID calendarID, Model model) {
        PTOCalendar ptoCalendar = (calendarID != null) ? ptoCalendarService.getPTOCalendarById(calendarID) : new PTOCalendar();
        model.addAttribute("ptocalendar", ptoCalendar);
        return "editPTOCalendar";
    }

    /**
     * Handles the submission of creating or updating a PTOCalendar.
     *
     * @param ptoCalendar the PTOCalendar to be created or updated.
     * @return the view for displaying all PTOCalendar.
     */
    @PostMapping("/edit")
    public String submitEditPTOCalendar(@ModelAttribute PTOCalendar ptoCalendar) {
        ptoCalendarService.saveOrUpdatePTOCalendar(ptoCalendar);
        return "redirect:/ptoCalendar/all";
    }

    /**
     * Handles the deletion of a PTOCalendar.
     *
     * @param calendarID the ID of the PTOCalendar to be deleted.
     * @return the view for displaying all PTOCalendar.
     */
    @PostMapping("/delete")
    public String deletePTOCalendar(@RequestParam UUID calendarID) {
        ptoCalendarService.deletePTOCalendar(calendarID);
        return "redirect:/ptoCalendar/all";
    }
}
