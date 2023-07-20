package com.buffettinc.hrms.service.pto;

import com.buffettinc.hrms.model.pto.PTOBalance;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * This class provides the implementation for the services defined in PTOBalanceService interface.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class PTOBalanceServiceImpl implements PTOBalanceService {

    @Override
    public PTOBalance saveOrUpdatePTOBalance(PTOBalance ptobalance) {
        // Insert or update the ptobalance in the database
        // return the updated ptobalance
        return null;
    }

    @Override
    public PTOBalance getPTOBalanceById(Long employeeID) {
        // Fetch the ptobalance with the given employeeID from the database
        // return the fetched ptobalance
        return null;
    }

    @Override
    public List<PTOBalance> getAllPTOBalances() {
        // Fetch all ptobalances from the database
        // return the list of ptobalances
        return null;
    }

    @Override
    public void deletePTOBalance(Long employeeID) {
        // Delete the ptobalance with the given employeeID from the database
    }

    @Override
    public void useVacationTime(Long employeeID, float hours) {
        PTOBalance ptobalance = getPTOBalanceById(employeeID);
        if (ptobalance != null) {
            ptobalance.useVacationTime(hours);
            saveOrUpdatePTOBalance(ptobalance);
        }
    }

    @Override
    public void usePersonalTime(Long employeeID, float hours) {
        PTOBalance ptobalance = getPTOBalanceById(employeeID);
        if (ptobalance != null) {
            ptobalance.usePersonalTime(hours);
            saveOrUpdatePTOBalance(ptobalance);
        }
    }

    @Override
    public void useSickTime(Long employeeID, float hours) {
        PTOBalance ptobalance = getPTOBalanceById(employeeID);
        if (ptobalance != null) {
            ptobalance.useSickTime(hours);
            saveOrUpdatePTOBalance(ptobalance);
        }
    }

    @Override
    public void accrueVacationTime(Long employeeID, float hours) {
        PTOBalance ptobalance = getPTOBalanceById(employeeID);
        if (ptobalance != null) {
            ptobalance.accrueVacationTime(hours);
            saveOrUpdatePTOBalance(ptobalance);
        }
    }

    @Override
    public void accruePersonalTime(Long employeeID, float hours) {
        PTOBalance ptobalance = getPTOBalanceById(employeeID);
        if (ptobalance != null) {
            ptobalance.accruePersonalTime(hours);
            saveOrUpdatePTOBalance(ptobalance);
        }
    }

    @Override
    public void accrueSickTime(Long employeeID, float hours) {
        PTOBalance ptobalance = getPTOBalanceById(employeeID);
        if (ptobalance != null) {
            ptobalance.accrueSickTime(hours);
            saveOrUpdatePTOBalance(ptobalance);
        }
    }
}
