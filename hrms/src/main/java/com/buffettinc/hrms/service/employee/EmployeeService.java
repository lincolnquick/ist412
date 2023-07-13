package com.buffettinc.hrms.service.employee;

import com.buffettinc.hrms.model.employee.Employee;
import org.springframework.data.domain.Page;

import java.util.UUID;
import java.util.List;

/**
 * Interface for {@link Employee} service, containing methods for performing CRUD operations on Employee objects
 * as well as for fetching paginated data.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface EmployeeService {
    Employee saveEmployee(Employee employee);

    List<Employee> getAllEmployees();

    Employee getEmployeeById(UUID id);

    Employee updateEmployee(Employee employee);

    void deleteEmployee(UUID id);

    Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
