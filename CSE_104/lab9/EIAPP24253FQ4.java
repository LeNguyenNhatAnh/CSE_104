import java.util.Scanner;

public class EIAPP24253FQ4 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        if (!sc.hasNextInt())
            return;
        int nTotal = sc.nextInt();
        double p0 = sc.nextDouble();
        double cRate = sc.nextDouble();

        double[] fRates = new double[8];
        for (int i = 0; i < 8; i++)
            fRates[i] = sc.nextDouble();

        double[] rRates = new double[8];
        for (int i = 0; i < 8; i++)
            rRates[i] = sc.nextDouble();

        // Binary Search tìm X
        double low = 0;
        double high = 1e16; // Phù hợp với mệnh giá VND lớn

        for (int i = 0; i < 100; i++) {
            double midX = (low + high) / 2.0;
            if (canBuyAndPayOff(midX, nTotal, p0, cRate, fRates, rRates)) {
                high = midX;
            } else {
                low = midX;
            }
        }

        // Làm tròn đến số nguyên gần nhất (nearest integer)
        System.out.println(Math.round(high));
        sc.close();
    }

    private static boolean canBuyAndPayOff(double x, int nTotal, double p0, double c, double[] f, double[] r) {
        double currentSaving = 0;
        double currentHousePrice = p0;
        int monthOfPurchase = -1;
        double priceAtPurchase = 0;

        // Giai đoạn 1: Tích lũy tiết kiệm
        for (int t = 1; t <= nTotal; t++) {
            int period = (t - 1) / 60;

            // Gửi tiền đầu tháng
            currentSaving += x;

            // Kiểm tra điều kiện mua nhà 30%
            if (currentSaving >= currentHousePrice * 0.3) {
                monthOfPurchase = t;
                priceAtPurchase = currentHousePrice;
                break;
            }

            // Nếu chưa đủ, cuối tháng mới sinh lãi và tăng giá nhà
            currentSaving *= (1 + r[period]);
            currentHousePrice *= (1 + f[period]);
        }

        // Nếu không đủ tiền cọc trong N tháng
        if (monthOfPurchase == -1)
            return false;

        // Giai đoạn 2: Trả nợ khoản vay 70%
        double remainingLoan = priceAtPurchase * 0.7;
        int monthsLeft = nTotal - monthOfPurchase;

        for (int t = 1; t <= monthsLeft; t++) {
            // Lãi tính trên dư nợ cũ, sau đó trừ khoản trả x
            remainingLoan = remainingLoan * (1 + c) - x;
            if (remainingLoan <= 0)
                return true;
        }

        return remainingLoan <= 0;
    }
}