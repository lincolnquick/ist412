package com.buffettinc.hrms.service.time;

import com.buffettinc.hrms.model.time.ShiftEntry;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

/**
 * This interface provides a contract for the ShiftEntryService. It includes CRUD methods as well as
 * a method to calculate the duration of a shift in hours.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
public interface ShiftEntryService {

    /**
     * Saves or updates a shift entry.
     *
     * @param shiftEntry The shift entry to be saved or updated.
     * @return The saved or updated shift entry.
     */
    ShiftEntry saveOrUpdateShiftEntry(ShiftEntry shiftEntry);

    /**
     * Gets a shift entry by ID.
     *
     * @param shiftID The ID of the shift entry.
     * @return The shift entry.
     */
    ShiftEntry getShiftEntryById(UUID shiftID);

    /**
     * Gets all shift entries.
     *
     * @return A list of all shift entries.
     */
    List<ShiftEntry> getAllShiftEntries();

    /**
     * Deletes a shift entry.
     *
     * @param shiftID The ID of the shift entry to delete.
     */
    void deleteShiftEntry(UUID shiftID);

    /**
     * Gets the duration of a shift in hours.
     *
     * @param shiftID The ID of the shift entry.
     * @return The duration of the shift in hours.
     */
    long getShiftDurationInHours(UUID shiftID);
}
