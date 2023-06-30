package com.buffettinc.hrms.model;

import java.time.*;

public class ShiftEntry {
    private LocalDateTime start;
    private LocalDateTime end;

    public ShiftEntry(LocalDateTime start, LocalDateTime end) {
        this.start = start;
        this.end = end;
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
