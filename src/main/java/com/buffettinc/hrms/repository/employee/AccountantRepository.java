package com.buffettinc.hrms.repository.employee;

import com.buffettinc.hrms.model.employee.Accountant;
import com.buffettinc.hrms.model.employee.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;
import java.util.UUID;

/**
 * This is the repository interface for the {@link Accountant} entity.
 * It extends {@link JpaRepository} to provide methods for CRUD operations.
 * Additional query methods can be defined here as needed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface AccountantRepository extends JpaRepository<Accountant, Long> {
    // custom methods if necessary
    Optional<Accountant> findByEmployeeID(Long employeeID);
}
