package lab4;

import java.util.Scanner;

public class EIGROSS2 {
    private static final int ONE_MILLION = 1_000_000;
    private static final int PERSONAL_DEDUCTION = 11 * ONE_MILLION;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long afterTaxIncome = sc.nextLong();
        long taxableIncome = afterTaxIncome - PERSONAL_DEDUCTION;

        if (taxableIncome <= 0) {
            System.out.println(afterTaxIncome);

        } else if (taxableIncome <= 4.75 * ONE_MILLION) {
            double beforeTax = taxableIncome / (1 - 0.05);
            System.out.println(Math.round(beforeTax + PERSONAL_DEDUCTION));

        } else if (taxableIncome <= 9.25 * ONE_MILLION) {
            double beforeTax = 5 * ONE_MILLION
                    + (taxableIncome - 4.75 * ONE_MILLION) / (1 - 0.10);
            System.out.println(Math.round(beforeTax + PERSONAL_DEDUCTION));

        } else if (taxableIncome <= 16.05 * ONE_MILLION) {
            double beforeTax = 10 * ONE_MILLION
                    + (taxableIncome - 9.25 * ONE_MILLION) / (1 - 0.15);
            System.out.println(Math.round(beforeTax + PERSONAL_DEDUCTION));

        } else if (taxableIncome <= 27.25 * ONE_MILLION) {
            double gross = 18 * ONE_MILLION
                    + (taxableIncome - 16.05 * ONE_MILLION) / (1 - 0.20);
            System.out.println(Math.round(gross + PERSONAL_DEDUCTION));

        } else if (taxableIncome <= 42.25 * ONE_MILLION) {
            double beforeTax = 32 * ONE_MILLION
                    + (taxableIncome - 27.25 * ONE_MILLION) / (1 - 0.25);
            System.out.println(Math.round(beforeTax + PERSONAL_DEDUCTION));

        } else if (taxableIncome <= 61.85 * ONE_MILLION) {
            double gross = 52 * ONE_MILLION
                    + (taxableIncome - 42.25 * ONE_MILLION) / (1 - 0.30);
            System.out.println(Math.round(gross + PERSONAL_DEDUCTION));

        } else {
            double gross = 80 * ONE_MILLION
                    + (taxableIncome - 61.85 * ONE_MILLION) / (1 - 0.35);
            System.out.println(Math.round(gross + PERSONAL_DEDUCTION));
        }

        sc.close();
    }
}