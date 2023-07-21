package com.buffettinc.hrms.controller.user;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.user.User;
import com.buffettinc.hrms.repository.employee.EmployeeRepository;
import com.buffettinc.hrms.repository.user.UserRepository;
import com.buffettinc.hrms.service.employee.EmployeeService;
import com.buffettinc.hrms.service.user.CustomUserDetails;
import com.buffettinc.hrms.service.user.CustomUserDetailsService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private CustomUserDetailsService userDetailsService;

    @Autowired
    private EmployeeRepository employeeRepository;

    @Autowired
    private EmployeeService employeeService;

    @Autowired
    private BCryptPasswordEncoder bCryptPasswordEncoder;


    @GetMapping("")
    public String viewHomePage() {
        return "index";
    }



    @GetMapping("dashboard")
    public String viewDashboard(@AuthenticationPrincipal CustomUserDetails userDetails, Model model) throws Exception{
        Long employeeID = userDetails.getEmployeeID();
        Employee loggedInEmployee = employeeService.getEmployeeById(employeeID);
        User loggedInUser = userDetails.getUser();
        String loggedInFullName = loggedInEmployee.getFullName();
        String loggedInUsername = loggedInUser.getUsername();

        model.addAttribute("loggedInFullName", loggedInFullName);
        return "dashboard";
    }

    @GetMapping("register_success")
    public String showRegistrationSuccess() {
        return "register_success";
    }

    @GetMapping("/register")
    public String showRegistrationForm(Model model){
        model.addAttribute("user", new User());
        List<Employee> unregisteredEmployees = employeeService.getUnregisteredEmployees();
        model.addAttribute("employees", unregisteredEmployees);
        return "register";
    }

    @PostMapping("/process_register")
    public String processRegister(User user){
        User existingUser = userRepository.findByUsername(user.getUsername());
        if (existingUser != null) {
            // handle the case where a user with the same username already exists
            // you can redirect back to the registration form and show an error message
            return "redirect:/register?error";
        }
        String encodedPassword = bCryptPasswordEncoder.encode(user.getPassword());
        user.setPassword(encodedPassword);
        userRepository.save(user);
        return "register_success";
    }


    @GetMapping("/login")
    public String showLoginPage(){
        return "login";
    }

    @PostMapping("/login")
    public String authenticateUser(@RequestParam("username") String username,
                                   @RequestParam("password") String password,
                                   HttpServletRequest request) {
        try {
            UserDetails userDetails = userDetailsService.loadUserByUsername(username);


            if (bCryptPasswordEncoder.matches(password, userDetails.getPassword())) {
                // Authentication succeeded
                UsernamePasswordAuthenticationToken token = new UsernamePasswordAuthenticationToken(
                        userDetails, null, userDetails.getAuthorities());

                // manually set the authentication
                SecurityContextHolder.getContext().setAuthentication(token);

                // set session
                HttpSession session = request.getSession(true);
                session.setAttribute("SPRING_SECURITY_CONTEXT", SecurityContextHolder.getContext());

                return "redirect:/dashboard";
            }

            // Authentication failed
            return "redirect:/login?error";
        } catch (Exception e) {
            // Log the exception message
            System.out.println("Exception in authenticateUser: " + e.getMessage());
            e.printStackTrace();
            return "redirect:/login?error";
        }
    }





}
