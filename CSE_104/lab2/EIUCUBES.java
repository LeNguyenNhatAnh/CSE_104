import java.util.Scanner;

public class EIUCUBES {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int nBricks = sc.nextInt();
        int layer = 1;
        while (nBricks >= layer * (layer + 1) / 2) {
            nBricks -= layer * (layer + 1) / 2;
            layer++;
        }
        System.out.println(layer - 1);
        sc.close();
    }
}
