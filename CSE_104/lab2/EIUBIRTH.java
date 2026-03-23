import java.util.Scanner;

public class EIUBIRTH {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int testcase = sc.nextInt();
        while (testcase-- > 0) {
            long numOfBlue = sc.nextLong();
            long numOfRed = sc.nextLong();
            long bluePrice = sc.nextLong();
            long redPrice = sc.nextLong();
            long change = sc.nextLong();

            long blueCost = Math.min(bluePrice, redPrice + change);
            long redCost = Math.min(redPrice, bluePrice + change);

            long total = numOfBlue * blueCost + numOfRed * redCost;

            System.out.println(total);
        }
        sc.close();
    }
}
