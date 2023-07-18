package com.buffettinc.hrms.controller.communication;

import com.buffettinc.hrms.model.communication.Message;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.service.communication.MessageService;
import com.buffettinc.hrms.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller for handling requests related to {@link Message}s.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/messages")
public class MessageController {
    @Autowired
    private MessageService messageService;
    @Autowired
    private EmployeeService employeeService;

    public MessageController() {
    }

    public MessageController(MessageService messageService, EmployeeService employeeService) {
        this.messageService = messageService;
        this.employeeService = employeeService;
    }

    /**
     * Handles sending a new message.
     *
     * @param senderID the ID of the sender
     * @param recipientID the ID of the recipient
     * @param title the title of the message
     * @param message the content of the message
     * @param model the model
     * @return the name of the view
     */
    @PostMapping("/send")
    public String sendMessage(@RequestParam UUID senderID,
                              @RequestParam UUID recipientID,
                              @RequestParam String title,
                              @RequestParam String message,
                              Model model) {
        Employee sender = employeeService.getEmployeeById(senderID);
        Employee recipient = employeeService.getEmployeeById(recipientID);
        model.addAttribute("message", messageService.sendMessage(sender, recipient, title, message));
        return "sendMessage";
    }

    /**
     * Handles getting sent messages for a specified employee.
     *
     * @param senderID the ID of the sender
     * @param model the model
     * @return the name of the view
     */
    @GetMapping("/sent")
    public String getSentMessages(@RequestParam UUID senderID, Model model) {
        Employee sender = employeeService.getEmployeeById(senderID);
        model.addAttribute("messages", messageService.getSentMessages(sender, PageRequest.of(0, 20)));
        return "sentMessages";
    }

    /**
     * Handles getting received messages for a specified employee.
     *
     * @param recipientID the ID of the recipient
     * @param model the model
     * @return the name of the view
     */
    @GetMapping("/received")
    public String getReceivedMessages(@RequestParam UUID recipientID, Model model) {
        Employee recipient = employeeService.getEmployeeById(recipientID);
        model.addAttribute("messages", messageService.getReceivedMessages(recipient, PageRequest.of(0, 20)));
        return "receivedMessages";
    }

    /**
     * Handles marking a message as read.
     *
     * @param messageID the ID of the message
     * @param model the model
     * @return the name of the view
     */
    @PostMapping("/read")
    public String markMessageAsRead(@RequestParam UUID messageID, Model model) {
        model.addAttribute("message", messageService.markMessageAsRead(messageID));
        return "readMessage";
    }

    /**
     * Handles deleting a message.
     *
     * @param messageID the ID of the message
     * @return the name of the view
     */
    @PostMapping("/delete")
    public String deleteMessage(@RequestParam UUID messageID) {
        messageService.deleteMessage(messageID);
        return "deleteMessage";
    }

    @GetMapping("/messages")
    public String messagesLandingPage(){
        return "messages/messages";
    }
}
