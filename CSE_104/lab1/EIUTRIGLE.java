import java.util.Scanner;

public class EIUTRIGLE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        int[] arr = new int[testcase];
        for (int i = 0; i < testcase; i++) {
            arr[i] = sc.nextInt();
        }

        for (int i = 0; i < testcase - 1; i++) {
            int min = i;
            for (int j = i + 1; j < testcase; j++) {
                if (arr[j] < arr[min])
                    min = j;
            }
            int temp = arr[i];
            arr[i] = arr[min];
            arr[min] = temp;
        }

        long count = 0;
        for (int k = testcase - 1; k >= 2; k--) {
            int i = 0;
            int j = k - 1;
            while (i < j) {
                if (arr[i] + arr[j] > arr[k]) {
                    count += (j - i);
                    j--;
                } else
                    i++;
            }
        }
        System.out.println(count);
        sc.close();
    }

}
