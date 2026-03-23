package lab7;

import java.util.*;

public class EIVINFASTBATERY {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        long carCost = scanner.nextLong();
        long batteryValue = scanner.nextLong();
        long months = scanner.nextLong();
        double interestRate = scanner.nextDouble();

        double monthlyRate = interestRate / 100.0;
        double compoundFactor = Math.pow(1 + monthlyRate, months);

        double numerator = (carCost * compoundFactor - batteryValue) * monthlyRate;
        double denominator = compoundFactor - 1;

        double result = numerator / denominator;

        System.out.println(Math.round(result));

        scanner.close();
    }
}