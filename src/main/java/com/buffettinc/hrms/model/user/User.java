package com.buffettinc.hrms.model.user;



import com.buffettinc.hrms.model.employee.Accountant;
import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.HRStaff;
import com.buffettinc.hrms.model.employee.Manager;
import jakarta.persistence.*;

/**
 * This class represents a User of the Buffett Inc. HRMS.
 * Each User has an ID and a username and password.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name = "users")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(nullable = false, unique = true)
    private String username;

    @Column(nullable = false)
    private String password;

    @OneToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "employeeid")
    private Employee employee;

    @Enumerated(EnumType.STRING)
    private UserRole role;

    public User() {
        this.username = null;
        this.password = null;
        this.employee = new Employee();
    }

    public User(String username, String password, Employee employee) {
        this.username = username;
        this.password = password;
        if (employee != null){
            this.employee = employee;
        } else {
            this.employee = new Employee();
        }

    }

    public Employee getEmployee() {
        return employee;
    }

    public void setEmployee(Employee employee) {
        this.employee = employee;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    /**
     * Determines the role based on the type of Employee
     * @param employee
     * @return UserRole
     */
    private UserRole determineRole(Employee employee){
        if (employee instanceof Manager){
            return UserRole.MANAGER;
        } else if (employee instanceof HRStaff) {
            return UserRole.HRSTAFF;
        } else if (employee instanceof Accountant) {
            return UserRole.ACCOUNTANT;
        } else {
            return UserRole.EMPLOYEE;
        }
    }
}

enum UserRole {
    EMPLOYEE,
    MANAGER,
    HRSTAFF,
    ACCOUNTANT
}
