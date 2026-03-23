import java.util.Scanner;

class EIAPP21222FQ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextDouble())
            return;

        double P = sc.nextDouble(); // Giá xe cũ
        double New_P = sc.nextDouble(); // Giá xe mới
        double mPercent = sc.nextDouble(); // % đặt cọc
        int n = sc.nextInt(); // Kỳ hạn n tháng
        double rYear = sc.nextDouble(); // Lãi suất năm
        double lPercent = sc.nextDouble(); // % khấu hao tháng

        double rate = mPercent / 100.0;
        double rMonth = rYear / 1200.0;
        double lMonth = lPercent / 100.0;

        // 1. Khoản vay và Tiền trả hàng tháng
        double loan = P * (1 - rate);
        double monthlyPayment;
        if (rMonth > 0) {
            monthlyPayment = (loan * rMonth) / (1 - Math.pow(1 + rMonth, -n));
        } else {
            monthlyPayment = loan / n;
        }

        // 2. Mục tiêu tiền cọc xe mới
        double target = New_P * rate;

        // 3. Trạng thái tại tháng 0
        double currentBalance = loan;
        double currentValue = P * 0.9; // Giảm 10% ngay lập tức

        // Kiểm tra tháng 0 ngay
        if (currentValue - currentBalance >= target - 1e-9) {
            System.out.println("0 0");
            return;
        }

        // 4. Chạy mô phỏng từ tháng 1 đến n
        for (int month = 1; month <= n; month++) {
            // Xe mất giá
            currentValue *= (1 - lMonth);

            // Trả nợ (Lãi tính trên dư nợ đầu tháng)
            double interest = currentBalance * rMonth;
            double principalPaid = monthlyPayment - interest;
            currentBalance -= principalPaid;

            if (currentBalance < 0)
                currentBalance = 0;

            // Kiểm tra điều kiện (Dùng sai số 1e-9 để tránh lỗi double)
            if (currentValue - currentBalance >= target - 1e-9) {
                System.out.println(month + " 0");
                return;
            }
        }

        // 5. Nếu hết n tháng vẫn không đủ tiền
        double gap = target - (currentValue - currentBalance);
        if (gap < 0)
            gap = 0;

        // In tháng n và số tiền thiếu (làm tròn lên số nguyên)
        System.out.println(n + " " + (long) Math.ceil(gap - 1e-9));

        sc.close();
    }
}