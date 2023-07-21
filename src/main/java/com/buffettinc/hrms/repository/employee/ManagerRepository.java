package com.buffettinc.hrms.repository.employee;

import com.buffettinc.hrms.model.communication.Observer;
import com.buffettinc.hrms.model.employee.Manager;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

/**
 * This is the repository interface for the {@link Manager} entity.
 * It extends {@link JpaRepository} to provide methods for CRUD operations.
 * Additional query methods can be defined here as needed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface ManagerRepository extends JpaRepository<Manager, Long> {
    Optional<Manager> findByEmployeeID(Long employeeID);
    // custom methods if necessary


    List<Observer> findAllByDepartment(String department);
}
