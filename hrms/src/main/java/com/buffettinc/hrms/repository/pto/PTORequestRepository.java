package com.buffettinc.hrms.repository.pto;

import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.model.pto.PTOStatus;
import org.springframework.data.jpa.repository.JpaRepository;

import java.time.LocalDate;
import java.util.List;
import java.util.UUID;

/**
 * This is the repository interface for the {@link PTORequest} entity.
 * It extends {@link JpaRepository} to provide methods for CRUD operations.
 * Additional query methods can be defined here as needed.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface PTORequestRepository extends JpaRepository<PTORequest, UUID> {
    List<PTORequest> findAllByStartDateGreaterThanEqualAndEndDateLessThanEqual(LocalDate startDate, LocalDate endDate);

    List<PTORequest> findAllByStatus(PTOStatus status);
    // custom methods if necessary
}
