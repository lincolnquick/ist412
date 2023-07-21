package com.buffettinc.hrms.model.communication;

import com.buffettinc.hrms.model.communication.Notification;

/**
 * This interface allows Employees, Managers, HRStaff, Accountants, and Applicants to follow the Observer
 * behavioral pattern.
 */
public interface Observer {
    void update(Notification notification);
}
