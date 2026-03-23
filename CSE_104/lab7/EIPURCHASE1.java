import java.util.Scanner;

public class EIPURCHASE1 {
    private static final double EPSILON = 1e-9;
    private static final double INITIAL_HIGH = 1.0;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long realPrice = scanner.nextLong();
        long months = scanner.nextLong();

        long downPayment = scanner.nextLong();
        long monthlyPayment = scanner.nextLong();

        long originalDebt = realPrice - downPayment;

        double low = 0.0;
        double high = INITIAL_HIGH;

        while (high - low > EPSILON) {
            double mid = (low + high) / 2.0;

            double powTerm = Math.pow(1.0 + mid, months);
            double functionValue = originalDebt * mid * powTerm
                    - monthlyPayment * (powTerm - 1.0);

            if (functionValue > 0) {
                high = mid;
            } else {
                low = mid;
            }
        }

        System.out.printf("%.3f%n", low);

        scanner.close();
    }
}