package com.buffettinc.hrms.service.communication;

import com.buffettinc.hrms.model.communication.Message;
import com.buffettinc.hrms.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.UUID;

/**
 * This interface provides methods to manage {@link Message}s between employees in the system.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface MessageService {

    /**
     * Sends a message from the sender to the recipient.
     *
     * @param sender    the sender of the message
     * @param recipient the recipient of the message
     * @param title     the title of the message
     * @param message   the content of the message
     * @return the created message
     */
    Message sendMessage(Employee sender, Employee recipient, String title, String message);

    /**
     * Retrieves a page of messages sent by the specified employee.
     *
     * @param sender     the sender employee
     * @param pageable   the pagination information
     * @return a page of sent messages
     */
    Page<Message> getSentMessages(Employee sender, Pageable pageable);

    /**
     * Retrieves a page of messages received by the specified employee.
     *
     * @param recipient  the recipient employee
     * @param pageable   the pagination information
     * @return a page of received messages
     */
    Page<Message> getReceivedMessages(Employee recipient, Pageable pageable);

    /**
     * Marks a message as read.
     *
     * @param messageID  the ID of the message to mark as read
     * @return the updated message
     */
    Message markMessageAsRead(Long messageID);

    /**
     * Gets a list of all messages that one user has received.
     * @param recipientID ID of the recipient
     * @return List of all messages received
     */
    List<Message> getReceivedMessagesByID(Long recipientID);

    /**
     * Deletes a message.
     *
     * @param messageID  the ID of the message to delete
     */
    void deleteMessage(Long messageID);

    void saveMessage(Message newMessage);

    Message getMessageById(Long messageID);
}
