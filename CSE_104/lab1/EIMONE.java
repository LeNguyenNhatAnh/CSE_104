import java.util.Scanner;

public class EIMONE {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        final int[] DENOMINATIONS = { 20, 10, 5, 1 };

        int money = sc.nextInt();
        /*
        int temp = 0;
        if(money>=20){
            temp = money/20;
            System.out.println("20 " + temp);
            money = money - 20*temp;
        }
        if(money>=10){
            temp = money/10;
            System.out.println("10 " + temp);
            money = money - 10*temp;
        }
        if(money>=5){
            temp = money/5;
            System.out.println("5 " + temp);
            money = money - 5*temp;
        }
        if(money>=1){
            temp = money/1;
            System.out.println("1 " + temp);
            money = money - 1*temp;
        }
         */

        for (int i = 0; i < DENOMINATIONS.length; i++) {
            if (money >= DENOMINATIONS[i]) {
                int temp = money / DENOMINATIONS[i];
                System.out.println(DENOMINATIONS[i] + " " + temp);
                money -= DENOMINATIONS[i] * temp;
            }
            
        }
        sc.close();
    }

}
