import java.util.Scanner;

public class EIUFF {

    private static final int ITERATIONS = 200;
    private static final double UPPER_BOUND = 1e13;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double monthlyReturn = sc.nextDouble() / 100.0;
        double monthlyRate = sc.nextDouble() / 100.0;
        double money = sc.nextDouble();
        int months = sc.nextInt();

        double from = 0.0;
        double to = UPPER_BOUND;

        for (int i = 0; i < ITERATIONS; i++) {
            double middle = (from + to) / 2.0;

            if (calculateBalance(middle, months, money, monthlyReturn, monthlyRate)) {
                to = middle;
            } else {
                from = middle;
            }
        }

        System.out.printf("%.4f%n", to);

        sc.close();
    }

    public static boolean calculateBalance(double X, int months, double money, double monthlyReturn, double monthlyRate) {
        double balance = X;
        double withdraw = money;

        for (int i = 1; i <= months - 1; i++) {
            balance = balance * (1 + monthlyReturn);
            balance = balance - withdraw;

            if (balance < 0) {
                return false;
            }

            withdraw = withdraw * (1 + monthlyRate);
        }

        return true;
    }
}