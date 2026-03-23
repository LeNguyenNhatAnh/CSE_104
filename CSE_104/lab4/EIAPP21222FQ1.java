package lab4;
import java.util.Scanner;

public class EIAPP21222FQ1 {

    static final double[] RATES = { 0, 0.039, 0.0392, 0.0395, 0.0399, 0.0404, 0.0554, 0.0572, 0.0592, 0.0614, 0.0638,
            0.0664, 0.0692 };

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long initialAmount = scanner.nextLong();
        int months = scanner.nextInt();

        double totalAmount = calculateSaving(initialAmount, months);
        System.out.println(Math.round(totalAmount));

        scanner.close();
    }

    // Calculate total saving (principal + interest) after given months
    static double calculateSaving(double principal, int months) {
        int years = months / 12;
        int remainingMonths = months % 12;

        double total = principal;

        if (years > 0)
            total *= Math.pow(1 + RATES[12], years);

        if (remainingMonths > 0)
            total *= (1 + RATES[remainingMonths] * remainingMonths / 12.0);

        return total;
    }
}