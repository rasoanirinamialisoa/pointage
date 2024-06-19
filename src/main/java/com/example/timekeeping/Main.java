package com.example.timekeeping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class Main {
    private static final Logger logger = LogManager.getLogger(Main.class);
    public static void main(String[] args) {
        WorkCalendar workCalendar = new WorkCalendar();
        workCalendar.printWorkCalendarForJune2024();
        logger.info("Work calendar for June 2024 printed successfully.");
    }
}
