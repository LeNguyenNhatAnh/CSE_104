package lab5;
import java.util.Scanner;

public class EIUPASSBOOK {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long X = sc.nextLong();
        int n = sc.nextInt(); // Kỳ hạn gửi (tháng)
        int m = sc.nextInt(); // Thời điểm muốn rút tiền (tháng)
        double r1 = sc.nextDouble(); // Lãi suất gửi (%/năm)
        double r2 = sc.nextDouble(); // Lãi suất vay (%/năm)

        // Phương án 1: Rút sớm chỉ nhận tiền gốc
        double option1 = (double) X;

        // Phương án 2: Vay thế chấp sổ tiết kiệm
        // Bước A: Tính giá trị sổ tiết kiệm khi đáo hạn tại tháng n
        // Công thức lãi đơn: Gốc * (1 + lãi suất năm * số tháng / 12)
        double passbookFinalValue = X * (1 + (r1 / 100.0) * (n / 12.0));

        // Bước B: Tính hệ số lãi vay (Factor)
        int remainingMonths = n - m; // Thời gian phải vay tiền
        int years = remainingMonths / 12; // Số năm vay chẵn
        int months = remainingMonths % 12; // Số tháng vay lẻ còn lại
        double loanRate = r2 / 100.0;

        // Công thức từ bảng trắng: (1 + r2)^year * (1 + r2 * month/12)
        double factor = Math.pow(1 + loanRate, years) * (1 + loanRate * (months / 12.0));

        // Số tiền vay được (Y) để sau này dùng sổ tiết kiệm trả nợ vừa đủ
        double option2 = passbookFinalValue / factor;

        // 2. So sánh và in ra giá trị lớn nhất, làm tròn đến đơn vị
        if (option1 > option2) {
            System.out.println(Math.round(option1));
        } else {
            System.out.println(Math.round(option2));
        }

        sc.close();
    }
}