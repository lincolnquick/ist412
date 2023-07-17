package com.buffettinc.hrms.controller.payroll;

import com.buffettinc.hrms.model.payroll.Payment;
import com.buffettinc.hrms.service.payroll.PaymentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

/**
 * Controller for managing {@link Payment}s in Buffett Inc.
 * Provides endpoints to create, retrieve, update, and delete payments.
 * Also includes endpoints to initiate direct deposit transfer, acknowledge direct deposit, and initiate check writing.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Controller
@RequestMapping("/payments")
public class PaymentController {

    @Autowired
    private PaymentService paymentService;

    @PostMapping
    public String saveOrUpdatePayment(Payment payment) {
        paymentService.saveOrUpdatePayment(payment);
        return "paymentSavedOrUpdated";
    }

    @GetMapping("/{id}")
    public String getPaymentByID(@PathVariable("id") UUID paymentID) {
        paymentService.getPaymentById(paymentID);
        return "viewPayment";
    }

    @GetMapping
    public String getAllPayments() {
        paymentService.getAllPayments();
        return "viewAllPayments";
    }

    @DeleteMapping("/{id}")
    public String deletePayment(@PathVariable("id") UUID paymentID) {
        paymentService.deletePayment(paymentID);
        return "paymentDeleted";
    }

    @GetMapping("/employee/{employeeID}")
    public String getPaymentsForEmployee(@PathVariable("employeeID") UUID employeeID) {
        paymentService.getPaymentsForEmployee(employeeID);
        return "viewPaymentsForEmployee";
    }

    @PostMapping("/directDepositTransfer/{id}")
    public String initiateDirectDepositTransfer(@PathVariable("id") UUID paymentID) {
        paymentService.initiateDirectDepositTransfer(paymentID);
        return "directDepositTransferInitiated";
    }

    @PostMapping("/acknowledgeDirectDeposit/{id}")
    public String acknowledgeDirectDeposit(@PathVariable("id") UUID paymentID) {
        paymentService.acknowledgeDirectDeposit(paymentID);
        return "directDepositAcknowledged";
    }

    @PostMapping("/initiateCheckWriting/{id}")
    public String initiateCheckWriting(@PathVariable("id") UUID paymentID) {
        paymentService.initiateCheckWriting(paymentID);
        return "checkWritingInitiated";
    }
}
