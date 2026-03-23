package lab4;

import java.util.Scanner;

public class EIGROSS {
    private static final double TAX_RATE = 0.10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numberOfCases = sc.nextInt();

        for (int i = 0; i < numberOfCases; i++) {
            double netIncome = sc.nextDouble();

            double grossIncome = netIncome / (1 - TAX_RATE);
            double tax = grossIncome - netIncome;

            System.out.printf("%.2f%n", tax);
        }

        sc.close();
    }
}