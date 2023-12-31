package com.buffettinc.hrms.controller.communication;

import com.buffettinc.hrms.model.communication.Message;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.service.communication.MessageService;
import com.buffettinc.hrms.service.employee.EmployeeService;
import com.buffettinc.hrms.service.user.CustomUserDetails;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.List;
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
     * @param model the model
     * @return the name of the view
     */
    @PostMapping("/send")
    public String sendMessage(@RequestParam("senderID") Long senderID,
                              @RequestParam("recipientID") Long recipientID,
                              @RequestParam("content") String content,
                              @RequestParam("title") String title,
                              Model model) {

        Employee sender = employeeService.getEmployeeById(senderID);
        Employee recipient = employeeService.getEmployeeById(recipientID);
        Message message = new Message(sender, recipient, title, content);
        messageService.saveMessage(message);
        return "redirect:/messages/messages";
    }


    /**
     * Handles getting sent messages for a specified employee.
     *
     * @param senderID the ID of the sender
     * @param model the model
     * @return the name of the view
     */
    @GetMapping("/sent")
    public String getSentMessages(@RequestParam Long senderID, Model model) {
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
    public String getReceivedMessages(@RequestParam Long recipientID, Model model) {
        Employee recipient = employeeService.getEmployeeById(recipientID);
        model.addAttribute("messages", messageService.getReceivedMessages(recipient, PageRequest.of(0, 20)));
        return "receivedMessages";
    }

    @GetMapping("/received/{recipientID}")
    @ResponseBody
    public List<Message> getReceivedMessages(@PathVariable Long recipientID) {
        Employee recipient = employeeService.getEmployeeById(recipientID);
        Page<Message> page = messageService.getReceivedMessages(recipient, PageRequest.of(0, 20));
        return page.getContent();
    }



    /**
     * Handles marking a message as read.
     *
     * @param messageID the ID of the message
     * @param model the model
     * @return the name of the view
     */
    @GetMapping("/read/{messageID}")
    public String readMessage(@PathVariable("messageID") Long messageID) {
        messageService.markMessageAsRead(messageID);
        return "redirect:/messages/messages";
    }


    /**
     * Handles deleting a message.
     *
     * @param messageID the ID of the message
     * @return the name of the view
     */
    @GetMapping("/delete/{messageID}")
    public String deleteMessage(@PathVariable("messageID") Long messageID) {
        messageService.deleteMessage(messageID);
        return "redirect:/messages/messages";
    }

    @GetMapping("/messages")
    public String messagesLandingPage(@AuthenticationPrincipal CustomUserDetails userDetails, Model model){
        Long recipientID = userDetails.getEmployeeID();
        Employee recipient = employeeService.getEmployeeById(recipientID);
        model.addAttribute("recipient", recipient);
        model.addAttribute("messages", messageService.getReceivedMessagesByID(recipientID));
        model.addAttribute("recipientID", recipientID);
        model.addAttribute("page", "messages");

        return "messages/messages";
    }

    @GetMapping("/view/{id}")
    public String viewMessage(@PathVariable("id") Long messageID, Model model) {
        Message message = messageService.getMessageById(messageID);
        model.addAttribute("message", message);
        return "viewMessage";
    }

    @GetMapping("/compose")
    public String composeMessage(Model model, Authentication authentication) {
        List<Employee> allEmployees = employeeService.getAllEmployees();

        CustomUserDetails userDetails = (CustomUserDetails) authentication.getPrincipal();
        Long senderID = userDetails.getEmployeeID();

        allEmployees.removeIf(e -> e.getEmployeeID().equals(senderID)); // Remove the sender from the list
        model.addAttribute("employees", allEmployees);
        model.addAttribute("senderID", senderID); // Add the sender ID to the model
        model.addAttribute("message", new Message());
        return "messages/composeMessage";
    }



    @PostMapping("/reply")
    public String replyMessage(@RequestParam Long messageID, @RequestParam String content, Model model) {
        Message oldMessage = messageService.getMessageById(messageID);
        Message newMessage = new Message(oldMessage.getRecipient(), oldMessage.getSender(), "Re: " + oldMessage.getTitle(), content);
        messageService.saveMessage(newMessage);
        return "redirect:/messages";
    }

    @GetMapping
    public String messagesPage(Model model) {

        return "messages";
    }

}
