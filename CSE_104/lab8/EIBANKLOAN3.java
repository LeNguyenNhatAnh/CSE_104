import java.util.Scanner;

public class EIBANKLOAN3 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextDouble())
            return;
        double x = sc.nextDouble(); // 1200
        double y = sc.nextDouble(); // 300
        int n = sc.nextInt(); // 12
        double rPercent = sc.nextDouble(); // 12
        double fPercent = sc.nextDouble(); // 1

        double monthlyRate = rPercent / 1200.0;
        double penaltyRate = fPercent / 100.0;

        double balance = x;
        double totalPrincipalPaid = 0; // Tổng gốc đã trả thực tế
        double fixedMandatoryPerMonth = x / n; // 100

        int month = 1;

        while (balance > 1e-9) {
            double interest = balance * monthlyRate;
            double availableForPrincipal = y - interest;

            // Tổng gốc bắt buộc phải đạt được tính đến hết tháng này
            double requiredTotalPrincipal = month * fixedMandatoryPerMonth;

            // Số tiền gốc còn thiếu để đạt mức bắt buộc tháng này
            double amountToReachMandatory = requiredTotalPrincipal - totalPrincipalPaid;

            double actualReduction = 0;

            if (availableForPrincipal <= amountToReachMandatory) {
                // Trả không quá mức tích lũy -> Không phạt
                actualReduction = availableForPrincipal;
            } else {
                // Trả vượt mức tích lũy -> Phần vượt bị phạt
                double excess = availableForPrincipal - Math.max(0, amountToReachMandatory);
                double extraPrincipal = excess / (1.0 + penaltyRate);
                actualReduction = Math.max(0, amountToReachMandatory) + extraPrincipal;
            }

            // Cập nhật
            if (actualReduction >= balance) {
                actualReduction = balance;
                balance = 0;
            } else {
                balance -= actualReduction;
            }

            totalPrincipalPaid += actualReduction;

            System.out.println(month + " " + Math.round(balance));

            month++;
            if (balance <= 0)
                break;
        }
        sc.close();
    }
}