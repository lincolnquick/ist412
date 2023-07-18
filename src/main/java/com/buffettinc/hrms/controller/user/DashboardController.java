package com.buffettinc.hrms.controller.user;

import com.buffettinc.hrms.model.user.User;
import com.buffettinc.hrms.model.user.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.security.Principal;

@Controller
public class DashboardController {

    @Autowired
    private UserDetailsService userDetailsService;

    @GetMapping("/")
    public String getDashboard(Model model, Principal principal) {
        UserDetails userDetails = userDetailsService.loadUserByUsername(principal.getName());
        User user = ((UserPrincipal)userDetails).getUser();

        // Get user's name and role
        String username = user.getUsername();
        String role = user.getRole();

        // Add attributes to the model
        model.addAttribute("username", username);
        model.addAttribute("role", role);

        return "index"; // name of your Thymeleaf template for the dashboard
    }
}
