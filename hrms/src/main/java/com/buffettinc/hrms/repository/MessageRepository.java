package com.buffettinc.hrms.repository;

import com.buffettinc.hrms.model.communication.Message;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * This is the repository interface for the {@link Message} entity.
 * It extends {@link JpaRepository} to provide methods for CRUD operations.
 * Additional query methods can be defined here as needed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface MessageRepository extends JpaRepository<Message, UUID> {
    // custom methods if necessary
}
