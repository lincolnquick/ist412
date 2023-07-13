package com.buffettinc.hrms.repository;

import com.buffettinc.hrms.model.Employee;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.UUID;

/**
 * This is the repository interface for the {@link Employee} entity.
 * It extends {@link JpaRepository} to provide methods for CRUD operations.
 * Additional query methods can be defined here as needed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface EmployeeRepository extends JpaRepository<Employee, UUID> {

}
