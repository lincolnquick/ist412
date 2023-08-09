package com.buffettinc.hrms.service.pto;

import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.model.pto.PTOStatus;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * This interface defines the services related to PTORequest management in Buffett Inc.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface PTORequestService {



    /**
     * Creates or updates a PTORequest.
     *
     * @param ptoRequest the PTORequest to be created or updated.
     * @return the created or updated PTORequest.
     */
    PTORequest saveOrUpdatePTORequest(PTORequest ptoRequest);

    /**
     * Fetches a PTORequest by its id.
     *
     * @param requestID the id of the PTORequest to be fetched.
     * @return the fetched PTORequest.
     */
    PTORequest getPTORequestById(Long requestID);

    /**
     * Fetches all PTORequests.
     *
     * @return a list of all PTORequests.
     */
    List<PTORequest> getAllPTORequests();

    /**
     * Deletes a PTORequest.
     *
     * @param requestID the id of the PTORequest to be deleted.
     */
    void deletePTORequest(Long requestID);

    /**
     * Approves a PTORequest.
     *
     * @param requestID the id of the PTORequest to be approved.
     */
    void approvePTORequest(Long requestID);

    /**
     * Denies a PTORequest.
     *
     * @param requestID the id of the PTORequest to be denied.
     */
    void denyPTORequest(Long requestID);

    /**
     * Fetches all PTORequests between two dates.
     *
     * @param startDate the start date.
     * @param endDate the end date.
     * @return a list of all PTORequests between the two dates.
     */
    List<PTORequest> getAllPTORequestsBetweenDates(LocalDate startDate, LocalDate endDate);

    /**
     * Fetches all PTORequests by status.
     *
     * @param status the status of the PTORequests to be fetched.
     * @return a list of all PTORequests with the specified status.
     */
    List<PTORequest> getAllPTORequestsByStatus(PTOStatus status);

    List<PTORequest> getPTORequestByEmployee(Long empID);
}
