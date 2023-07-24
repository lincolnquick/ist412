package com.buffettinc.hrms.controller.pto;

import com.buffettinc.hrms.model.pto.PTOBalance;
import com.buffettinc.hrms.service.pto.PTOBalanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.ui.Model;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

/**
 * This class handles all incoming HTTP requests related to an Employee's PTO Balance.
 * It uses {@link PTOBalanceService} to perform the operations.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/ptobalance")
public class PTOBalanceController {

    private final PTOBalanceService ptobalanceService;

    @Autowired
    public PTOBalanceController(PTOBalanceService ptobalanceService) {
        this.ptobalanceService = ptobalanceService;
    }

    /**
     * Displays all PTOBalances.
     *
     * @param model The model to which attributes can be added.
     * @return The name of the Thymeleaf template to be displayed.
     */
    @GetMapping("/")
    public String showAllPTOBalances(Model model) {
        model.addAttribute("ptobalances", ptobalanceService.getAllPTOBalances());
        return "allPtobalances";
    }

    /**
     * Displays a form to create a new PTOBalance.
     *
     * @param model The model to which attributes can be added.
     * @return The name of the Thymeleaf template to be displayed.
     */
    @GetMapping("/new")
    public String createPTOBalanceForm(Model model) {
        model.addAttribute("ptobalance", new PTOBalance());
        return "createPtobalance";
    }

    /**
     * Saves a new PTOBalance.
     *
     * @param ptobalance The PTOBalance to be saved.
     * @return A redirect instruction to another endpoint.
     */
    @PostMapping("/save")
    public String savePTOBalance(@ModelAttribute PTOBalance ptobalance) {
        ptobalanceService.saveOrUpdatePTOBalance(ptobalance);
        return "redirect:/ptobalance/";
    }

    /**
     * Displays a form to edit an existing PTOBalance.
     *
     * @param id The id of the PTOBalance to be edited.
     * @param model The model to which attributes can be added.
     * @return The name of the Thymeleaf template to be displayed.
     */
    @GetMapping("/edit/{id}")
    public String editPTOBalanceForm(@PathVariable("id") Long id, Model model) {
        model.addAttribute("ptobalance", ptobalanceService.getPTOBalanceById(id));
        return "editPtobalance";
    }

    /**
     * Deletes a PTOBalance.
     *
     * @param id The id of the PTOBalance to be deleted.
     * @return A redirect instruction to another endpoint.
     */
    @GetMapping("/delete/{id}")
    public String deletePTOBalance(@PathVariable("id") Long id) {
        ptobalanceService.deletePTOBalance(id);
        return "redirect:/ptobalance/";
    }

    /**
     * PTO Landing Page
     *
     * @return Sting of Thymeleaf html page to display
     */
    @GetMapping("/pto")
    public String ptoLandingPage(Model model){

        model.addAttribute("localDate", LocalDate.now());
        model.addAttribute("startTime", LocalDateTime.now());
        model.addAttribute("endTime", LocalDateTime.now());
        return "pto/pto";
    }

}
