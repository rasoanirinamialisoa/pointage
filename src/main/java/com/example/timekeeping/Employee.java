package com.example.timekeeping;

import com.example.timekeeping.category.Category;
import com.example.timekeeping.category.SeniorExecutive;
import lombok.Getter;
import lombok.Setter;
import java.time.LocalDate;

@Getter
@Setter
public class Employee {
    private String firstName;
    private String lastName;
    private String employeeId;
    private LocalDate birthDate;
    private LocalDate hireDate;
    private LocalDate endDate;
    private double grossSalary;
    private double netSalary;
    private Category category;
    private WorkHours workHours;

    public Employee(String firstName, String lastName, String employeeId, LocalDate birthDate,
                    LocalDate hireDate, LocalDate endDate, double grossSalary,
                    Category category, WorkHours workHours) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.employeeId = employeeId;
        this.birthDate = birthDate;
        this.hireDate = hireDate;
        this.endDate = endDate;
        this.grossSalary = grossSalary;
        this.category = category;
        this.netSalary = grossSalary * 0.8;
        this.workHours = workHours;
    }

    public double calculateOvertimeAndSalary() {
        if (category instanceof SeniorExecutive) {
            return 0.0;
        }

        double normalHourlyRate = category.getHourlyRate();
        int overtimeHours = workHours.getOvertimeHours();
        double overtimeSalary = 0.0;

        if (overtimeHours > 0) {
            int overtime30 = Math.min(8, overtimeHours);
            int overtime50 = Math.min(12, Math.max(0, overtimeHours - 8));

            overtimeSalary += overtime30 * normalHourlyRate * 1.3;
            overtimeSalary += overtime50 * normalHourlyRate * 1.5;
        }

        return overtimeSalary;
    }

    public double calculatePremiumHoursAndSalary() {
        double normalHourlyRate = category.getHourlyRate();
        int premiumHours = workHours.getPremiumHours();
        double premiumSalary = 0.0;

        if (premiumHours > 0) {
            int premium30 = Math.min(8, premiumHours);
            int premium40 = Math.min(8, Math.max(0, premiumHours - 8));
            int premium50 = Math.max(0, premiumHours - 16);

            premiumSalary += premium30 * normalHourlyRate * 1.3;
            premiumSalary += premium40 * normalHourlyRate * 1.4;
            premiumSalary += premium50 * normalHourlyRate * 1.5;
        }

        return premiumSalary;
    }

    public int calculateOvertimeHours() {
        if (category instanceof SeniorExecutive) {
            return 0;
        }

        int normalHours = category.getNormalHoursPerWeek();
        int overtime = Math.max(0, workHours.getNormalHours() - normalHours);
        return Math.min(overtime, 20);
    }

    public double calculateTotalSalary() {
        double baseSalary = category.getWeeklySalary();
        double overtimeSalary = calculateOvertimeAndSalary();
        double premiumSalary = calculatePremiumHoursAndSalary();
        return baseSalary + overtimeSalary + premiumSalary;
    }

    @Override
    public String toString() {
        return "First Name: " + firstName + ", Last Name: " + lastName +
                ", Employee ID: " + employeeId +
                ", Birth Date: " + birthDate +
                ", Hire Date: " + hireDate +
                ", End Date: " + endDate +
                ", Gross Salary: " + grossSalary +
                ", Net Salary: " + netSalary +
                ", Category: " + category.getName() +
                ", Indemnity: " + category.calculateIndemnity() +
                ", Normal Hours Worked: " + workHours.getNormalHours() +
                ", Overtime Hours: " + workHours.getOvertimeHours() +
                ", Premium Hours: " + workHours.getPremiumHours() +
                ", Total Salary: " + calculateTotalSalary();
    }
}
