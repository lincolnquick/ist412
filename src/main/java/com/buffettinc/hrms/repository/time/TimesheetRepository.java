package com.buffettinc.hrms.repository.time;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.payroll.Payroll;
import com.buffettinc.hrms.model.time.Timesheet;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

/**
 * This is the repository interface for the {@link Timesheet} entity.
 * It extends {@link JpaRepository} to provide methods for CRUD operations.
 * Additional query methods can be defined here as needed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface TimesheetRepository extends JpaRepository<Timesheet, Long> {
    // custom methods if necessary
    // TimesheetRepository
    // Find all timesheets for a specific payroll
    List<Timesheet> findByPayroll(Payroll payroll);

    // Find a timesheet by payroll and specific period start and end dates
    Timesheet findByPayrollAndPeriodStartAndPeriodEnd(Payroll payroll, LocalDate periodStart, LocalDate periodEnd);

}
