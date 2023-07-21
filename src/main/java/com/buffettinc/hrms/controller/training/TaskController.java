package com.buffettinc.hrms.controller.training;

import com.buffettinc.hrms.model.training.Task;
import com.buffettinc.hrms.service.training.TaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * This class is a Spring MVC Controller for handling Task-related requests.
 * It manages the CRUD operations for Task entities.
 * Each method returns a string in camelCase for a Thymeleaf template.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/tasks")
public class TaskController {
    @Autowired
    private TaskService taskService;

    /**
     * Retrieves the view for displaying all tasks.
     *
     * @param model the Model to bind data to the view.
     * @return the view for displaying all tasks.
     */
    @GetMapping("/all")
    public String viewAllTasks(Model model) {
        model.addAttribute("tasks", taskService.getAllTasks());
        return "displayAllTasks";
    }

    /**
     * Retrieves the view for creating or updating a task.
     *
     * @param taskID the ID of the task to be updated, or null for creating a new task.
     * @param model the Model to bind data to the view.
     * @return the view for creating or updating a task.
     */
    @GetMapping({"/edit", "/edit/{id}"})
    public String viewEditTask(@PathVariable(value = "id", required = false) Long taskID, Model model) {
        Task task = (taskID != null) ? taskService.getTaskById(taskID) : new Task();
        model.addAttribute("task", task);
        return "editTask";
    }

    /**
     * Handles the submission of creating or updating a task.
     *
     * @param task the task to be created or updated.
     * @return the view for displaying all tasks.
     */
    @PostMapping("/edit")
    public String submitEditTask(@ModelAttribute Task task) {
        taskService.saveOrUpdateTask(task);
        return "redirect:/task/all";
    }

    /**
     * Handles the deletion of a task.
     *
     * @param taskID the ID of the task to be deleted.
     * @return the view for displaying all tasks.
     */
    @PostMapping("/delete")
    public String deleteTask(@RequestParam Long taskID) {
        taskService.deleteTask(taskID);
        return "redirect:/task/all";
    }

    /**
     * Tasks Landing Page
     *
     * @return String name of Thymeleaf template.
     */
    @GetMapping("/tasks")
    public String tasksLandingPage(Model model){
        model.addAttribute("page", "tasks");
        return "tasks/tasks";
    }
}
