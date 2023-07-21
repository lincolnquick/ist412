package com.buffettinc.hrms.config;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.user.User;
import com.buffettinc.hrms.repository.employee.EmployeeRepository;
import com.buffettinc.hrms.repository.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;

@Configuration
public class LoadDatabase {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final EmployeeRepository employeeRepository;

    public LoadDatabase(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder, EmployeeRepository employeeRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.employeeRepository = employeeRepository;
    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            try {
                // Check if user already exists in the database
                // if not load this user for debugging purposes.
                if (userRepository.findByUsername("user") == null) {
                    // Create and save employee before assigning to the user
                    Employee employee = new Employee();
                    employee.setHireDate(LocalDate.now());
                    employee.setFirstName("Group5");
                    employee.setLastName("IST412");
                    employee.setStreetAddress("123 Main St");
                    employee.setCity("State College");
                    employee.setState("PA");
                    employee.setZip("16801");
                    employee.setEmail("testemail@test.com");
                    employee.setPhone("8145551234");
                    employee.setDepartment("Quality Assurance");
                    employee.setPosition("Software Developer");

                    String username = "user";
                    String password = passwordEncoder.encode("password");

                    User user = new User(username, password, employee);

                    // set user to employee and employee to user
                    user.setEmployee(employee);
                    employee.setUser(user);

                    // save employee (and thus user because of CascadeType.ALL)
                    employeeRepository.save(employee);
                }
                if (userRepository.findByUsername("kong") == null) {
                    // Create and save employee before assigning to the user
                    Employee employee = new Employee();
                    employee.setHireDate(LocalDate.now());
                    employee.setFirstName("King");
                    employee.setLastName("Kong");
                    employee.setStreetAddress("Big Monkey Ave");
                    employee.setCity("Jungle");
                    employee.setState("Skull Island");
                    employee.setZip("12345");
                    employee.setEmail("banana@test.com");
                    employee.setPhone("5555555555");
                    employee.setDepartment("Building Climbing");
                    employee.setPosition("The Boss");

                    String username = "kong";
                    String password = passwordEncoder.encode("empire");

                    User user = new User(username, password, employee);

                    // set user to employee and employee to user
                    user.setEmployee(employee);
                    employee.setUser(user);

                    // save employee (and thus user because of CascadeType.ALL)
                    employeeRepository.save(employee);
                }
            } catch (Exception e) {
                e.printStackTrace();
            }

        };
    }
}