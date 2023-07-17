package com.buffettinc.hrms.service.payroll;

import com.buffettinc.hrms.model.payroll.Payment;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This interface represents the service contract for handling payments at Buffett Inc.
 * It declares all the necessary CRUD operations related to Payment along with some additional methods.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface PaymentService {

    /**
     * Saves a new payment or updates an existing one.
     *
     * @param payment the payment to save or update.
     * @return the saved or updated payment.
     */
    Payment saveOrUpdatePayment(Payment payment);

    /**
     * Fetches a payment by its id.
     *
     * @param paymentID the id of the payment to fetch.
     * @return an Optional of the payment if found, or an empty Optional if not.
     */
    Optional<Payment> getPaymentById(UUID paymentID);

    /**
     * Fetches all payments.
     *
     * @return a list of all payments.
     */
    List<Payment> getAllPayments();

    /**
     * Deletes a payment by its id.
     *
     * @param paymentID the id of the payment to delete.
     */
    void deletePayment(UUID paymentID);

    /**
     * Fetches all payments for a particular employee.
     *
     * @param employeeID the id of the employee.
     * @return a list of payments for the employee.
     */
    List<Payment> getPaymentsForEmployee(UUID employeeID);

    /**
     * Initiates a direct deposit transfer for the given payment.
     *
     * @param paymentID the id of the payment.
     * @return an updated payment with the direct deposit transfer initiated.
     */
    Payment initiateDirectDepositTransfer(UUID paymentID);

    /**
     * Acknowledges a direct deposit for the given payment.
     *
     * @param paymentID the id of the payment.
     * @return an updated payment with the direct deposit acknowledged.
     */
    Payment acknowledgeDirectDeposit(UUID paymentID);

    /**
     * Initiates a check writing for the given payment.
     *
     * @param paymentID the id of the payment.
     * @return an updated payment with the check writing initiated.
     */
    Payment initiateCheckWriting(UUID paymentID);
}
