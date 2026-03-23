package lab7;

import java.util.Scanner;

public class EIUFF2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double annualInterestRate = scanner.nextDouble();
        double inflationRate = scanner.nextDouble();
        double firstYearSpending = scanner.nextDouble();

        double rateDifference = annualInterestRate - inflationRate;

        double capital = (firstYearSpending * 100.0) / rateDifference;

        System.out.println((long) Math.ceil(capital));

        scanner.close();
    }
}
