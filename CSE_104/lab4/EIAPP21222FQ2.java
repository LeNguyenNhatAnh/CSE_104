package lab4;
import java.util.Scanner;

public class EIAPP21222FQ2 {
    static final double[] INTEREST_RATES = { 0, 0.039, 0.0392, 0.0395, 0.0399, 0.0404, 0.0554, 0.0572, 0.0592, 0.0614,
            0.0638, 0.0664, 0.0692 };

    // Calculates total amount (principal + interest) after a given number of month
    // for a single deposit.
    static double calculateSavingForSingleDeposit(double principal, int months) {
        int years = months / 12;
        int remainingMonths = months % 12;

        double totalAmount = principal;

        if (years > 0)
            totalAmount *= Math.pow(1 + INTEREST_RATES[12], years);

        if (remainingMonths > 0)
            totalAmount *= (1 + INTEREST_RATES[remainingMonths] * remainingMonths / 12.0);

        return totalAmount;
    }

    // Calculates the maximum total saving from multiple monthly deposits.
    static double calculateTotalSaving(int totalMonths, double[] deposits) {
        double totalAmount = 0;

        for (int i = 0; i < totalMonths; i++) {
            int remainingMonths = totalMonths - i;
            totalAmount += calculateSavingForSingleDeposit(deposits[i], remainingMonths);
        }

        return totalAmount;
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int totalMonths = scanner.nextInt();
        double[] deposits = new double[totalMonths];

        for (int i = 0; i < totalMonths; i++) {
            deposits[i] = scanner.nextDouble();
        }

        double result = calculateTotalSaving(totalMonths, deposits);
        System.out.println(Math.round(result));

        scanner.close();
    }
}
