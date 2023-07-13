package com.buffettinc.hrms.service.pto;

import com.buffettinc.hrms.model.pto.PTOCalendar;
import com.buffettinc.hrms.model.pto.PTORequest;
import com.buffettinc.hrms.repository.pto.PTOCalendarRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * This class implements the {@link PTOCalendarService} interface, providing concrete
 * implementations for each method.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class PTOCalendarServiceImpl implements PTOCalendarService {
    @Autowired
    private PTOCalendarRepository ptoCalendarRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public PTOCalendar saveOrUpdatePTOCalendar(PTOCalendar ptoCalendar) {
        return ptoCalendarRepository.save(ptoCalendar);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public PTOCalendar getPTOCalendarById(UUID calendarID) {
        return ptoCalendarRepository.findById(calendarID).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<PTOCalendar> getAllPTOCalendars() {
        return ptoCalendarRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deletePTOCalendar(UUID calendarID) {
        ptoCalendarRepository.deleteById(calendarID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void addPTORequest(UUID calendarID, UUID employeeID, PTORequest request) {
        PTOCalendar ptoCalendar = getPTOCalendarById(calendarID);
        if (ptoCalendar != null) {
            ptoCalendar.addPTORequest(employeeID, request);
            saveOrUpdatePTOCalendar(ptoCalendar);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void removePTORequest(UUID calendarID, UUID employeeID, PTORequest request) {
        PTOCalendar ptoCalendar = getPTOCalendarById(calendarID);
        if (ptoCalendar != null) {
            ptoCalendar.removePTORequest(employeeID, request);
            saveOrUpdatePTOCalendar(ptoCalendar);
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void updatePTORequest(UUID calendarID, UUID employeeID, PTORequest previousRequest, PTORequest newRequest) {
        PTOCalendar ptoCalendar = getPTOCalendarById(calendarID);
        if (ptoCalendar != null) {
            ptoCalendar.updatePTORequest(employeeID, previousRequest, newRequest);
            saveOrUpdatePTOCalendar(ptoCalendar);
        }
    }
}
