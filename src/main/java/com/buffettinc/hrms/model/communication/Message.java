package com.buffettinc.hrms.model.communication;

import com.buffettinc.hrms.model.employee.Employee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.time.LocalDateTime;
import java.util.concurrent.ThreadLocalRandom;

/**
 * Class used to represent a Message sent or received by an {@link Employee} of Buffett Inc.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long messageID;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "sender")
    private Employee sender;
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "recipient")
    private Employee recipient;
    @Column(name="timestamp")
    private LocalDateTime timestamp;
    @Column(name="title")
    private String title;
    @Column(name="content")
    private String content;
    @Column(name="isRead")
    private boolean isRead;

    public Message(Employee sender, Employee recipient, String title, String content) {
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.content = content;
        this.isRead = false;
        this.timestamp = LocalDateTime.now();
    }

    public Message() {
        this.sender = null;
        this.recipient = null;
        this.title = null;
        this.content = null;
        this.isRead = false;
        this.timestamp = LocalDateTime.now();
    }

    public Long getMessageID() {
        return messageID;
    }

    public void setMessageID(Long messageID) {
        this.messageID = messageID;
    }

    public Employee getSender() {
        return sender;
    }

    public void setSender(Employee sender) {
        this.sender = sender;
    }

    public Employee getRecipient() {
        return recipient;
    }

    public void setRecipient(Employee recipient) {
        this.recipient = recipient;
    }

    public LocalDateTime getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(LocalDateTime timestamp) {
        this.timestamp = timestamp;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String message) {
        this.content = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
