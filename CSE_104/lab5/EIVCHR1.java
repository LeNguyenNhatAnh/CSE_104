package lab5;

import java.util.Scanner;

public class EIVCHR1 {
    private static final int DISCOUNT_PERCENT = 30;
    private static final long MAX_DISCOUNT = 50000;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long price = sc.nextLong();
        long discount = (price / 100) * DISCOUNT_PERCENT;
        if (discount > MAX_DISCOUNT)
            discount = MAX_DISCOUNT;

        long finalPrice = price - discount;
        System.out.println(finalPrice);

        sc.close();
    }

}
