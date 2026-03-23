package lab3;

import java.util.Scanner;

public class EIUMARKUP {
    private static final long MAX_PRICE = 200;
    private static final long MIN_PRICE = 180;
    private static final long MAX_QUANTITY_PER_PRICE = 100;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long numberOfProducts = scanner.nextLong();
        long totalCost = 0;
        long currentPrice = MAX_PRICE;

        while (numberOfProducts > 0 && currentPrice >= MIN_PRICE) {
            long quantityTaken = Math.min(MAX_QUANTITY_PER_PRICE, numberOfProducts);

            totalCost += quantityTaken * currentPrice;
            numberOfProducts -= quantityTaken;
            currentPrice--;
        }

        if (numberOfProducts > 0)
            totalCost += numberOfProducts * MIN_PRICE;

        System.out.println(totalCost);
        scanner.close();
    }
}