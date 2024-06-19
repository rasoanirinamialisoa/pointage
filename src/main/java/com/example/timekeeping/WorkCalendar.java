package com.example.timekeeping;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

public class WorkCalendar {
    private Set<LocalDate> holidays;

    public WorkCalendar() {
        this.holidays = new HashSet<>();
        this.holidays.add(LocalDate.of(2024, 6, 17));
        this.holidays.add(LocalDate.of(2024, 6, 25));
        this.holidays.add(LocalDate.of(2024, 6, 26));
    }

    public boolean isHoliday(LocalDate date) {
        return holidays.contains(date);
    }

}
