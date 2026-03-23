package lab4;

import java.util.Scanner;

public class EIDINRATE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testCases = sc.nextInt();

        for (int i = 0; i < testCases; i++) {
            double originalMoney = sc.nextDouble();
            double rate = sc.nextDouble();
            double targetMoney = sc.nextDouble();

            int years = 0;
            double currentMoney = originalMoney;

            while (currentMoney < targetMoney) {
                // Tính tiền sau 1 năm: Tiền gốc * (1 + lãi suất/100)
                currentMoney = currentMoney * (1 + rate / 100.0);
                years++;
            }

            System.out.println(years);

        }
        sc.close();
    }
}