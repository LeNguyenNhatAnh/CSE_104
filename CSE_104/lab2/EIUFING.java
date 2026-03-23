import java.util.Scanner;

public class EIUFING {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long n = sc.nextLong();
        String[] fingers = new String[] { "cai", "tro", "giua", "ap ut", "ut" };
        String[] hands = new String[] { "trai", "phai" };
        int result = (int) (n % 18);
        if (result == 0)
            result = 18;
        if (result > 10)
            result = 20 - result;

        int handIndex;
        if (result > 5) {
            handIndex = 1;
            result = 11 - result;
        } else
            handIndex = 0;

        System.out.println("Ngon " + fingers[result - 1] + " cua ban tay " + hands[handIndex]);
        sc.close();
    }
}
