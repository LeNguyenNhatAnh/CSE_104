import java.util.Scanner;

public class EIUCUBES2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int k = sc.nextInt();

        for (int i = 0; i < k; i++) {
            long n = sc.nextLong();

            long minOfLayer = 1;
            long maxOfLayer = 2_000_000; // căn3 (10^18)
            long mid = 0;

            while (minOfLayer <= maxOfLayer) {
                mid = (minOfLayer + maxOfLayer) / 2;
                long numOfbricks = mid * (mid + 1) * (mid + 2) / 6;
                if (numOfbricks > n)
                    maxOfLayer = mid - 1;
                else
                    minOfLayer = mid + 1;
            }

            System.out.print(maxOfLayer + " ");
        }
        sc.close();
    }
}
