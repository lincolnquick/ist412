package com.buffettinc.hrms.repository.time;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.payroll.Payroll;
import com.buffettinc.hrms.model.time.ShiftEntry;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;
import java.util.UUID;

/**
 * This is the repository interface for the {@link ShiftEntry} entity.
 * It extends {@link JpaRepository} to provide methods for CRUD operations.
 * Additional query methods can be defined here as needed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface ShiftEntryRepository extends JpaRepository<ShiftEntry, Long> {
    // custom methods if necessary
    @Query("SELECT s FROM ShiftEntry s JOIN s.timesheet t WHERE t.payroll = :payroll AND s.end IS NULL")
    List<ShiftEntry> findOpenShiftsForEmployeePayroll(Payroll payroll);

    @Query("SELECT se FROM ShiftEntry se WHERE se.timesheet.payroll = :payroll")
    List<ShiftEntry> findShiftsForEmployeePayroll(Payroll payroll);
    }

