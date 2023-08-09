package com.buffettinc.hrms.model.time;

import java.time.*;

import com.buffettinc.hrms.model.employee.Employee;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

/**
 * This class represents a single shift of hours worked for an {@link Employee} of Buffett Inc to be saved
 * in a {@link Timesheet}.
 * Each shiftEntry object consists of a start time and an end time, as well as a method
 * to calculate the hours of the shift.
 *
 * @author IST 412 Group 5
 * @version 1.0
 * @since 2023-07-13
 */
@Entity
@Table(name = "shiftEntry")
public class ShiftEntry implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.AUTO)
    private Long shiftID;
    @Column(name = "start")
    private LocalDateTime start;
    @Column (name = "end")
    private LocalDateTime end;

    @ManyToOne
    @JoinColumn(name = "timesheet_id")
    private Timesheet timesheet;

    public ShiftEntry(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
    }

    public ShiftEntry() {
        this.start = LocalDateTime.MIN;
        this.end = LocalDateTime.MIN;
    }

    public LocalDateTime getStart() {
        return start;
    }

    public void setStart(LocalDateTime start) {
        this.start = start;
    }

    public LocalDateTime getEnd() {
        return end;
    }

    public void setEnd(LocalDateTime end) {
        this.end = end;
    }

    public double getDurationInHours(){
        if (start == null || end == null || start == LocalDateTime.MIN || end == LocalDateTime.MIN){
            return 0.0;
        } else {
            return Duration.between(start, end).toHours();
        }
    }

    public Long getShiftID() {
        return shiftID;
    }

    public void setShiftID(Long shiftID) {
        this.shiftID = shiftID;
    }

    public Timesheet getTimesheet() {
        return timesheet;
    }

    public void setTimesheet(Timesheet timesheet) {
        this.timesheet = timesheet;
    }
}
