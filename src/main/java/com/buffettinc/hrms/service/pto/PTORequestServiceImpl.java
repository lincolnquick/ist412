package com.buffettinc.hrms.service.pto;

import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.model.pto.PTOStatus;
import com.buffettinc.hrms.repository.pto.PTORequestRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.List;

/**
 * This class provides the implementation of the {@link PTORequestService} interface.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class PTORequestServiceImpl implements PTORequestService {

    @Autowired
    private PTORequestRepository ptoRequestRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public PTORequest saveOrUpdatePTORequest(PTORequest ptoRequest) {
        return ptoRequestRepository.save(ptoRequest);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PTORequest getPTORequestById(Long requestID) {
        return ptoRequestRepository.findById(requestID).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PTORequest> getAllPTORequests() {
        return ptoRequestRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePTORequest(Long requestID) {
        ptoRequestRepository.deleteById(requestID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void approvePTORequest(Long requestID) {
        PTORequest ptoRequest = getPTORequestById(requestID);
        if (ptoRequest != null) {
            ptoRequest.setStatus(PTOStatus.APPROVED);
            ptoRequestRepository.save(ptoRequest);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void denyPTORequest(Long requestID) {
        PTORequest ptoRequest = getPTORequestById(requestID);
        if (ptoRequest != null) {
            ptoRequest.setStatus(PTOStatus.DENIED);
            ptoRequestRepository.save(ptoRequest);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PTORequest> getAllPTORequestsBetweenDates(LocalDate startDate, LocalDate endDate) {
        return ptoRequestRepository.findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(startDate, endDate);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PTORequest> getAllPTORequestsByStatus(PTOStatus status) {
        return ptoRequestRepository.findAllByStatus(status);
    }

    @Override
    public List<PTORequest> getPTORequestByEmployee(Long employeeID){
        return ptoRequestRepository.getPTORequestByEmployee(employeeID);
    }
}
