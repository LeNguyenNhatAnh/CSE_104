package lab5;

import java.util.Arrays;
import java.util.Scanner;

public class EIVCHR3 {
    private static final int DISCOUNT_PERCENT = 30;
    private static final long MAX_DISCOUNT = 50000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfItems = sc.nextInt();
        int numOfVouchers = sc.nextInt();

        long[] prices = new long[numOfItems];
        for (int i = 0; i < numOfItems; i++)
            prices[i] = sc.nextLong();

        Arrays.sort(prices);
        long totalPay = 0;

        for (int i = numOfItems - 1; i >= 0; i--) {
            long currentPrice = prices[i];
            if (numOfVouchers > 0) {
                long discount = (currentPrice / 100) * DISCOUNT_PERCENT;
                if (discount > MAX_DISCOUNT)
                    discount = MAX_DISCOUNT;

                totalPay += (currentPrice - discount);
                numOfVouchers--;
            } else
                totalPay += currentPrice;

        }

        System.out.println(totalPay);

        sc.close();
    }

}
