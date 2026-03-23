import java.util.Scanner;

 class EIUBHOUSE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double houseCost = sc.nextDouble();
        double availableMoney = sc.nextDouble();
        int months = sc.nextInt();
        double interest = sc.nextDouble();

        double loan = houseCost - availableMoney;
        double principalPerMonth = loan / months;
        double monthlyRate = interest / 100.0;
        double debt = loan;

        for (int i = 1; i <= months; i++) {
            double interestMonth = debt * monthlyRate;
            double payment = principalPerMonth + interestMonth;

            System.out.println(i + " " + Math.round(payment));
            debt -= principalPerMonth;
        }

        sc.close();
    }
}
