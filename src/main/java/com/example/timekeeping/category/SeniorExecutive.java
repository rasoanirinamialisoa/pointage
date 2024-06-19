package com.example.timekeeping.category;

public class SeniorExecutive extends Category {

    public SeniorExecutive() {
        super("Senior Executive", 40, 150000);
    }
    @Override
    public double calculateIndemnity() {
        return getWeeklySalary() * 0.1;
    }
}
