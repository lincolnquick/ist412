package com.buffettinc.hrms.controller.training;

import com.buffettinc.hrms.model.training.EmployeeTrainingRecord;
import com.buffettinc.hrms.service.training.EmployeeTrainingRecordService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * This class is a Spring MVC Controller for handling EmployeeTrainingRecord-related requests.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/employeeTrainingRecord")
public class EmployeeTrainingRecordController {
    @Autowired
    private EmployeeTrainingRecordService employeeTrainingRecordService;

    /**
     * Retrieves the view for displaying all EmployeeTrainingRecords.
     *
     * @param model the Model to bind data to the view.
     * @return the view for displaying all EmployeeTrainingRecords.
     */
    @GetMapping("/all")
    public String viewAllEmployeeTrainingRecords(Model model) {
        model.addAttribute("employeeTrainingRecords", employeeTrainingRecordService.getAllEmployeeTrainingRecords());
        return "displayAllEmployeeTrainingRecords";
    }

    /**
     * Retrieves the view for creating or updating an EmployeeTrainingRecord.
     *
     * @param recordID the ID of the EmployeeTrainingRecord to be updated, or null for creating a new EmployeeTrainingRecord.
     * @param model the Model to bind data to the view.
     * @return the view for creating or updating an EmployeeTrainingRecord.
     */
    @GetMapping({"/edit", "/edit/{id}"})
    public String viewEditEmployeeTrainingRecord(@PathVariable(value = "id", required = false) Long recordID, Model model) {
        EmployeeTrainingRecord employeeTrainingRecord = (recordID != null) ? employeeTrainingRecordService.getEmployeeTrainingRecordById(recordID) : new EmployeeTrainingRecord();
        model.addAttribute("employeeTrainingRecord", employeeTrainingRecord);
        return "editEmployeeTrainingRecord";
    }

    /**
     * Handles the submission of creating or updating an EmployeeTrainingRecord.
     *
     * @param employeeTrainingRecord the EmployeeTrainingRecord to be created or updated.
     * @return the view for displaying all EmployeeTrainingRecords.
     */
    @PostMapping("/edit")
    public String submitEditEmployeeTrainingRecord(@ModelAttribute EmployeeTrainingRecord employeeTrainingRecord) {
        employeeTrainingRecordService.saveOrUpdateEmployeeTrainingRecord(employeeTrainingRecord);
        return "redirect:/employeeTrainingRecord/all";
    }

    /**
     * Handles the deletion of an EmployeeTrainingRecord.
     *
     * @param recordID the ID of the EmployeeTrainingRecord to be deleted.
     * @return the view for displaying all EmployeeTrainingRecords.
     */
    @PostMapping("/delete")
    public String deleteEmployeeTrainingRecord(@RequestParam Long recordID) {
        employeeTrainingRecordService.deleteEmployeeTrainingRecord(recordID);
        return "redirect:/employeeTrainingRecord/all";
    }
}
