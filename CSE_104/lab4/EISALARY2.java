package lab4;

import java.util.Scanner;

public class EISALARY2 {
    private static final int WORKING_DAYS = 5;
    private static final double REGULAR_HOURS_PER_DAY = 8.0;
    private static final double OVERTIME_RATE = 1.5;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfEmployees = sc.nextInt();

        double totalRegularSalary = 0;
        double totalOvertimeSalary = 0;
        double totalRegularHours = 0;
        double totalOvertimeHours = 0;

        for (int i = 0; i < numberOfEmployees; i++) {

            double[] hours = new double[WORKING_DAYS];
            for (int j = 0; j < WORKING_DAYS; j++) {
                hours[j] = sc.nextDouble();
            }

            double hourlyWage = sc.nextDouble();
            double weeklyPay = 0;

            for (int j = 0; j < WORKING_DAYS; j++) {
                double dailyHours = hours[j];

                double regularHours = Math.min(dailyHours, REGULAR_HOURS_PER_DAY);
                double overtimeHours = Math.max(0, dailyHours - REGULAR_HOURS_PER_DAY);

                weeklyPay += regularHours * hourlyWage;
                weeklyPay += overtimeHours * hourlyWage * OVERTIME_RATE;

                totalRegularHours += regularHours;
                totalOvertimeHours += overtimeHours;
                totalRegularSalary += regularHours * hourlyWage;
                totalOvertimeSalary += overtimeHours * hourlyWage * OVERTIME_RATE;
            }

            System.out.printf("%.2f%n", weeklyPay);
        }

        double averageRegularSalary = totalRegularHours == 0 ? 0 : totalRegularSalary / totalRegularHours;
        double averageOvertimeSalary = totalOvertimeHours == 0 ? 0 : totalOvertimeSalary / totalOvertimeHours;

        System.out.printf("%.2f%n", averageRegularSalary);
        System.out.printf("%.2f%n", averageOvertimeSalary);

        sc.close();
    }
}