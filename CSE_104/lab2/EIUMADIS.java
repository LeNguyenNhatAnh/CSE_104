import java.util.Scanner;

public class EIUMADIS {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        long[] arr = new long[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextLong();
        }

        /*80đ
        long maxDiff = Long.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            for (int j = i; j < n; j++) {
                long diff = arr[j] - arr[i];
                if (diff > maxDiff)
                maxDiff = diff;
            }
        }
        System.out.println(maxDiff);*/

        long maxDif = 0;
        long minValue = arr[0];

        for (int i = 0; i < n; i++) {
            if (minValue > arr[i])
                minValue = arr[i];

            long currentDif = arr[i] - minValue;
            if (currentDif > maxDif)
                maxDif = currentDif;
        }
        System.out.println(maxDif);
        sc.close();
    }
}
