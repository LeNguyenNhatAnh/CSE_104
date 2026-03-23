import java.util.Scanner;

public class EIUCREDIT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt(); // Số giao dịch
        double r = sc.nextDouble(); // Lãi suất tháng
        int tLimit = sc.nextInt(); // Thời điểm cần tính T

        int[] days = new int[n];
        double[] amounts = new double[n];

        for (int i = 0; i < n; i++) {
            days[i] = sc.nextInt();
            amounts[i] = sc.nextDouble();
        }

        double currentBalance = 0;
        double sumNegativeBalance = 0;
        int transactionIdx = 0;

        // Chạy qua từng ngày từ ngày 1 đến ngày T-1
        for (int day = 1; day < tLimit; day++) {
            // Xử lý tất cả giao dịch trong ngày hiện tại
            while (transactionIdx < n && days[transactionIdx] == day) {
                currentBalance += amounts[transactionIdx];
                transactionIdx++;
            }

            // Nếu cuối ngày số dư bị âm, cộng dồn vào tổng nợ để tính ADB
            if (currentBalance < 0) {
                sumNegativeBalance += currentBalance;
            }

            // Cuối mỗi tháng (ngày 30, 60, 90...), tính lãi và reset tổng nợ tháng mới
            if (day % 30 == 0) {
                double monthlyInterest = (sumNegativeBalance / 30.0) * r;
                currentBalance += monthlyInterest; // Lãi nhập gốc (nợ càng nợ)
                sumNegativeBalance = 0; // Reset cho tháng tiếp theo
            }
        }

        // In kết quả làm tròn 2 chữ số thập phân
        System.out.printf("%.2f\n", currentBalance);
        sc.close();
    }
}