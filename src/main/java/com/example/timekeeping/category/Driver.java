package com.example.timekeeping.category;

public class Driver extends Category {
    public Driver() {
        super("Driver", 40, 90000);
    }
    @Override
    public double calculateIndemnity() {
        return getWeeklySalary() * 0.06;
    }
}
