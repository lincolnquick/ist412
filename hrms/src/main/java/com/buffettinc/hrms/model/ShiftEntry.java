package com.buffettinc.hrms.model;

import java.time.*;
import jakarta.persistence.*;

import java.io.Serializable;
import java.util.UUID;

/**
 * This class represents a single shift of hours worked for an Employee of Buffett Inc to be saved in a Timesheet.
 * Each shiftEntry object consists of a start time and an end time, as well as a method
 * to calculate the hours of the shift.
 */
@Entity
@Table(name = "shiftEntry")
public class ShiftEntry implements Serializable{
    @Id
    @GeneratedValue (strategy = GenerationType.UUID)
    private UUID shiftID;
    @Column(name = "start")
    private LocalDateTime start;
    @Column (name = "end")
    private LocalDateTime end;

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

    public long getDurationInHours(){
        return Duration.between(start, end).toHours();
    }
}
