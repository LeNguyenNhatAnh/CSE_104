import java.util.Scanner;

public class EIAPP21222FQ3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextDouble()) return;
        double nGoal = sc.nextDouble(); // 70000
        int mMonths = sc.nextInt();    // 4

        // Lãi suất tháng cố định cho kỳ hạn 1 tháng là 3.90%
        double annualRate = 3.90 / 100.0;
        double monthlyRate = annualRate / 12.0;

        // Công thức Ordinary Annuity (Gửi cuối kỳ):
        // N = X * [ ( (1 + r)^M - 1 ) / r ]
        // Suy ra X = (N * r) / ( (1 + r)^M - 1 )
        
        double powTerm = Math.pow(1 + monthlyRate, mMonths);
        double xAmount = (nGoal * monthlyRate) / (powTerm - 1);

        // Xuất kết quả làm tròn 4 chữ số thập phân
        System.out.printf("%.4f\n", xAmount);

        sc.close();
    }
}