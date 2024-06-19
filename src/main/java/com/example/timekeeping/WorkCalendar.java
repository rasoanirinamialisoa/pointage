package com.example.timekeeping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.HashSet;
import java.util.Set;

@Component
public class WorkCalendar {

    private static final Logger logger = LogManager.getLogger(WorkCalendar.class);

    private Set<LocalDate> joursFeries;

    public WorkCalendar() {
        this.joursFeries = new HashSet<>();
        this.joursFeries.add(LocalDate.of(2024, 6, 17));
        this.joursFeries.add(LocalDate.of(2024, 6, 25));
        this.joursFeries.add(LocalDate.of(2024, 6, 26));
    }

    public void printWorkCalendarForJune2024() {
        LocalDate startDate = LocalDate.of(2024, 6, 1);
        LocalDate endDate = LocalDate.of(2024, 6, 30);

        logger.info("Work Calendar for June 2024:");
        logger.info("----------------------------");

        while (!startDate.isAfter(endDate)) {
            if (startDate.getDayOfWeek().getValue() <= 5) { // Monday to Friday
                logger.info(startDate + ": Working day");
            } else {
                logger.info(startDate + ": Weekend");
            }
            startDate = startDate.plusDays(1);
        }

        for (LocalDate jourFerie : joursFeries) {
            logger.info(jourFerie + ": Holiday");
        }
    }
}
