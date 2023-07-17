package com.buffettinc.hrms.service.payroll;

import com.buffettinc.hrms.model.payroll.Payroll;
import com.buffettinc.hrms.model.time.Timesheet;
import com.buffettinc.hrms.repository.payroll.PayrollRepository;

import jakarta.inject.Inject;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This class provides an implementation for the PayrollService interface.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class PayrollServiceImpl implements PayrollService {

    @Inject
    private PayrollRepository payrollRepository;

    /** {@inheritDoc} */
    @Override
    public Payroll saveOrUpdatePayroll(Payroll payroll) {
        return payrollRepository.save(payroll);
    }

    /** {@inheritDoc} */
    @Override
    public Optional<Payroll> getPayrollById(UUID payrollID) {
        return payrollRepository.findById(payrollID);
    }

    /** {@inheritDoc} */
    @Override
    public List<Payroll> getAllPayrolls() {
        return payrollRepository.findAll();
    }

    /** {@inheritDoc} */
    @Override
    public void deletePayroll(UUID payrollID) {
        payrollRepository.deleteById(payrollID);
    }

    /** {@inheritDoc} */
    @Override
    public List<Timesheet> getTimesheetsForPayroll(UUID payrollID) {
        return payrollRepository.findById(payrollID).get().getTimesheetList();
    }

    /** {@inheritDoc} */
    @Override
    public Payroll addTimesheetToPayroll(UUID payrollID, Timesheet timesheet) {
        Payroll payroll = payrollRepository.findById(payrollID).get();
        payroll.getTimesheetList().add(timesheet);
        return payrollRepository.save(payroll);
    }

    /** {@inheritDoc} */
    @Override
    public Payroll approveTimesheet(UUID payrollID, UUID timesheetID) {
        Payroll payroll = payrollRepository.findById(payrollID).get();
        List<Timesheet> timesheets = payroll.getTimesheetList();
        for (Timesheet t : timesheets) {
            if (t.getTimesheetID().equals(timesheetID)) {
                payroll.getApprovedTimesheetList().add(t);
                return payrollRepository.save(payroll);
            }
        }
        return null;
    }
}
