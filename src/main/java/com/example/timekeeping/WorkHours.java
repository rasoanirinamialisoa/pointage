package com.example.timekeeping;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

public class WorkHours {
    private static final Logger logger = LogManager.getLogger(WorkHours.class);
    private int normalHours;
    private int overtimeHours;
    private int premiumHours;

    public WorkHours(int normalHours, int overtimeHours, int premiumHours) {
        this.normalHours = normalHours;
        this.overtimeHours = overtimeHours;
        this.premiumHours = premiumHours;
    }

    public int getNormalHours() {
        return normalHours;
    }

    public void setNormalHours(int normalHours) {
        this.normalHours = normalHours;
    }

    public int getOvertimeHours() {
        return overtimeHours;
    }

    public void setOvertimeHours(int overtimeHours) {
        this.overtimeHours = overtimeHours;
    }

    public int getPremiumHours() {
        return premiumHours;
    }

    public void setPremiumHours(int premiumHours) {
        this.premiumHours = premiumHours;
    }

    public static void main(String[] args) {
        double hourlyRateRakoto = 10.0;
        double hourlyRateRabe = 12.0;

        int workingDaysRakoto = 22;
        int workingDaysRabe = 22;

        int hoursWorkedRakoto = workingDaysRakoto * 8;
        int hoursWorkedRabe = workingDaysRabe * 8;

        logger.info("Hours worked by Rakoto in June: " + hoursWorkedRakoto);
        logger.info("Hours worked by Rabe in June: " + hoursWorkedRabe);

        WorkHours rakotoWorkHours = new WorkHours(hoursWorkedRakoto, 0, 0);
        WorkHours rabeWorkHours = new WorkHours(hoursWorkedRabe, 0, 0);

        logger.info("Rakoto - Normal hours: " + rakotoWorkHours.getNormalHours());
        logger.info("Rabe - Normal hours: " + rabeWorkHours.getNormalHours());
    }
}
