package com.buffettinc.hrms.controller.communication;

import com.buffettinc.hrms.controller.communication.MessageController;
import com.buffettinc.hrms.model.communication.Message;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.service.communication.MessageService;
import com.buffettinc.hrms.service.employee.EmployeeService;
import org.junit.jupiter.api.Test;
import org.springframework.data.domain.PageRequest;
import org.springframework.ui.Model;

import java.util.UUID;

import static org.mockito.Mockito.*;

class MessageControllerTest {
    private final MessageService messageService = mock(MessageService.class);
    private final EmployeeService employeeService = mock(EmployeeService.class);
    private final Model model = mock(Model.class);
    private final MessageController controller = new MessageController(messageService, employeeService);

    @Test
    void sendMessage() {
        UUID senderId = UUID.randomUUID();
        UUID recipientId = UUID.randomUUID();
        Employee sender = new Employee();
        Employee recipient = new Employee();
        Message message = new Message();

        when(employeeService.getEmployeeById(senderId)).thenReturn(sender);
        when(employeeService.getEmployeeById(recipientId)).thenReturn(recipient);
        when(messageService.sendMessage(sender, recipient, "Title", "Message")).thenReturn(message);

        controller.sendMessage(message, senderId, recipientId,  model);

        verify(messageService).sendMessage(sender, recipient, "Title", "Message");
        verify(model).addAttribute("message", message);
    }

    @Test
    void getSentMessages() {
        UUID senderId = UUID.randomUUID();
        Employee sender = new Employee();

        when(employeeService.getEmployeeById(senderId)).thenReturn(sender);

        controller.getSentMessages(senderId, model);

        verify(messageService).getSentMessages(sender, PageRequest.of(0, 20));
        verify(model).addAttribute(eq("messages"), any());
    }

    @Test
    void getReceivedMessages() {
        UUID recipientId = UUID.randomUUID();
        Employee recipient = new Employee();

        when(employeeService.getEmployeeById(recipientId)).thenReturn(recipient);

        controller.getReceivedMessages(recipientId, model);

        verify(messageService).getReceivedMessages(recipient, PageRequest.of(0, 20));
        verify(model).addAttribute(eq("messages"), any());
    }

    @Test
    void markMessageAsRead() {
        UUID messageId = UUID.randomUUID();
        Message message = new Message();

        when(messageService.markMessageAsRead(messageId)).thenReturn(message);

        controller.markMessageAsRead(messageId, model);

        verify(messageService).markMessageAsRead(messageId);
        verify(model).addAttribute("message", message);
    }

    @Test
    void deleteMessage() {
        UUID messageId = UUID.randomUUID();

        controller.deleteMessage(messageId);

        verify(messageService).deleteMessage(messageId);
    }
}

