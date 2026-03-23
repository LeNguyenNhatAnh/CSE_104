package lab3;

import java.util.Scanner;

public class EIUDISCOUNT3 {
    private static final double ONLINE_DISCOUNT_RATE = 0.98;
    private static final double VIP_DISCOUNT_RATE = 0.98;
    private static final double CARD_DISCOUNT_RATE = 0.98;

    private static final double[] PRICE_THRESHOLDS = { 5_000_000, 20_000_000, 100_000_000, 300_000_000, 600_000_000,
            900_000_000, Double.MAX_VALUE };
    private static final double[] DISCOUNT_RATES = { 0.03, 0.05, 0.07, 0.10, 0.12, 0.15 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long originalPrice = scanner.nextLong();
        int isOnline = scanner.nextInt();
        int isVip = scanner.nextInt();
        int hasCard = scanner.nextInt();

        double totalDiscount = 0;

        for (int i = 0; i < DISCOUNT_RATES.length; i++) {
            if (originalPrice > PRICE_THRESHOLDS[i]) {
                double applicableAmount = Math.min(
                        PRICE_THRESHOLDS[i + 1] - PRICE_THRESHOLDS[i],
                        originalPrice - PRICE_THRESHOLDS[i]);
                totalDiscount += applicableAmount * DISCOUNT_RATES[i];
            }
        }

        long finalPrice = (long) (originalPrice - totalDiscount);

        if (isOnline == 1)
            finalPrice = (long) (finalPrice * ONLINE_DISCOUNT_RATE);
        if (isVip == 1)
            finalPrice = (long) (finalPrice * VIP_DISCOUNT_RATE);
        if (hasCard == 1)
            finalPrice = (long) (finalPrice * CARD_DISCOUNT_RATE);

        System.out.println(finalPrice);
        scanner.close();
    }
}