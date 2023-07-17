package com.buffettinc.hrms.service.employee;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.repository.employee.EmployeeRepository;
import com.buffettinc.hrms.service.employee.EmployeeService;
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

    /**
     * {@inheritDoc}
     */
    public EmployeeServiceImpl(EmployeeRepository employeeRepository) {
        this.employeeRepository = employeeRepository;
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public Employee updateEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public Employee createEmployee(Employee employee) {
        return this.employeeRepository.save(employee);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public List<Employee> getAllEmployees() {
        return this.employeeRepository.findAll();
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public Employee getEmployeeById(UUID id) {
        return this.employeeRepository.findById(id).orElse(null);
    }


    @Override
    /**
     * {@inheritDoc}
     */
    public void deleteEmployee(UUID id) {
        this.employeeRepository.deleteById(id);
    }

    @Override
    /**
     * {@inheritDoc}
     */
    public Page<Employee> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        PageRequest pageRequest = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.employeeRepository.findAll(pageRequest);
    }
}
