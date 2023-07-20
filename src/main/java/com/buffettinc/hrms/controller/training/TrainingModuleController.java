package com.buffettinc.hrms.controller.training;

import com.buffettinc.hrms.model.training.TrainingModule;
import com.buffettinc.hrms.service.training.TrainingModuleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * This class is a Spring MVC Controller for handling TrainingModule-related requests.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/training")
public class TrainingModuleController {
    @Autowired
    private TrainingModuleService trainingModuleService;

    /**
     * Retrieves the view for displaying all TrainingModules.
     *
     * @param model the Model to bind data to the view.
     * @return the view for displaying all TrainingModules.
     */
    @GetMapping("/all")
    public String viewAllTrainingModules(Model model) {
        model.addAttribute("trainingModules", trainingModuleService.getAllTrainingModules());
        return "displayAllTrainingModules";
    }

    /**
     * Retrieves the view for creating or updating a TrainingModule.
     *
     * @param trainingID the ID of the TrainingModule to be updated, or null for creating a new TrainingModule.
     * @param model the Model to bind data to the view.
     * @return the view for creating or updating a TrainingModule.
     */
    @GetMapping({"/edit", "/edit/{id}"})
    public String viewEditTrainingModule(@PathVariable(value = "id", required = false) Long trainingID, Model model) {
        TrainingModule trainingModule = (trainingID != null) ? trainingModuleService.getTrainingModuleById(trainingID) : new TrainingModule();
        model.addAttribute("trainingModule", trainingModule);
        return "editTrainingModule";
    }

    /**
     * Handles the submission of creating or updating a TrainingModule.
     *
     * @param trainingModule the TrainingModule to be created or updated.
     * @return the view for displaying all TrainingModules.
     */
    @PostMapping("/edit")
    public String submitEditTrainingModule(@ModelAttribute TrainingModule trainingModule) {
        trainingModuleService.saveOrUpdateTrainingModule(trainingModule);
        return "redirect:/trainingModule/all";
    }

    /**
     * Handles the deletion of a TrainingModule.
     *
     * @param trainingID the ID of the TrainingModule to be deleted.
     * @return the view for displaying all TrainingModules.
     */
    @PostMapping("/delete")
    public String deleteTrainingModule(@RequestParam Long trainingID) {
        trainingModuleService.deleteTrainingModule(trainingID);
        return "redirect:/trainingModule/all";
    }

    /**
     * Training Landing Page
     *
     * @return String name of Thymeleaf template.
     */
    @GetMapping("/training")
    public String trainingLandingPage(){
        return "training/training";
    }
}
