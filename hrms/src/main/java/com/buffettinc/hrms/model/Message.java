package com.buffettinc.hrms.model;

import java.util.UUID;
import java.time.LocalDateTime;

/**
 * Class used to represent a Message sent or received by an Employee of Buffett Inc.
 */
public class Message {
    private UUID messageID;
    private UUID senderID;
    private UUID recipientID;
    private LocalDateTime timestamp;
    private String title;
    private String message;
    private boolean isRead;

    public Message(UUID senderID, UUID recipientID, String title, String message) {
        this.messageID = UUID.randomUUID();
        this.senderID = senderID;
        this.recipientID = recipientID;
        this.title = title;
        this.message = message;
        this.isRead = false;
    }

    public UUID getMessageID() {
        return messageID;
    }

    public void setMessageID(UUID messageID) {
        this.messageID = messageID;
    }

    public UUID getSenderID() {
        return senderID;
    }

    public void setSenderID(UUID senderID) {
        this.senderID = senderID;
    }

    public UUID getRecipientID() {
        return recipientID;
    }

    public void setRecipientID(UUID recipientID) {
        this.recipientID = recipientID;
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
