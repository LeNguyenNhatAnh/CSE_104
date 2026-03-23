package lab5;
import java.util.Scanner;

public class EIINTEREST1 {
    private static final int MONTHS_IN_YEAR = 12;

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);

		double monthlyRate = sc.nextDouble();
		double currentBalance = 0;

		for (int month = 0; month < MONTHS_IN_YEAR; month++) {
			long deposit = sc.nextLong();
			currentBalance = (currentBalance + deposit);
			currentBalance = currentBalance * (1 + monthlyRate);
		}

		System.out.println(Math.round(currentBalance));
		sc.close();
	}

}
