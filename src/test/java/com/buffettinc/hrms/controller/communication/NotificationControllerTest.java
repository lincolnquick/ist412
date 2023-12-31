package com.buffettinc.hrms.controller.communication;

import com.buffettinc.hrms.controller.communication.NotificationController;
import com.buffettinc.hrms.model.communication.Notification;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.service.communication.NotificationService;
import com.buffettinc.hrms.service.employee.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.ui.Model;

import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static org.mockito.Mockito.*;

class NotificationControllerTest {
    private final NotificationService notificationService = mock(NotificationService.class);
    private final EmployeeService employeeService = mock(EmployeeService.class);
    private final Model model = mock(Model.class);
    private final NotificationController controller = new NotificationController(notificationService, employeeService);

    @Test
    void sendNotification() {
        Long employeeId = ThreadLocalRandom.current().nextLong(1, 1000);
        Employee employee = new Employee();
        Notification notification = new Notification();

        when(employeeService.getEmployeeById(employeeId)).thenReturn(employee);
        when(notificationService.sendNotification(employee, "Notification")).thenReturn(notification);

        controller.sendNotification(employeeId, "Notification", model);

        verify(notificationService).sendNotification(employee, "Notification");
        verify(model).addAttribute("notification", notification);
    }

    @Test
    void getNotification() {
        Long notificationId = ThreadLocalRandom.current().nextLong(1, 1000);
        Notification notification = new Notification();

        when(notificationService.getNotification(notificationId)).thenReturn(notification);

        controller.getNotification(notificationId, model);

        verify(notificationService).getNotification(notificationId);
        verify(model).addAttribute("notification", notification);
    }

    @Test
    void getNotificationsByEmployee() {
        Long employeeId = ThreadLocalRandom.current().nextLong(1, 1000);
        Employee employee = new Employee();

        when(employeeService.getEmployeeById(employeeId)).thenReturn(employee);

        controller.getNotificationsByEmployee(employeeId, model);

        verify(notificationService).getNotificationsByEmployee(employee);
        verify(model).addAttribute(eq("notifications"), any());
    }

    @Test
    void markNotificationAsRead() {
        Long notificationId = ThreadLocalRandom.current().nextLong(1, 1000);

        controller.markNotificationAsRead(notificationId);

        verify(notificationService).markNotificationAsRead(notificationId);
    }

    @Test
    void deleteNotification() {
        Long notificationId = ThreadLocalRandom.current().nextLong(1, 1000);

        controller.deleteNotification(notificationId);

        verify(notificationService).deleteNotification(notificationId);
    }
}
