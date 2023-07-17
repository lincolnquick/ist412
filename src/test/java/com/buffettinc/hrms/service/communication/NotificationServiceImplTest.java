package com.buffettinc.hrms.service.communication;

import com.buffettinc.hrms.model.communication.Notification;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.repository.communication.NotificationRepository;
import com.buffettinc.hrms.repository.employee.EmployeeRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.*;

class NotificationServiceImplTest {

    @InjectMocks
    private NotificationServiceImpl notificationService;

    @Mock
    private NotificationRepository notificationRepository;

    @Mock
    private EmployeeRepository employeeRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendNotification() {
        Employee employee = new Employee();
        String message = "Test Notification for you, IST 412 Student!";

        when(employeeRepository.findById(any(UUID.class))).thenReturn(Optional.of(employee));

        Notification expectedNotification = new Notification(employee, message);
        when(notificationRepository.save(any(Notification.class))).thenReturn(expectedNotification);

        Notification actualNotification = notificationService.sendNotification(employee, message);
        assertEquals(expectedNotification, actualNotification);
    }

    @Test
    void getNotification() {
        UUID id = UUID.randomUUID();
        Notification expectedNotification = new Notification();
        when(notificationRepository.findById(id)).thenReturn(Optional.of(expectedNotification));

        Notification actualNotification = notificationService.getNotification(id);
        assertEquals(expectedNotification, actualNotification);
    }

    @Test
    void getNotificationsByEmployee() {
        Employee employee = new Employee();
        List<Notification> expectedNotifications = new ArrayList<>();
        when(employeeRepository.findById(any(UUID.class))).thenReturn(Optional.of(employee));
        when(notificationRepository.findByEmployee(any(Employee.class))).thenReturn(expectedNotifications);

        List<Notification> actualNotifications = notificationService.getNotificationsByEmployee(employee);
        assertEquals(expectedNotifications, actualNotifications);
    }

    @Test
    void markNotificationAsRead() {
        UUID id = UUID.randomUUID();
        Notification expectedNotification = new Notification();
        expectedNotification.setRead(true);
        when(notificationRepository.findById(id)).thenReturn(Optional.of(expectedNotification));
        when(notificationRepository.save(any(Notification.class))).thenReturn(expectedNotification);

        notificationService.markNotificationAsRead(id);
        verify(notificationRepository, times(1)).save(expectedNotification);
    }

    @Test
    void deleteNotification() {
        UUID id = UUID.randomUUID();
        Notification notification = new Notification();
        when(notificationRepository.findById(id)).thenReturn(Optional.of(notification));

        notificationService.deleteNotification(id);
        verify(notificationRepository, times(1)).delete(notification);
    }
}
