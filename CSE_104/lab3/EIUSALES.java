package lab3;

import java.util.Scanner;

public class EIUSALES {

    private static final double[] SALES_THRESHOLDS = { 0, 20, 50, 200, 500, 2000, Double.MAX_VALUE };
    private static final double[] BONUS_RATES = { 0.02, 0.03, 0.04, 0.05, 0.06, 0.07 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        double salesAmount = scanner.nextDouble();
        double totalBonus = 0;

        for (int i = 0; i < BONUS_RATES.length; i++) {
            if (salesAmount > SALES_THRESHOLDS[i]) {
                double applicableAmount = Math.min(SALES_THRESHOLDS[i + 1] - SALES_THRESHOLDS[i],
                        salesAmount - SALES_THRESHOLDS[i]);
                totalBonus += applicableAmount * BONUS_RATES[i];
            }
        }

        System.out.printf("%.3f", totalBonus);
        scanner.close();
    }
}