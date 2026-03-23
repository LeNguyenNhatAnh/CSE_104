package lab3;

import java.util.Scanner;

public class EIMEMCARD {
private static final double RATE_LEVEL_1 = 0.02;
    private static final double RATE_LEVEL_2 = 0.03;
    private static final double RATE_LEVEL_3 = 0.05;
    private static final double RATE_LEVEL_4 = 0.07;

    private static final long ONE_MILLION = 1_000_000;
    private static final long TWENTY_MILLION = 20_000_000;
    private static final long FIFTY_MILLION = 50_000_000;
    private static final long TWO_HUNDRED_MILLION = 200_000_000;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfInvoices = scanner.nextInt();
        double[] invoices = new double[numberOfInvoices];

        for (int i = 0; i < numberOfInvoices; i++) {
            invoices[i] = scanner.nextDouble();
        }

        double totalAmount = 0;

        for (int i = 0; i < numberOfInvoices; i++) {
            double discountRate = getDiscountRate(totalAmount);
            double discount = invoices[i] * discountRate;

            printDiscount(discount, i, numberOfInvoices);

            totalAmount += invoices[i];
        }

        scanner.close();
    }

    private static double getDiscountRate(double totalAmount) {
        if (totalAmount >= TWO_HUNDRED_MILLION)
            return RATE_LEVEL_4;
        if (totalAmount >= FIFTY_MILLION)
            return RATE_LEVEL_3;
        if (totalAmount >= TWENTY_MILLION)
            return RATE_LEVEL_2;
        if (totalAmount >= ONE_MILLION)
            return RATE_LEVEL_1;
        return 0;
    }

    private static void printDiscount(double discount, int index, int total) {
        if (discount == (long) discount)
            System.out.print((long) discount);
        else
            System.out.print(discount);

        if (index < total - 1)
            System.out.print(" ");
    }
}