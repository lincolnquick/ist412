package com.buffettinc.hrms.service.communication;

import com.buffettinc.hrms.model.communication.Notification;
import com.buffettinc.hrms.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.UUID;
import java.util.List;
/**
 * Service interface for managing notifications in the HRMS.
 */
public interface NotificationService {

    /**
     * Sends a notification to an employee.
     *
     * @param employee the employee to whom the notification is sent
     * @param message  the notification message
     * @return the created notification
     * @throws RuntimeException if the employee is not found
     */
    Notification sendNotification(Employee employee, String message);

    /**
     * Retrieves a notification by its ID.
     *
     * @param notificationID the ID of the notification
     * @return the notification
     * @throws RuntimeException if the notification is not found
     */
    Notification getNotification(UUID notificationID);

    /**
     * Retrieves all notifications for an employee.
     *
     * @param employee the employee for whom to retrieve notifications
     * @return the list of notifications
     * @throws RuntimeException if the employee is not found
     */
    List<Notification> getNotificationsByEmployee(Employee employee);

    /**
     * Marks a notification as read.
     *
     * @param notificationID the ID of the notification
     * @throws RuntimeException if the notification is not found
     */
    void markNotificationAsRead(UUID notificationID);

    /**
     * Deletes a notification.
     *
     * @param notificationID the ID of the notification
     * @throws RuntimeException if the notification is not found
     */
    void deleteNotification(UUID notificationID);
}
