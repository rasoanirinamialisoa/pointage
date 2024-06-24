package com.example.timekeeping;

import com.example.timekeeping.category.Category;
import com.example.timekeeping.category.SeniorExecutive;
import lombok.Getter;
import lombok.Setter;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

@Getter
@Setter
public class Employee {

    private static final Logger logger = LogManager.getLogger(Employee.class);
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
    private WorkCalendar workCalendar;

    public Employee(String firstName, String lastName, String employeeId, LocalDate birthDate,
                    LocalDate hireDate, LocalDate endDate, double grossSalary,
                    Category category, WorkHours workHours, WorkCalendar workCalendar) {
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
        this.workCalendar = workCalendar;
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

        int overtimeHoursRakoto = Math.max(rakotoWorkHours.getNormalHours() - 176, 0);
        int premiumHoursRakoto = calculatePremiumHours(LocalDate.of(2024, 6, 1), rakotoWorkHours.getNormalHours());

        int overtimeHoursRabe = Math.max(rabeWorkHours.getNormalHours() - 176, 0);
        int premiumHoursRabe = calculatePremiumHours(LocalDate.of(2024, 6, 1), rabeWorkHours.getNormalHours());

        logger.info("Rakoto - Normal hours: " + rakotoWorkHours.getNormalHours() + ", Overtime hours: " + overtimeHoursRakoto + ", Premium hours: " + premiumHoursRakoto);
        logger.info("Rabe - Normal hours: " + rabeWorkHours.getNormalHours() + ", Overtime hours: " + overtimeHoursRabe + ", Premium hours: " + premiumHoursRabe);

        double paymentRakoto = rakotoWorkHours.getNormalHours() * hourlyRateRakoto
                + overtimeHoursRakoto * hourlyRateRakoto * 1.3
                + premiumHoursRakoto * hourlyRateRakoto * 1.5;

        double paymentRabe = rabeWorkHours.getNormalHours() * hourlyRateRabe
                + overtimeHoursRabe * hourlyRateRabe * 1.3
                + premiumHoursRabe * hourlyRateRabe * 1.5;

        logger.info("Payment for Rakoto: $" + paymentRakoto);
        logger.info("Payment for Rabe: $" + paymentRabe);
    }

    private static int calculatePremiumHours(LocalDate date, int normalHours) {
        Set<LocalDate> publicHolidays = new HashSet<>(Arrays.asList(
                LocalDate.of(2024, 6, 17),
                LocalDate.of(2024, 6, 25),
                LocalDate.of(2024, 6, 26)
        ));

        int premiumHours = 0;
        if (isNightWork(date)) {
            premiumHours = normalHours;
        }
        if (date.getDayOfWeek().getValue() == 7) {
            premiumHours = normalHours;
        }

        if (publicHolidays.contains(date)) {
            premiumHours = normalHours;
        }

        return premiumHours;
    }
    private static boolean isNightWork(LocalDate date) {
        return date.getYear() >= 20 || date.getYear() < 6;
    }
}
