package com.buffettinc.hrms.model.communication;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.Manager;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.UUID;
import java.util.concurrent.ThreadLocalRandom;

import static org.junit.jupiter.api.Assertions.*;

class NotificationTest {

    @Test
    void isRead() {
        Employee employee = new Employee("FirstName", "LastName", "Street",
                "City", "State", "Zip", "Phone", "Email",
                LocalDate.parse("2010-07-05"), "Department", "Position", new Manager());

        Notification notification = new Notification(employee, "Test Notification");

        assertEquals(false, notification.isRead());
    }

    @Test
    void setRead() {
        Employee employee = new Employee("FirstName", "LastName", "Street",
                "City", "State", "Zip", "Phone", "Email",
                LocalDate.parse("2010-07-05"), "Department", "Position", new Manager());

        Notification notification = new Notification(employee, "Test Notification");

        notification.setRead(true);

        assertEquals(true, notification.isRead());
    }

    @Test
    void getNotificationID() {
        Employee employee = new Employee("FirstName", "LastName", "Street",
                "City", "State", "Zip", "Phone", "Email",
                LocalDate.parse("2010-07-05"), "Department", "Position", new Manager());

        Notification notification = new Notification(employee, "Test Notification");

        Long testID = notification.getNotificationID();
        boolean testResult = false;
        if (!testID.equals(null)){
            testResult = true;
        }
        assertEquals(true, testResult);
    }

    @Test
    void setNotificationID() {
        Employee employee = new Employee("FirstName", "LastName", "Street",
                "City", "State", "Zip", "Phone", "Email",
                LocalDate.parse("2010-07-05"), "Department", "Position", new Manager());

        Notification notification = new Notification(employee, "Test Notification");

        Long testID = ThreadLocalRandom.current().nextLong(1,1000);

        notification.setNotificationID(testID);

        assertEquals(testID, notification.getNotificationID());
    }

    @Test
    void getEmployee() {
        Employee employee = new Employee("FirstName", "LastName", "Street",
                "City", "State", "Zip", "Phone", "Email",
                LocalDate.parse("2010-07-05"), "Department", "Position", new Manager());

        Notification notification = new Notification(employee, "Test Notification");

        assertEquals(employee, notification.getEmployee());
    }

    @Test
    void setEmployee() {
        Employee employee = new Employee("FirstName", "LastName", "Street",
                "City", "State", "Zip", "Phone", "Email",
                LocalDate.parse("2010-07-05"), "Department", "Position", new Manager());

        Employee employee2 = new Employee("FirstName", "LastName", "Street",
                "City", "State", "Zip", "Phone", "Email",
                LocalDate.parse("2010-07-05"), "Department", "Position", new Manager());

        Notification notification = new Notification(employee, "Test Notification");

        notification.setEmployee(employee2);

        assertEquals(employee2, notification.getEmployee());
    }

    @Test
    void getMessage() {
        Employee employee = new Employee("FirstName", "LastName", "Street",
                "City", "State", "Zip", "Phone", "Email",
                LocalDate.parse("2010-07-05"), "Department", "Position", new Manager());

        Notification notification = new Notification(employee, "Test Notification");

        assertEquals("Test Notification", notification.getMessage());
    }

    @Test
    void setMessage() {
        Employee employee = new Employee("FirstName", "LastName", "Street",
                "City", "State", "Zip", "Phone", "Email",
                LocalDate.parse("2010-07-05"), "Department", "Position", new Manager());

        Notification notification = new Notification(employee, "Test Notification");

        notification.setMessage("Test Notification 2");

        assertEquals("Test Notification 2", notification.getMessage());
    }

    @Test
    void getTimestamp() {
        Employee employee = new Employee("FirstName", "LastName", "Street",
                "City", "State", "Zip", "Phone", "Email",
                LocalDate.parse("2010-07-05"), "Department", "Position", new Manager());

        Notification notification = new Notification(employee, "Test Notification");

        LocalDateTime testTime = notification.getTimestamp();

        boolean testResult = false;
        if(!testTime.equals(null)){
            testResult = true;
        }
        assertEquals(true, testResult);
    }

    @Test
    void setTimestamp() {
        Employee employee = new Employee("FirstName", "LastName", "Street",
                "City", "State", "Zip", "Phone", "Email",
                LocalDate.parse("2010-07-05"), "Department", "Position", new Manager());

        Notification notification = new Notification(employee, "Test Notification");

        LocalDateTime testTime = LocalDateTime.now();

        notification.setTimestamp(testTime);

        assertEquals(testTime, notification.getTimestamp());
    }
}