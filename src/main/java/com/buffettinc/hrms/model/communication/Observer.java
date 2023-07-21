package com.buffettinc.hrms.model.communication;

import com.buffettinc.hrms.model.communication.Notification;

/**
 * This interface allows Employees, Managers, HRStaff, Accountants, and Applicants to follow the Observer
 * behavioral pattern.
 *
 * @author IST 412 Group 5
 * @since 2023-07-21
 */
public interface Observer {
    void update(Notification notification);
}
