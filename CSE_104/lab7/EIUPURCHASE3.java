

import java.util.Scanner;  

public class EIUPURCHASE3 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long originalPrice = scanner.nextLong();
        long downPayment = scanner.nextLong();
        int months = scanner.nextInt();
        double monthlyInterestRate = scanner.nextDouble();

        double loanAmount = originalPrice - downPayment;
        double compoundFactor = Math.pow(1 + monthlyInterestRate, months);

        double monthlyPayment = (loanAmount * monthlyInterestRate * compoundFactor)
                / (compoundFactor - 1);

        long result = (long) Math.floor(monthlyPayment);

        System.out.println(result);

        scanner.close();
    }
}