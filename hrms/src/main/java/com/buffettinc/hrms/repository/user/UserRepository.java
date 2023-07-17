package com.buffettinc.hrms.repository.user;

import com.buffettinc.hrms.model.user.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * This is the repository interface for the {@link User} entity.
 * It extends {@link JpaRepository} to provide methods for CRUD operations.
 * Additional query methods can be defined here as needed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface UserRepository extends JpaRepository<User, Long> {
    User findByUsername(String username);
}
