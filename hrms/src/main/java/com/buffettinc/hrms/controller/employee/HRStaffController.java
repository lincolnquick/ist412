package com.buffettinc.hrms.controller.employee;

import com.buffettinc.hrms.model.employee.HRStaff;
import com.buffettinc.hrms.service.employee.HRStaffService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing {@link HRStaff} entities.
 * Each method in the controller corresponds to an operation that can be performed on an HRStaff object.
 * Each method also corresponds to a view which is displayed as a result of the operation.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/hrstaff")
public class HRStaffController {

    private final HRStaffService hrStaffService;

    public HRStaffController(HRStaffService hrStaffService) {
        this.hrStaffService = hrStaffService;
    }

    @GetMapping
    public String viewHRStaffPage(Model model) {
        // code to get data and add to model
        return "hrstaff"; // returns the hrstaff.html template
    }

    // other controller methods for creating, updating, deleting, and viewing HRStaff would follow, each with its own route and template
}
