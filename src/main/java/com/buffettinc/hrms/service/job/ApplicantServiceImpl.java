package com.buffettinc.hrms.service.job;

import com.buffettinc.hrms.model.job.Applicant;
import com.buffettinc.hrms.model.job.JobApplication;
import com.buffettinc.hrms.repository.job.ApplicantRepository;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.net.URL;
import java.util.List;

/**
 * Implementation of the {@link ApplicantService} interface.
 * Provides methods to manage job {@link Applicant}s.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
@Transactional
public class ApplicantServiceImpl implements ApplicantService {

    private final ApplicantRepository applicantRepository;

    public ApplicantServiceImpl(ApplicantRepository applicantRepository) {
        this.applicantRepository = applicantRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Applicant createApplicant(String firstName, String lastName, String streetAddress, String city, String state,
                                     String zip, String phone, String email, Long jobID, URL resume) {
        Applicant applicant = new Applicant(firstName, lastName, streetAddress, city, state, zip, phone, email,
                JobApplication.JobApplicationStatus.SUBMITTED, jobID, resume);
        return applicantRepository.save(applicant);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Applicant getApplicantByID(Long applicantID) {
        return applicantRepository.findById(applicantID).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Applicant> getAllApplicants() {
        return applicantRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Applicant updateApplicant(Long applicantID, String firstName, String lastName, String streetAddress, String city,
                                     String state, String zip, String phone, String email, Long jobID, URL resume) {
        Applicant existingApplicant = applicantRepository.findById(applicantID).orElse(null);
        if (existingApplicant != null) {
            existingApplicant.setFirstName(firstName);
            existingApplicant.setLastName(lastName);
            existingApplicant.setStreetAddress(streetAddress);
            existingApplicant.setCity(city);
            existingApplicant.setState(state);
            existingApplicant.setZip(zip);
            existingApplicant.setPhone(phone);
            existingApplicant.setEmail(email);
            existingApplicant.setJobID(jobID);
            existingApplicant.setResume(resume);
            return applicantRepository.save(existingApplicant);
        }
        return null;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean deleteApplicant(Long applicantID) {
        Applicant existingApplicant = applicantRepository.findById(applicantID).orElse(null);
        if (existingApplicant != null) {
            applicantRepository.delete(existingApplicant);
            return true;
        }
        return false;
    }
}
