package com.buffettinc.hrms.config;
import com.buffettinc.hrms.model.employee.Accountant;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.HRStaff;
import com.buffettinc.hrms.model.employee.Manager;
import com.buffettinc.hrms.model.user.User;
import com.buffettinc.hrms.repository.communication.MessageRepository;
import com.buffettinc.hrms.repository.communication.NotificationRepository;
import com.buffettinc.hrms.repository.employee.AccountantRepository;
import com.buffettinc.hrms.repository.employee.EmployeeRepository;
import com.buffettinc.hrms.repository.employee.HRStaffRepository;
import com.buffettinc.hrms.repository.employee.ManagerRepository;
import com.buffettinc.hrms.repository.user.UserRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

import java.time.LocalDate;
import java.util.Optional;

@Configuration
public class LoadDatabase {

    private final UserRepository userRepository;
    private final BCryptPasswordEncoder passwordEncoder;
    private final EmployeeRepository employeeRepository;
    private final ManagerRepository managerRepository;
    private final HRStaffRepository hrStaffRepository;
    private final AccountantRepository accountantRepository;
    private final MessageRepository messageRepository;
    private final NotificationRepository notificationRepository;

    public LoadDatabase(UserRepository userRepository, BCryptPasswordEncoder passwordEncoder,
                        EmployeeRepository employeeRepository, ManagerRepository managerRepository,
                        HRStaffRepository hrStaffRepository, AccountantRepository accountantRepository,
                        MessageRepository messageRepository, NotificationRepository notificationRepository) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.employeeRepository = employeeRepository;
        this.managerRepository = managerRepository;
        this.hrStaffRepository = hrStaffRepository;
        this.accountantRepository = accountantRepository;
        this.messageRepository = messageRepository;
        this.notificationRepository = notificationRepository;

    }

    @Bean
    CommandLineRunner initDatabase() {
        return args -> {
            try {
                // Begin cast of The Office for sample employees.
                Manager mScott = new Manager("Scott", "Michael", "1725 Slough St, Suite 200", "Scranton", "PA",
                        "18503", "5709045026", "mscott@dundermifflin.com", LocalDate.now(), "Retail", "Manager", null);

                if (userRepository.findByUsername("mscott") == null) {

                    String username = "mscott";
                    String password = passwordEncoder.encode("password");
                    User user = new User(username, password, mScott);

                    // set user to employee and employee to user
                    user.setEmployee(mScott);
                    mScott.setUser(user);

                    // save employee (and thus user because of CascadeType.ALL)
                    managerRepository.save(mScott);
                }
                if (userRepository.findByUsername("jhalpert") == null) {
                    Optional<Manager> manager = managerRepository.findByEmployeeID(mScott.getEmployeeID());
                    Employee jimEmployee = new Employee("Halpert", "Jim", "1725 Slough St, Suite 200", "Scranton", "PA",
                            "18503", "5709045026", "jhalpert@dundermifflin.com", LocalDate.now(), "Retail", "Sales", manager.orElse(null));

                    String username = "jhalpert";
                    String password = passwordEncoder.encode("password");
                    User user = new User(username, password, jimEmployee);

                    // set user to employee and employee to user
                    user.setEmployee(jimEmployee);
                    jimEmployee.setUser(user);

                    // save employee (and thus user because of CascadeType.ALL)
                    employeeRepository.save(jimEmployee);
                }

                if (userRepository.findByUsername("dshrute") == null) {
                    Optional<Manager> manager = managerRepository.findByEmployeeID(mScott.getEmployeeID());
                    Employee dwightEmployee = new Employee("Schrute", "Dwight", "1725 Slough St, Suite 200", "Scranton", "PA",
                            "18503", "5709045026", "dshrute@dundermifflin.com", LocalDate.now(), "Retail", "Sales", manager.orElse(null));

                    String username = "dshrute";
                    String password = passwordEncoder.encode("password");
                    User user = new User(username, password, dwightEmployee);

                    // set user to employee and employee to user
                    user.setEmployee(dwightEmployee);
                    dwightEmployee.setUser(user);

                    // save employee (and thus user because of CascadeType.ALL)
                    employeeRepository.save(dwightEmployee);
                }

                if (userRepository.findByUsername("toby") == null) {
                    HRStaff tobyHR = new HRStaff("Flenderson", "Toby", "1725 Slough St, Suite 200", "Scranton", "PA",
                            "18503", "5709045026", "toby@dundermifflin.com", LocalDate.now(), "Human Resources", "HR Business Partner", null);

                    String username = "toby";
                    String password = passwordEncoder.encode("password");
                    User user = new User(username, password, tobyHR);

                    // set user to employee and employee to user
                    user.setEmployee(tobyHR);
                    tobyHR.setUser(user);

                    // save employee (and thus user because of CascadeType.ALL)
                    hrStaffRepository.save(tobyHR);
                }

                if (userRepository.findByUsername("amartin") == null) {
                    Optional<Manager> manager = managerRepository.findByEmployeeID(mScott.getEmployeeID());
                    Accountant angelaAccountant = new Accountant("Martin", "Angela", "1725 Slough St, Suite 200", "Scranton", "PA",
                            "18503", "5709045026", "amartin@dundermifflin.com", LocalDate.now(), "Accounting", "Head of Accounting", manager.orElse(null));

                    String username = "amartin";
                    String password = passwordEncoder.encode("password");
                    User user = new User(username, password, angelaAccountant);

                    // set user to employee and employee to user
                    user.setEmployee(angelaAccountant);
                    angelaAccountant.setUser(user);


                    // save employee (and thus user because of CascadeType.ALL)
                    accountantRepository.save(angelaAccountant);
                }

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