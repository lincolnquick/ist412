package com.buffettinc.hrms.repository.employee;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.Manager;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
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

    Page<Employee> findByManager(Manager manager, Pageable pageable);

    @Query("SELECT e FROM Employee e WHERE e.employeeID NOT IN (SELECT u.employee.employeeID FROM User u)")
    List<Employee> findUnregisteredEmployees();
}

