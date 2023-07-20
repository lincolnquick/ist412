package com.buffettinc.hrms.controller.time;

import com.buffettinc.hrms.model.time.ShiftEntry;
import com.buffettinc.hrms.service.time.ShiftEntryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * This class is a Spring MVC Controller for handling ShiftEntry-related requests.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/shiftEntry")
public class ShiftEntryController {
    @Autowired
    private ShiftEntryService shiftEntryService;

    /**
     * Retrieves the view for displaying all ShiftEntries.
     *
     * @param model the Model to bind data to the view.
     * @return the view for displaying all ShiftEntries.
     */
    @GetMapping("/all")
    public String viewAllShiftEntries(Model model) {
        model.addAttribute("shiftEntries", shiftEntryService.getAllShiftEntries());
        return "displayAllShiftEntries";
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
        return "editShiftEntry";
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
        return "redirect:/shiftEntry/all";
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
        return "redirect:/shiftEntry/all";
    }
}
