package com.buffettinc.hrms.controller.payroll;

import com.buffettinc.hrms.model.payroll.Payroll;
import com.buffettinc.hrms.service.payroll.PayrollService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * This class represents the controller for handling payroll related operations for Buffett Inc.
 * It includes CRUD operations for payroll as well as functionality to add timesheets to a payroll
 * and approve a timesheet.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/payroll")
public class PayrollController {
    private final PayrollService payrollService;

    @Autowired
    public PayrollController(PayrollService payrollService) {
        this.payrollService = payrollService;
    }

    /**
     * Endpoint to save or update a payroll.
     *
     * @param payroll Payroll object to be saved or updated.
     * @return string of Thymeleaf template's name.
     */
    @PostMapping("/save")
    public String saveOrUpdatePayroll(@RequestBody Payroll payroll) {
        payrollService.saveOrUpdatePayroll(payroll);
        return "redirect:/payrollList";
    }

    /**
     * Endpoint to fetch a payroll by its ID.
     *
     * @param payrollID Long of the Payroll entry.
     * @return string of Thymeleaf template's name.
     */
    @GetMapping("/{payrollID}")
    public String getPayrollById(@PathVariable Long payrollID) {
        payrollService.getPayrollById(payrollID);
        return "redirect:/payrollDetails";
    }

    /**
     * Endpoint to fetch all payrolls.
     *
     * @return string of Thymeleaf template's name.
     */
    @GetMapping("/all")
    public String getAllPayrolls() {
        payrollService.getAllPayrolls();
        return "redirect:/payrollList";
    }

    /**
     * Endpoint to delete a payroll.
     *
     * @param payrollID Long of the Payroll entry to be deleted.
     * @return string of Thymeleaf template's name.
     */
    @DeleteMapping("/{payrollID}")
    public String deletePayroll(@PathVariable Long payrollID) {
        payrollService.deletePayroll(payrollID);
        return "redirect:/payrollList";
    }

    /**
     * Payroll Landing Page
     *
     * @return String of Thymeleaf template's name.
     */
    @GetMapping("/payroll")
    public String payrollLandingPage(Model model){

        model.addAttribute("page", "messages");
        return "payroll/payroll";
    }

    // TODO: Additional methods
}
