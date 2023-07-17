package com.buffettinc.hrms.service.time;

import com.buffettinc.hrms.model.time.ShiftEntry;
import com.buffettinc.hrms.repository.time.ShiftEntryRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.UUID;

/**
 * This class implements the {@link ShiftEntryService} interface, providing concrete
 * implementations for each method.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Service
public class ShiftEntryServiceImpl implements ShiftEntryService {
    @Autowired
    private ShiftEntryRepository shiftEntryRepository;

    /**
     * {@inheritDoc}
     */
    @Override
    public ShiftEntry saveOrUpdateShiftEntry(ShiftEntry shiftEntry) {
        return shiftEntryRepository.save(shiftEntry);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public ShiftEntry getShiftEntryById(UUID shiftID) {
        return shiftEntryRepository.findById(shiftID).orElse(null);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public List<ShiftEntry> getAllShiftEntries() {
        return shiftEntryRepository.findAll();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public void deleteShiftEntry(UUID shiftID) {
        shiftEntryRepository.deleteById(shiftID);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public long getShiftDurationInHours(UUID shiftID) {
        ShiftEntry shiftEntry = getShiftEntryById(shiftID);
        return shiftEntry != null ? shiftEntry.getDurationInHours() : 0;
    }
}
