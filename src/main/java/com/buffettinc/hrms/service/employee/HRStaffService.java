package com.buffettinc.hrms.service.employee;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.HRStaff;
import com.buffettinc.hrms.model.job.Applicant;
import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.model.job.JobOpening;
import com.buffettinc.hrms.model.training.TrainingModule;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Service interface for managing {@link HRStaff} employees.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface HRStaffService {

    HRStaff createHRStaff(HRStaff hrStaff);

    HRStaff updateHRStaff(HRStaff hrStaff);

    /**
     * Gets all HRStaff employees
     * @return List of all HRStaff employees
     */
    List<HRStaff> getAllHRStaff();

}
