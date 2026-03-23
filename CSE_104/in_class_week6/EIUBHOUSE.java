package in_class_week6;

import java.util.Scanner;

public class EIUBHOUSE {

    private static final double PERCENT = 100.0;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long housePrice = sc.nextLong();
        long borrowFromBank = sc.nextLong();
        int months = sc.nextInt();
        double rate = sc.nextDouble();

        double loan = (double) housePrice - borrowFromBank;
        double principalPerMonth = loan / months;
        double monthlyRate = rate / PERCENT;

        double currentRemainingLoan = loan;

        for (int month = 1; month <= months; month++) {
            double interestMonth = currentRemainingLoan * monthlyRate;
            double totalPayment = principalPerMonth + interestMonth;

            System.out.println(month + " " + (long) Math.round(totalPayment));
            currentRemainingLoan -= principalPerMonth;
        }

        sc.close();
    }

}
