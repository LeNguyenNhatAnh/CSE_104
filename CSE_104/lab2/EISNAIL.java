import java.util.Scanner;

public class EISNAIL {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        long climb = sc.nextLong();
        long slide = sc.nextLong();
        long height = sc.nextLong();

        int result = (int) (1 + Math.ceil((double) (height - climb) / (climb - slide)));
        System.out.println(result);
        sc.close();
    }
}
