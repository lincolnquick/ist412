package com.buffettinc.hrms.repository.communication;

import com.buffettinc.hrms.model.communication.Message;
import com.buffettinc.hrms.model.employee.Employee;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;


/**
 * This is the repository interface for the {@link Message} entity.
 * It extends {@link JpaRepository} to provide methods for CRUD operations.
 * Additional query methods can be defined here as needed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface MessageRepository extends JpaRepository<Message, Long> {
    Page<Message> findByRecipient(Employee recipient, Pageable pageable);

    List<Message> findListByRecipient(Employee recipient);

    Page<Message> findBySender(Employee sender, Pageable pageable);
    // custom methods if necessary
}
