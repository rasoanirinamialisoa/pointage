package com.example.timekeeping;

public class WorkHours {
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
}
