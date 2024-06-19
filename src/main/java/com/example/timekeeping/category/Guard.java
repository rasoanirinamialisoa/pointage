package com.example.timekeeping.category;

public class Guard extends Category {
    public Guard() {
        super("Guard", 56, 110000);
    }
    @Override
    public double calculateIndemnity() {
        return getWeeklySalary() * 0.07;
    }
}
