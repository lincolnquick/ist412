package com.buffettinc.hrms.service.employee;

import com.buffettinc.hrms.model.employee.Accountant;
import org.springframework.data.domain.Page;

import java.util.List;
import java.util.UUID;

/**
 * Interface for {@link Accountant} service, containing methods for performing CRUD operations on Accountant objects.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface AccountantService {

    Accountant saveAccountant(Accountant accountant);
    List<Accountant> getAllAccountants();
    Accountant getAccountantById(Long id);
    Accountant updateAccountant(Accountant accountant);
    void deleteAccountant(Long id);
    Page<Accountant> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection);
}
