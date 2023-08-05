package com.buffettinc.hrms.service.employee;

import com.buffettinc.hrms.model.employee.Employee;
import com.buffettinc.hrms.model.employee.HRStaff;
import com.buffettinc.hrms.model.job.Applicant;
import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.model.job.JobOpening;
import com.buffettinc.hrms.model.training.TrainingModule;
import com.buffettinc.hrms.repository.employee.HRStaffRepository;
import com.buffettinc.hrms.repository.job.ApplicantRepository;
import com.buffettinc.hrms.repository.job.JobApplicationRepository;
import com.buffettinc.hrms.repository.job.JobOpeningRepository;
import com.buffettinc.hrms.repository.training.TrainingModuleRepository;
import org.springframework.stereotype.Service;

import java.net.URL;
import java.time.Duration;
import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * Implementation of the {@link HRStaffService} interface.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class HRStaffServiceImpl implements HRStaffService {

    private final HRStaffRepository hrStaffRepository;
    private final TrainingModuleRepository trainingModuleRepository;
    private final JobOpeningRepository jobOpeningRepository;
    private final ApplicantRepository applicantRepository;
    private final JobApplicationRepository jobApplicationRepository;

    /**
     * {@inheritDoc}
     */
    public HRStaffServiceImpl(HRStaffRepository hrStaffRepository, TrainingModuleRepository trainingModuleRepository,
                              JobOpeningRepository jobOpeningRepository, ApplicantRepository applicantRepository,
                              JobApplicationRepository jobApplicationRepository) {
        this.hrStaffRepository = hrStaffRepository;
        this.trainingModuleRepository = trainingModuleRepository;
        this.jobOpeningRepository = jobOpeningRepository;
        this.applicantRepository = applicantRepository;
        this.jobApplicationRepository = jobApplicationRepository;
    }

    @Override
    public HRStaff createHRStaff(HRStaff hrStaff) {
        return hrStaffRepository.save(hrStaff);

    }

    @Override
    public HRStaff updateHRStaff(HRStaff hrStaff){
        return hrStaffRepository.save(hrStaff);
    }

    @Override
    public List<HRStaff> getAllHRStaff() {
        return this.hrStaffRepository.findAll();
    }

}
