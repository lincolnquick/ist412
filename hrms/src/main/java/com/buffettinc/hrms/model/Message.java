package com.buffettinc.hrms.model;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;
import java.time.LocalDateTime;

/**
 * Class used to represent a Message sent or received by an Employee of Buffett Inc.
 */
@Entity
@Table(name = "message")
public class Message implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private UUID messageID;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "sender")
    private Employee sender;
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "recipient")
    private Employee recipient;
    @Column(name="timestamp")
    private LocalDateTime timestamp;
    @Column(name="title")
    private String title;
    @Column(name="message")
    private String message;
    @Column(name="isRead")
    private boolean isRead;

    public Message(Employee sender, Employee recipient, String title, String message) {
        this.messageID = UUID.randomUUID();
        this.sender = sender;
        this.recipient = recipient;
        this.title = title;
        this.message = message;
        this.isRead = false;
        this.timestamp = LocalDateTime.now();
    }

    public Message() {
        this.messageID = UUID.randomUUID();
        this.sender = null;
        this.recipient = null;
        this.title = null;
        this.message = null;
        this.isRead = false;
        this.timestamp = LocalDateTime.now();
    }

    public UUID getMessageID() {
        return messageID;
    }

    public void setMessageID(UUID messageID) {
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

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public boolean isRead() {
        return isRead;
    }

    public void setRead(boolean read) {
        isRead = read;
    }
}
