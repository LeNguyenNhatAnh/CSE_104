package lab5;

import java.util.Scanner;

public class EIVCHR2 {
    private static final int DISCOUNT_PERCENT = 30;
    private static final long MAX_DISCOUNT = 50000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfItems = sc.nextInt();
        long totalOriginalPrice = 0;
        long maxPrice = 0;

        for (int i = 0; i < numOfItems; i++) {
            long currentPrice = sc.nextLong();
            totalOriginalPrice += currentPrice;

            if (currentPrice > maxPrice)
                maxPrice = currentPrice;
        }

        long discount = (maxPrice / 100) * DISCOUNT_PERCENT;
        if (discount > MAX_DISCOUNT)
            discount = MAX_DISCOUNT;

        long finalPrice = totalOriginalPrice - discount;
        System.out.println(finalPrice);

        sc.close();
    }

}
