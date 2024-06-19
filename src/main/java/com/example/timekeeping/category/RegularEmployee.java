package com.example.timekeeping.category;

public class RegularEmployee extends Category {
    public RegularEmployee() {
        super("Regular Employee", 40, 100000);
    }
    @Override
    public double calculateIndemnity() {
        return getWeeklySalary() * 0.05;
    }
}
