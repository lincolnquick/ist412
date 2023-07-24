package com.buffettinc.hrms.service.user;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.user.User;
import com.buffettinc.hrms.repository.employee.EmployeeRepository;
import com.buffettinc.hrms.repository.user.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.NoSuchElementException;
import java.util.Optional;

@Service
public class CustomUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private EmployeeRepository employeeRepository;
    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        User user = userRepository.findByUsername(username);
        if (user == null){
            throw new UsernameNotFoundException("User not found with username: " + username + ".");
        }
        return new CustomUserDetails(user);
    }

    @Transactional
    public User register(User user, Long employeeID) {
        User existingUser = userRepository.findByUsername(user.getUsername());

        if (existingUser != null) {
            throw new RuntimeException("User already exists: " + existingUser.getUsername());
        }
        Optional<Employee> retrievedEmployee = employeeRepository.findByEmployeeID(employeeID);

        if (retrievedEmployee.isPresent()) {
            user.setEmployee(retrievedEmployee.get());
        } else {
            throw new NoSuchElementException("Employee Not Found with ID: " + employeeID);
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        User newUser = new User(user.getUsername(), encodedPassword, retrievedEmployee.get());
        return userRepository.save(newUser);
    }
}
