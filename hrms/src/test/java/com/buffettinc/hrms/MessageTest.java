package com.buffettinc.hrms;

import com.buffettinc.hrms.model.communication.Message;
import com.buffettinc.hrms.model.employee.Employee;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;

import static org.junit.jupiter.api.Assertions.*;

class MessageTest {

    @Test
    void getMessageID() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        UUID testID = testMessage.getMessageID();
        boolean testResult = true;
        if (testID.equals(null)) {
            testResult = false;
        }
        Assertions.assertEquals(true, testResult);
    }

    @Test
    void setMessageID() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");
        UUID testID = UUID.randomUUID();

        testMessage.setMessageID(testID);

        UUID testResult = testMessage.getMessageID();
        Assertions.assertEquals(testID, testResult);
    }

    @Test
    void getSender() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        Employee testSender = testMessage.getSender();
        boolean testResult = true;
        if(testSender.equals(null)){
            testResult = false;
        }
        Assertions.assertEquals(true, testResult);
    }

    @Test
    void setSender() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        Employee testSender = new Employee();
        testMessage.setSender(testSender);

        Employee testResult = testMessage.getSender();

        Assertions.assertEquals(testSender, testResult);
    }

    @Test
    void getRecipient() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        Employee testRecipient = testMessage.getRecipient();
        boolean testResult = true;
        if(testRecipient.equals(null)){
            testResult = false;
        }
        Assertions.assertEquals(true, testResult);
    }

    @Test
    void setRecipient() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        Employee testRecipient = new Employee();
        testMessage.setRecipient(testRecipient);

        Employee testResult = testMessage.getRecipient();

        Assertions.assertEquals(testRecipient, testResult);
    }

    @Test
    void getTimestamp() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        LocalDateTime testDateTime = testMessage.getTimestamp();
        boolean testResult = true;
        if(testDateTime.equals(null)){
            testResult = false;
        }
        Assertions.assertEquals(true, testResult);
    }

    @Test
    void setTimestamp() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        LocalDateTime testDateTime = LocalDateTime.now();
        testMessage.setTimestamp(testDateTime);

        LocalDateTime testResult = testMessage.getTimestamp();

        Assertions.assertEquals(testDateTime, testResult);
    }

    @Test
    void getTitle() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        String testTitle = testMessage.getTitle();
        boolean testResult = true;
        if(testTitle.equals(null)){
            testResult = false;
        }
        Assertions.assertEquals(true, testResult);
    }

    @Test
    void setTitle() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        String testTitle = "new test";
        testMessage.setTitle(testTitle);

        String testResult = testMessage.getTitle();

        Assertions.assertEquals(testTitle, testResult);
    }

    @Test
    void getMessage() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        String testWords = testMessage.getMessage();
        boolean testResult = true;
        if(testWords.equals(null)){
            testResult = false;
        }
        Assertions.assertEquals(true, testResult);
    }

    @Test
    void setMessage() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        String testMessageNew = "new test message";
        testMessage.setMessage(testMessageNew);

        String testResult = testMessage.getMessage();

        Assertions.assertEquals(testMessageNew, testResult);

    }

    @Test
    void isRead() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        boolean testRead = testMessage.isRead();

        Assertions.assertEquals(false, testRead);
    }

    @Test
    void setRead() {
        Message testMessage = new Message(new Employee(), new Employee(), "test", "test message");

        boolean testRead = true;
        testMessage.setRead(testRead);
        boolean testResult = testMessage.isRead();

        Assertions.assertEquals(testRead, testResult);
    }
}