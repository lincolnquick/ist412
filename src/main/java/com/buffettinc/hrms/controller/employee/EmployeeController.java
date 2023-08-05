package com.buffettinc.hrms.controller.employee;

import com.buffettinc.hrms.model.employee.Accountant;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.HRStaff;
import com.buffettinc.hrms.model.employee.Manager;
import com.buffettinc.hrms.service.employee.AccountantService;
import com.buffettinc.hrms.service.employee.EmployeeService;
import com.buffettinc.hrms.service.employee.HRStaffService;
import com.buffettinc.hrms.service.employee.ManagerService;
import org.springframework.beans.factory.annotation.Autowired;
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
    private final AccountantService accountantService;
    private final HRStaffService hrStaffService;
    private final ManagerService managerService;

    @Autowired
    public EmployeeController(EmployeeService employeeService, AccountantService accountantService,
                              HRStaffService hrStaffService, ManagerService managerService) {
        this.employeeService = employeeService;
        this.accountantService = accountantService;
        this.hrStaffService = hrStaffService;
        this.managerService = managerService;
    }

    /**
     * Displays the page with the list of all employees.
     *
     * @return String, name of the template file for displaying all employees.
     */
    @GetMapping("list")
    public String listAllEmployees(Model model) {
        model.addAttribute("employees", employeeService.getOnlyEmployees());
        model.addAttribute("accountants", accountantService.getAllAccountants());
        model.addAttribute("hrstaff", hrStaffService.getAllHRStaff());
        model.addAttribute("managers", managerService.getAllManagers());
        model.addAttribute("page", "employees");
        return "employees/list"; // corresponds to a Thymeleaf template in "src/main/resources/templates/employees/list.html"
    }

    /**
     * Displays the page for creating a new employee.
     *
     * @return String, name of the template file for creating a new employee.
     */
    @GetMapping("new")
    public String createEmployeeForm(Model model) {
        model.addAttribute("employee", new Employee());
        model.addAttribute("managers", managerService.getAllManagers());
        return "employees/new"; // corresponds to a Thymeleaf template in "src/main/resources/templates/employees/new.html"
    }

    /**
     * Saves a new employee and redirects to the list of employees.
     *
     * @param employee, the employee to save.
     * @return String, the redirect URL.
     */
    @PostMapping("save")
    public String saveEmployee(@ModelAttribute("employee") Employee employee, @RequestParam String employeeType) {
        switch (employeeType) {
            case "Manager":
                managerService.createManager(new Manager(employee));
                break;
            case "HRStaff":
                hrStaffService.createHRStaff(new HRStaff(employee));
                break;
            case "Accountant":
                accountantService.createAccountant(new Accountant(employee));
                break;
            default:
                employeeService.createEmployee(employee);
                break;
        }
        return "redirect:/employees/list";
    }



    /**
     * Displays the page for updating an existing employee.
     *
     * @param id, the ID of the employee to update.
     * @param model, the Spring model object.
     * @return String, name of the template file for updating an employee.
     */
    @GetMapping("/edit/{id}")
    public String editEmployeeForm(@PathVariable Long id, Model model) {
        model.addAttribute("employee", employeeService.getEmployeeById(id));
        return "employees/edit"; // returns the edit template, not a redirect
    }


    /**
     * Updates an existing employee and redirects to the list of employees.
     *
     * @param employee, the updated employee.
     * @return String, the redirect URL.
     */
    @PostMapping("/edit")
    public String updateEmployee(@ModelAttribute("employee") Employee employee) {
        if (employee instanceof Manager) {
            managerService.updateManager((Manager) employee);
        } else if (employee instanceof HRStaff) {
            hrStaffService.updateHRStaff((HRStaff) employee);
        } else if (employee instanceof Accountant) {
            accountantService.updateAccountant((Accountant) employee);
        } else {
            employeeService.updateEmployee(employee);
        }
        return "redirect:/employees/list";
    }


    /**
     * Deletes an employee and redirects to the list of employees.
     *
     * @param id, the ID of the employee to delete.
     * @return String, the redirect URL.
     */
    @GetMapping("/delete/{id}")
    public String deleteEmployee(@PathVariable Long id) {
        employeeService.deleteEmployee(id);
        return "redirect:/employees/list";
    }

}
