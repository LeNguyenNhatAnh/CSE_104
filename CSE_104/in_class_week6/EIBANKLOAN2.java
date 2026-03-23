package in_class_week6;

import java.util.Scanner;

public class EIBANKLOAN2 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        final double initialLoan = scanner.nextDouble();
        final double monthlyPayment = scanner.nextDouble();
        final double annualRate = scanner.nextDouble();

        double monthlyRate = annualRate / 100.0 / 12.0;
        double remainingLoan = initialLoan;
        long monthCount = 0;

        while (remainingLoan > 0) {
            monthCount++;
            remainingLoan += remainingLoan * monthlyRate;
            remainingLoan -= monthlyPayment;
        }

        System.out.println(monthCount);

        scanner.close();
    }
}
