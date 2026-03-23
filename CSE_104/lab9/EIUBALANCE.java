import java.util.Scanner;

class EIUBALANCE {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int months = sc.nextInt();
        double[] salaries = new double[months];
        for (int i = 0; i < months; i++) {
            salaries[i] = sc.nextDouble();
        }

        double firstKPI = sc.nextDouble();
        double rYear = sc.nextDouble();
        double fYear = sc.nextDouble();
        double rMonth = rYear / 1200.0;
        double fMonth = fYear / 1200.0;

        double currentSaving = 0;
        double currentExpenses = firstKPI;

        for (int i = 0; i < months; i++) {
            currentSaving += (salaries[i] - currentExpenses);
            currentSaving *= (1 + rMonth);
            currentExpenses *= (1 + fMonth);
        }

        for (int i = 0; i < months; i++) {
            currentSaving -= currentExpenses;
            currentSaving *= (1 + rMonth);
            currentExpenses *= (1 + fMonth);
        }

        if (currentSaving < 0)
            System.out.println(0);
        else
            System.out.println(Math.round(currentSaving));

        sc.close();
    }
}
