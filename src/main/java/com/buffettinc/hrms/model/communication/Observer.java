package com.buffettinc.hrms.model.communication;

import com.buffettinc.hrms.model.communication.Notification;

public interface Observer {
    void update(Notification notification);
}
