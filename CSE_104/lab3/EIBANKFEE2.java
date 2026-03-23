package lab3;

import java.util.Scanner;

class finalEIBANKFEE2 {

    private static final double FEE_LOW_BALANCE = 12.0;
    private static final double FEE_MED_BALANCE = 7.5;
    private static final double FEE_HIGH_BALANCE = 5.0;

    private static final double CHECK_FEE_LOW = 0.20;
    private static final double CHECK_FEE_HIGH = 0.10;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int numOfAccounts = sc.nextInt();
        double totalFee = 0;
        long totalChecks = 0;

        for (int i = 0; i < numOfAccounts; i++) {
            double balance = sc.nextDouble();
            int numOfChecks = sc.nextInt();
            double monthlyFee;
            double checkFee;

            if (balance < 500) {
                monthlyFee = FEE_LOW_BALANCE;
                checkFee = CHECK_FEE_LOW;
            } else if (balance < 2000) {
                monthlyFee = FEE_MED_BALANCE;
                checkFee = CHECK_FEE_LOW;
            } else if (balance < 5000) {
                monthlyFee = FEE_HIGH_BALANCE;
                checkFee = CHECK_FEE_HIGH;
            } else {
                monthlyFee = 0;
                checkFee = 0;
            }

            double accountFee = monthlyFee + numOfChecks * checkFee;
            totalFee += accountFee;
            totalChecks += numOfChecks;
        }

        double averageFee = totalFee / totalChecks;
        System.out.println(averageFee);

        sc.close();
    }

}
