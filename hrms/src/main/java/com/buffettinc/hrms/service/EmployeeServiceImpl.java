package com.buffettinc.hrms.service;

import com.buffettinc.hrms.model.Employee;
import com.buffettinc.hrms.repository.EmployeeRepository;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation for {@link Employee} service interface, containing methods for performing CRUD operations on Employee objects
 * as well as for fetching paginated data.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class EmployeeServiceImpl implements EmployeeService {

    private final EmployeeRepository employeeRepository;

    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    public Employee saveEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    public Employee getEmployeeById(UUID id) {
        return this.employeeRepository.findById(id).orElse(null);
    }

    @Override
    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    public void deleteEmployee(UUID id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        PageRequest pageRequest = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageRequest);
    }
}
