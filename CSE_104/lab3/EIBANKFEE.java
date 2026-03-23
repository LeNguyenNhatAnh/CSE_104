package lab3;

import java.util.Scanner;

public class EIBANKFEE {
    private static final double[] MONTHLY_FEES = { 12.00, 7.50, 5.00, 0.00 };
    private static final double[] CHECK_FEES = { 0.20, 0.20, 0.10, 0.00 };
    private static final double[] BALANCE_LIMITS = { 500, 2000, 5000, Double.MAX_VALUE };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double balance = scanner.nextDouble();
        int numberOfChecks = scanner.nextInt();

        double totalFee = 0.0;

        for (int i = 0; i < CHECK_FEES.length; i++) {
            if (balance < BALANCE_LIMITS[i]) {
                totalFee = MONTHLY_FEES[i] + CHECK_FEES[i] * numberOfChecks;
                break;
            }
        }

        System.out.printf("%.2f", totalFee);
        scanner.close();
    }
}