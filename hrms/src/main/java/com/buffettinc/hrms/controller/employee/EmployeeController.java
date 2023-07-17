package com.buffettinc.hrms.controller.employee;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.service.employee.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller class for handling requests for the {@link Employee} entity.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/employees")
public class EmployeeController {

    private final EmployeeService employeeService;

    @Autowired
    public EmployeeController(EmployeeService employeeService) {
        this.employeeService = employeeService;
    }

    /**
     * Displays the page with the list of all employees.
     *
     * @return String, name of the template file for displaying all employees.
     */
    @GetMapping("/list")
    public String listAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getAllEmployees());
        return "employees/list"; // corresponds to a Thymeleaf template in "src/main/resources/templates/employees/list.html"
    }

    /**
     * Displays the page for creating a new employee.
     *
     * @return String, name of the template file for creating a new employee.
     */
    @GetMapping("/new")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        return "employees/new"; // corresponds to a Thymeleaf template in "src/main/resources/templates/employees/new.html"
    }

    /**
     * Saves a new employee and redirects to the list of employees.
     *
     * @param employee, the employee to save.
     * @return String, the redirect URL.
     */
    @PostMapping
    public String saveEmployee(Employee employee) {
        employeeService.createEmployee(employee);
        return "redirect:/employees";
    }

    /**
     * Displays the page for updating an existing employee.
     *
     * @param id, the ID of the employee to update.
     * @param model, the Spring model object.
     * @return String, name of the template file for updating an employee.
     */
    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable UUID id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employees/edit"; // corresponds to a Thymeleaf template in "src/main/resources/templates/employees/edit.html"
    }

    /**
     * Updates an existing employee and redirects to the list of employees.
     *
     * @param employee, the updated employee.
     * @return String, the redirect URL.
     */
    @PostMapping("/edit")
    public String updateEmployee(Employee employee) {
        employeeService.updateEmployee(employee);
        return "redirect:/employees";
    }

    /**
     * Deletes an employee and redirects to the list of employees.
     *
     * @param id, the ID of the employee to delete.
     * @return String, the redirect URL.
     */
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable UUID id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees";
    }
}
