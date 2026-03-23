package lab4;

import java.util.Scanner;

public class EIBANKRATE {
    private static final double ANNUAL_INTEREST_RATE = 0.09;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double principal = sc.nextLong();
        int months = sc.nextInt();

        double totalAmount = principal * (1 + ANNUAL_INTEREST_RATE * months / 12.0);

        System.out.println(totalAmount);

        sc.close();
    }
}