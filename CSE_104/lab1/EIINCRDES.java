import java.util.Scanner;

public class EIINCRDES {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        boolean increase = true;
        boolean decrease = true;
        for (int i = 1; i < n; i++) {
            if (arr[i] <= arr[i - 1])
                increase = false;
            if (arr[i] >= arr[i - 1])
                decrease = false;
        }

        if (increase)
            System.out.println("increasing");
        else if (decrease)
            System.out.println("decreasing");
        else
            System.out.println("none");
        sc.close();
    }
}