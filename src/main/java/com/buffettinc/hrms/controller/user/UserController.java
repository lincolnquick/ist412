package com.buffettinc.hrms.controller.user;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.user.User;
import com.buffettinc.hrms.repository.employee.EmployeeRepository;
import com.buffettinc.hrms.repository.user.UserRepository;
import com.buffettinc.hrms.service.communication.MessageService;
import com.buffettinc.hrms.service.communication.NotificationService;
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
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.NoSuchElementException;
import java.util.Optional;

/**
 * This class represents the controller for the User's view, including the Dashboard or main page of the HRMS.
 *
 * @author IST 412 Group 5
 * @since 2023-07-21
 */
@Controller
@RequestMapping("")
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
    private MessageService messageService;

    @Autowired
    private NotificationService notificationService;

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
        int unreadMessageCount = messageService.countByIsReadFalseAndRecipient(loggedInEmployee);

        model.addAttribute("loggedInFullName", loggedInFullName);
        model.addAttribute("user", loggedInUser);
        model.addAttribute("unreadMessageCount", unreadMessageCount);
        model.addAttribute("page", "home");
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
        try {
            userDetailsService.register(user, user.getEmployee().getEmployeeID());
        } catch (Exception e) {
            System.out.println("Error processing registration: " + e.getMessage());
            e.printStackTrace();
            return "redirect:/register?error";
        }
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
