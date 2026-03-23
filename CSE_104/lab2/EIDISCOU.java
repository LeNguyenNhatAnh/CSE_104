import java.util.Scanner;

public class EIDISCOU {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double price = sc.nextDouble();
        double totalDis = 0;
        double[] money = new double[] { 2_000_000, 10_000_000, 50_000_000, 100_000_000, 200_000_000, 500_000_000,
                Long.MAX_VALUE };
        double[] discountRate = new double[] { 0.03, 0.05, 0.07, 0.1, 0.12, 0.15 };

        for (int i = 0; i < discountRate.length; i++) {
            if (price > money[i]) {
                totalDis += Math.min((money[i + 1] - money[i]), (price - money[i])) * discountRate[i];
            }
        }
        System.out.println(Math.round(price - totalDis));
        sc.close();
    }
}
