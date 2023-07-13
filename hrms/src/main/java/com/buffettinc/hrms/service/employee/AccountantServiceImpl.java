package com.buffettinc.hrms.service.employee;

import com.buffettinc.hrms.model.employee.Accountant;
import com.buffettinc.hrms.repository.employee.AccountantRepository;
import com.buffettinc.hrms.service.employee.AccountantService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * Implementation for {@link AccountantService} interface, containing methods for performing CRUD operations on
 * Accountant objects.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class AccountantServiceImpl implements AccountantService {

    private final AccountantRepository accountantRepository;

    public AccountantServiceImpl(AccountantRepository accountantRepository) {
        this.accountantRepository = accountantRepository;
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Accountant saveAccountant(Accountant accountant) {
        return this.accountantRepository.save(accountant);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<Accountant> getAllAccountants() {
        return this.accountantRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Accountant getAccountantById(UUID id) {
        return this.accountantRepository.findById(id).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Accountant updateAccountant(Accountant accountant) {
        return this.accountantRepository.save(accountant);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteAccountant(UUID id) {
        this.accountantRepository.deleteById(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Page<Accountant> findPaginated(int pageNo, int pageSize, String sortField, String sortDirection) {
        Sort sort = sortDirection.equalsIgnoreCase(Sort.Direction.ASC.name()) ? Sort.by(sortField).ascending() :
                Sort.by(sortField).descending();

        PageRequest pageRequest = PageRequest.of(pageNo - 1, pageSize, sort);
        return this.accountantRepository.findAll(pageRequest);
    }
}
