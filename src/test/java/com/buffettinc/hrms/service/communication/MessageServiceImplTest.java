package com.buffettinc.hrms.service.communication;

import com.buffettinc.hrms.model.communication.Message;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.repository.communication.MessageRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.BeforeEach;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;

import java.util.Optional;
import java.util.UUID;

import static org.mockito.Mockito.*;
import static org.junit.jupiter.api.Assertions.*;

class MessageServiceImplTest {

    @InjectMocks
    private MessageServiceImpl messageService;

    @Mock
    private MessageRepository messageRepository;

    @BeforeEach
    void setUp() {
        MockitoAnnotations.openMocks(this);
    }

    @Test
    void sendMessage() {
        Employee sender = new Employee();
        Employee recipient = new Employee();
        String title = "Hello";
        String message = "How's IST 412 so far?";

        Message expectedMessage = new Message(sender, recipient, title, message);
        when(messageRepository.save(any(Message.class))).thenReturn(expectedMessage);

        Message actualMessage = messageService.sendMessage(sender, recipient, title, message);
        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void getSentMessages() {
        Employee sender = new Employee();
        Page<Message> expectedPage = Page.empty();
        when(messageRepository.findBySender(any(Employee.class), any(Pageable.class))).thenReturn(expectedPage);

        Page<Message> actualPage = messageService.getSentMessages(sender, PageRequest.of(0, 1));
        assertEquals(expectedPage, actualPage);
    }

    @Test
    void getReceivedMessages() {
        Employee recipient = new Employee();
        Page<Message> expectedPage = Page.empty();
        when(messageRepository.findByRecipient(any(Employee.class), any(Pageable.class))).thenReturn(expectedPage);

        Page<Message> actualPage = messageService.getReceivedMessages(recipient, PageRequest.of(0, 1));
        assertEquals(expectedPage, actualPage);
    }

    @Test
    void markMessageAsRead() {
        UUID id = UUID.randomUUID();
        Message expectedMessage = new Message();
        expectedMessage.setRead(true);
        when(messageRepository.findById(id)).thenReturn(Optional.of(expectedMessage));
        when(messageRepository.save(any(Message.class))).thenReturn(expectedMessage);

        Message actualMessage = messageService.markMessageAsRead(id);
        assertEquals(expectedMessage, actualMessage);
        assertTrue(actualMessage.isRead());
    }

    @Test
    void deleteMessage() {
        UUID id = UUID.randomUUID();
        messageService.deleteMessage(id);
        verify(messageRepository, times(1)).deleteById(id);
    }
}
