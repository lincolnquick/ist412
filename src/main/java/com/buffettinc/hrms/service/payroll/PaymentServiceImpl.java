package com.buffettinc.hrms.service.payroll;

import com.buffettinc.hrms.model.payroll.Payment;
import com.buffettinc.hrms.repository.payroll.PaymentRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class is the implementation of the PaymentService interface for handling payments at Buffett Inc.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class PaymentServiceImpl implements PaymentService {

    @Autowired
    private PaymentRepository paymentRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public Payment saveOrUpdatePayment(Payment payment) {
        return paymentRepository.save(payment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Optional<Payment> getPaymentById(Long paymentID) {
        return paymentRepository.findById(paymentID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Payment> getAllPayments() {
        return paymentRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePayment(Long paymentID) {
        paymentRepository.deleteById(paymentID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Payment> getPaymentsForEmployee(Long employeeID) {
        return paymentRepository.findByEmployeeID(employeeID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Payment initiateDirectDepositTransfer(Long paymentID) {
        Payment payment = paymentRepository.findById(paymentID)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment ID: " + paymentID));

        payment.directDepositTransfer();
        return paymentRepository.save(payment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Payment acknowledgeDirectDeposit(Long paymentID) {
        Payment payment = paymentRepository.findById(paymentID)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment ID: " + paymentID));

        payment.directDepositAcknowledge();
        return paymentRepository.save(payment);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Payment initiateCheckWriting(Long paymentID) {
        Payment payment = paymentRepository.findById(paymentID)
                .orElseThrow(() -> new IllegalArgumentException("Invalid payment ID: " + paymentID));

        payment.writeCheck();
        return paymentRepository.save(payment);
    }
}
