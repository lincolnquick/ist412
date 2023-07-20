package com.buffettinc.hrms.service.training;

import com.buffettinc.hrms.model.training.EmployeeTrainingRecord;
import com.buffettinc.hrms.repository.training.EmployeeTrainingRecordRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * This class implements the {@link EmployeeTrainingRecordService} interface, providing concrete
 * implementations for each method.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class EmployeeTrainingRecordServiceImpl implements EmployeeTrainingRecordService {
    @Autowired
    private EmployeeTrainingRecordRepository employeeTrainingRecordRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeTrainingRecord saveOrUpdateEmployeeTrainingRecord(EmployeeTrainingRecord employeeTrainingRecord) {
        return employeeTrainingRecordRepository.save(employeeTrainingRecord);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public EmployeeTrainingRecord getEmployeeTrainingRecordById(Long recordID) {
        return employeeTrainingRecordRepository.findById(recordID).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<EmployeeTrainingRecord> getAllEmployeeTrainingRecords() {
        return employeeTrainingRecordRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteEmployeeTrainingRecord(Long recordID) {
        employeeTrainingRecordRepository.deleteById(recordID);
    }
}
