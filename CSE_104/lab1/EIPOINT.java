import java.util.Scanner;

public class EIPOINT {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int score = sc.nextInt();
        final int[] SCORES = { 90, 85, 80, 75, 70, 65, 60, 55, 53, 52, 50, 0 };
        final String[] LETTERS = { "A", "A-", "B+", "B", "B-", "C+", "C", "C-", "D+", "D", "D-", "F" };

        for (int i = 0; i < SCORES.length; i++) {
            if (score >= SCORES[i]) {
                System.out.println(LETTERS[i]);
                break;
            }
        }
        sc.close();
    }
}
