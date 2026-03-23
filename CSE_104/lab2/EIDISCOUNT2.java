import java.util.Scanner;

public class EIDISCOUNT2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double price = sc.nextDouble();
        double totalDiscount = 0;
        double[] money = new double[] { 5_000_000, 20_000_000, 100_000_000, 300_000_000, 600_000_000, 900_000_000,
                Long.MAX_VALUE };
        double[] disRate = new double[] { 0.03, 0.05, 0.07, 0.1, 0.12, 0.15 };

        for (int i = 0; i < disRate.length; i++) {
            if (price > money[i])
                totalDiscount += Math.min((money[i + 1] - money[i]), (price - money[i])) * disRate[i];
        }
        System.out.println(Math.round(price - totalDiscount));
        sc.close();
    }

}
