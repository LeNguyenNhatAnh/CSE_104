import java.util.Scanner;

public class EIURETIRE2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt())
            return;
        int n = sc.nextInt(); // Số tháng làm việc
        double rYear = sc.nextDouble(); // Lãi suất năm
        double fYear = sc.nextDouble(); // Lạm phát năm

        double[] m = new double[n];
        double maxSalary = 0;
        for (int i = 0; i < n; i++) {
            m[i] = sc.nextDouble();
            if (m[i] > maxSalary)
                maxSalary = m[i];
        }

        double rMonth = rYear / 1200.0;
        double fMonth = fYear / 1200.0;

        // Binary Search tìm X0
        double low = 0;
        double high = 1e15; // Giả định chi tiêu tối đa rất lớn (hoặc dựa trên maxSalary)

        for (int i = 0; i < 100; i++) {
            double midX0 = (low + high) / 2.0;
            if (check(midX0, n, rMonth, fMonth, m)) {
                low = midX0;
            } else {
                high = midX0;
            }
        }

        // Đề bài yêu cầu "rounded down in units" -> Dùng Math.floor hoặc ép kiểu long
        System.out.println((long) Math.floor(low));
        sc.close();
    }

    private static boolean check(double x0, int n, double r, double f, double[] m) {
        double currentSaving = 0;
        double currentExpense = x0;

        // Tổng cộng 100 năm = 1200 tháng
        for (int i = 0; i < 1200; i++) {
            // Tiền lãi tháng trước sinh ra
            currentSaving = currentSaving * (1 + r);

            // Dòng tiền tháng này
            double salary = (i < n) ? m[i] : 0;
            currentSaving += (salary - currentExpense);

            // Cập nhật chi phí cho tháng kế tiếp
            currentExpense = currentExpense * (1 + f);

            // Nếu nợ quá nhiều không thể trả nổi (tùy chọn tối ưu)
            if (currentSaving < -1e18)
                return false;
        }

        return currentSaving >= 0;
    }
}