package lab4;

import java.util.Scanner;

class EITAX {

    private static final long PERSONAL_DEDUCTION = 9_000_000;
    private static final long ONE_MILLION = 1_000_000;

    private static final long[] TAX_BRACKETS = { 5 * ONE_MILLION, 10 * ONE_MILLION, 18 * ONE_MILLION, 32 * ONE_MILLION,
            52 * ONE_MILLION, 80 * ONE_MILLION, Long.MAX_VALUE };

    private static final double[] TAX_RATES = { 0.05, 0.10, 0.15, 0.20, 0.25, 0.30, 0.35 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long grossIncome = scanner.nextLong();
        long taxableIncome = grossIncome - PERSONAL_DEDUCTION;

        if (taxableIncome <= 0) {
            System.out.println(0);
            scanner.close();
            return;
        }

        long totalTax = calculateTax(taxableIncome);
        System.out.println(totalTax);

        scanner.close();
    }

    private static long calculateTax(long taxableIncome) {
        long tax = 0;
        long previousLimit = 0;

        for (int i = 0; i < TAX_BRACKETS.length; i++) {
            if (taxableIncome <= previousLimit)
                break;

            long currentLimit = TAX_BRACKETS[i];
            long taxablePart = Math.min(taxableIncome, currentLimit) - previousLimit;

            tax += Math.round(taxablePart * TAX_RATES[i]);
            previousLimit = currentLimit;
        }

        return tax;
    }
}
