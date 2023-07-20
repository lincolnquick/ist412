package com.buffettinc.hrms.service.communication;

import com.buffettinc.hrms.model.communication.Notification;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.repository.communication.NotificationRepository;
import com.buffettinc.hrms.repository.employee.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.UUID;
import java.util.List;

/**
 * Implementation of the NotificationService interface.
 */
@Service
public class NotificationServiceImpl implements NotificationService {

    private final NotificationRepository notificationRepository;
    private final EmployeeRepository employeeRepository;

    public NotificationServiceImpl(NotificationRepository notificationRepository, EmployeeRepository employeeRepository) {
        this.notificationRepository = notificationRepository;
        this.employeeRepository = employeeRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Notification sendNotification(Employee employee, String message) {
        Employee recipient = employeeRepository.findById(employee.getEmployeeID())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employee.getEmployeeID()));

        Notification notification = new Notification(recipient, message);
        return notificationRepository.save(notification);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Notification getNotification(Long notificationID) {
        return notificationRepository.findById(notificationID)
                .orElseThrow(() -> new RuntimeException("Notification not found with ID: " + notificationID));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Notification> getNotificationsByEmployee(Employee employee) {
        Employee recipient = employeeRepository.findById(employee.getEmployeeID())
                .orElseThrow(() -> new RuntimeException("Employee not found with ID: " + employee.getEmployeeID()));

        return notificationRepository.findByEmployee(recipient);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void markNotificationAsRead(Long notificationID) {
        Notification notification = notificationRepository.findById(notificationID)
                .orElseThrow(() -> new RuntimeException("Notification not found with ID: " + notificationID));

        notification.setRead(true);
        notificationRepository.save(notification);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteNotification(Long notificationID) {
        Notification notification = notificationRepository.findById(notificationID)
                .orElseThrow(() -> new RuntimeException("Notification not found with ID: " + notificationID));

        notificationRepository.delete(notification);
    }
}
