import java.util.Scanner;

class EIUCARLOAN2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double oldCarPrice = sc.nextDouble();
        double newCarPrice = sc.nextDouble();
        double downPayRate = sc.nextDouble();
        int totalMonths = sc.nextInt();
        int sellMonth = sc.nextInt();
        double monthlyDepreciation = sc.nextDouble();

        double carValueAtK = oldCarPrice * 0.9 * Math.pow(1 - monthlyDepreciation / 100.0, sellMonth - 1);
        double downPaymentOfNewCar = newCarPrice * (downPayRate / 100.0);
        double debtTarget = carValueAtK - downPaymentOfNewCar;

        double l = 0;
        double r = 0.2;
        double initialLoan = oldCarPrice - (oldCarPrice * downPayRate / 100.0);

        while (r - l > Math.pow(10, -9)) {
            double possibleRate = (r + l) / 2.0;
            double R = 1 + possibleRate;

            double G = initialLoan * Math.pow(R, totalMonths) * (R - 1) / (Math.pow(R, totalMonths) - 1);

            double currentDebt = initialLoan * Math.pow(R, sellMonth - 1)
                    - G * (Math.pow(R, sellMonth - 1) - 1) / (R - 1);

            if (currentDebt > debtTarget) {
                r = possibleRate;
            } else {
                l = possibleRate;
            }
        }

        System.out.printf("%.4f\n", ((l + r) / 2.0) * 12.0);
        sc.close();

    }
}