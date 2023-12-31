package com.buffettinc.hrms.repository.communication;

import com.buffettinc.hrms.model.communication.Notification;
import com.buffettinc.hrms.model.employee.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.UUID;

/**
 * This is the repository interface for the {@link Notification} entity.
 * It extends {@link JpaRepository} to provide methods for CRUD operations.
 * Additional query methods can be defined here as needed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface NotificationRepository extends JpaRepository<Notification, Long> {
    List<Notification> findByEmployee(Employee recipient);
    // custom methods if necessary
}
