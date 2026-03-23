package lab3;

import java.util.Scanner;

public class EIUCHRMS {

    private static final int THOUSAND = 1_000;
    private static final double[] INCOME_THRESHOLDS = {
            0,
            2_000 * THOUSAND,
            5_000 * THOUSAND,
            10_000 * THOUSAND,
            20_000 * THOUSAND,
            50_000 * THOUSAND,
            100_000 * THOUSAND,
            200_000 * THOUSAND
    };

    private static final double[] DISCOUNT_RATES = {
            0.03, 0.04, 0.05, 0.06, 0.07, 0.08, 0.09, 0.10
    };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInvoices = scanner.nextInt();
        double totalIncome = 0;

        for (int i = 0; i < numberOfInvoices; i++) {
            int invoiceAmount = scanner.nextInt();

            for (int j = DISCOUNT_RATES.length - 1; j >= 0; j--) {
                if (invoiceAmount > INCOME_THRESHOLDS[j]) {
                    totalIncome += invoiceAmount * (1 - DISCOUNT_RATES[j]);
                    break;
                }
            }
        }

        System.out.println(Math.round(totalIncome));
        scanner.close();
    }
}