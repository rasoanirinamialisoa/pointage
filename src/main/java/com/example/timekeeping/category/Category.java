package com.example.timekeeping.category;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public abstract class Category {
    private String name;
    private int normalHoursPerWeek;
    private double weeklySalary;

    public Category(String name, int normalHoursPerWeek, double weeklySalary) {
        this.name = name;
        this.normalHoursPerWeek = normalHoursPerWeek;
        this.weeklySalary = weeklySalary;
    }

    public abstract double calculateIndemnity();

    public double getHourlyRate() {
        return weeklySalary / normalHoursPerWeek;
    }
}
