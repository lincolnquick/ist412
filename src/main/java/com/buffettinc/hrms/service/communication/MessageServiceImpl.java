package com.buffettinc.hrms.service.communication;

import com.buffettinc.hrms.model.communication.Message;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.repository.communication.MessageRepository;
import com.buffettinc.hrms.repository.employee.EmployeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class implements the {@link MessageService} interface and provides methods to manage messages between employees in the system.
 */
@Service
@Transactional
public class MessageServiceImpl implements MessageService {

    private final MessageRepository messageRepository;
    @Autowired
    private final EmployeeRepository employeeRepository;

    @Autowired
    public MessageServiceImpl(MessageRepository messageRepository, EmployeeRepository employeeRepository) {
        this.messageRepository = messageRepository;
        this.employeeRepository = employeeRepository;
    }

    @Override
    public int countByIsReadFalseAndRecipient(Employee employee) {
        return this.messageRepository.countByIsReadFalseAndRecipient(employee);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message sendMessage(Employee sender, Employee recipient, String title, String message) {
        return messageRepository.save(new Message(sender, recipient, title, message));
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Message> getSentMessages(Employee sender, Pageable pageable) {
        return messageRepository.findBySender(sender, pageable);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Message> getReceivedMessages(Employee recipient, Pageable pageable) {
        return messageRepository.findByRecipient(recipient, pageable);
    }

    public List<Message> getReceivedMessagesByID(Long recipientID){
        Optional<Employee> recipient = employeeRepository.findById(recipientID);
        if (recipient.isPresent()){
            return messageRepository.findListByRecipient(recipient.get());
        } else {
            return null;
        }

    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Message markMessageAsRead(Long messageID) {
        Message message = messageRepository.findById(messageID)
                .orElseThrow(() -> new IllegalArgumentException("Invalid message ID: " + messageID));
        message.setRead(true);
        return messageRepository.save(message);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteMessage(Long messageID) {
        messageRepository.deleteById(messageID);
    }

    @Override
    public void saveMessage(Message newMessage) {
        messageRepository.save(newMessage);
    }

    @Override
    public Message getMessageById(Long messageID) {
        return messageRepository.getReferenceById(messageID);
    }
}
