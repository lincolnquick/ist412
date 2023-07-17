package com.buffettinc.hrms.controller.employee;

import com.buffettinc.hrms.model.employee.Accountant;
import com.buffettinc.hrms.service.employee.AccountantService;
import org.springframework.data.domain.Page;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

/**
 * Controller for managing {@link Accountant} entities.
 * Each method in the controller corresponds to an operation that can be performed on an Accountant object.
 * Each method also corresponds to a view which is displayed as a result of the operation.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/accountants")
public class AccountantController {

    private final AccountantService accountantService;

    public AccountantController(AccountantService accountantService) {
        this.accountantService = accountantService;
    }

    @GetMapping
    public String viewAccountantPage(Model model) {
        // code to get data and add to model
        return "accountants"; // returns the accountants.html template
    }

    // other controller methods for creating, updating, deleting, and paginating Accountants would follow,
    // each with its own route and template
}
