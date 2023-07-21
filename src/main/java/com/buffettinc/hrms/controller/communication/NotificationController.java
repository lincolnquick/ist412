package com.buffettinc.hrms.controller.communication;

import com.buffettinc.hrms.model.communication.Notification;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.service.communication.NotificationService;
import com.buffettinc.hrms.service.employee.EmployeeService;
import com.buffettinc.hrms.service.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller for handling requests related to {@link Notification}s.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/notifications")
public class NotificationController {
    @Autowired
    private NotificationService notificationService;
    @Autowired
    private EmployeeService employeeService;

    public NotificationController() {
    }

    public NotificationController(NotificationService notificationService, EmployeeService employeeService) {
        this.notificationService = notificationService;
        this.employeeService = employeeService;
    }

    /**
     * Sends a notification to an employee.
     *
     * @param employeeID the ID of the employee
     * @param message    the notification message
     * @param model      the model
     * @return the name of the view
     */
    @PostMapping("/send")
    public String sendNotification(@RequestParam Long employeeID,
                                   @RequestParam String message,
                                   Model model) {
        Employee employee = employeeService.getEmployeeById(employeeID);
        model.addAttribute("notification", notificationService.sendNotification(employee, message));
        return "sendNotification";
    }

    /**
     * Retrieves a notification by its ID.
     *
     * @param notificationID the ID of the notification
     * @param model          the model
     * @return the name of the view
     */
    @GetMapping("/{notificationID}")
    public String getNotification(@PathVariable Long notificationID,
                                  Model model) {
        model.addAttribute("notification", notificationService.getNotification(notificationID));
        return "viewNotification";
    }

    /**
     * Retrieves all notifications for an employee.
     *
     * @param employeeID the ID of the employee
     * @param model      the model
     * @return the name of the view
     */
    @GetMapping("/list/{employeeID}")
    public String getNotificationsByEmployee(@PathVariable Long employeeID,
                                             Model model) {
        Employee employee = employeeService.getEmployeeById(employeeID);
        model.addAttribute("notifications", notificationService.getNotificationsByEmployee(employee));
        return "listNotifications";
    }

    /**
     * Marks a notification as read.
     *
     * @param notificationID the ID of the notification
     * @return the name of the view
     */
    @PostMapping("/read/{notificationID}")
    public String markNotificationAsRead(@PathVariable Long notificationID) {
        notificationService.markNotificationAsRead(notificationID);
        return "notificationRead";
    }

    /**
     * Deletes a notification.
     *
     * @param notificationID the ID of the notification
     * @return the name of the view
     */
    @PostMapping("/delete/{notificationID}")
    public String deleteNotification(@PathVariable Long notificationID) {
        notificationService.deleteNotification(notificationID);
        return "notificationDeleted";
    }

    /**
     * Notifications Landing Page
     *
     * @return String of name of Thymeleaf template.
     */
    @GetMapping("/notifications")
    public String notificationsLandingPage(@AuthenticationPrincipal CustomUserDetails userDetails, Model model){
        Long recipientID = userDetails.getEmployeeID();
        Employee recipient = employeeService.getEmployeeById(recipientID);
        model.addAttribute("recipient", recipient);
        model.addAttribute("notifications", notificationService.getNotificationsByEmployee(recipient));
        model.addAttribute("recipientID", recipientID);
        model.addAttribute("page", "notifications");
        return "notifications/notifications";
    }
}
