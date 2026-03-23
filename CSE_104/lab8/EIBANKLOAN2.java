import java.util.Scanner;

class EIBANKLOAN2 {
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        double X = sc.nextDouble();
        double Y = sc.nextDouble();
        double r = sc.nextDouble();

        double monthlyRate = r / 100.0 / 12.0;
        double loan = X;
        long month = 0;

        while (loan > 0) {
            month++;
            loan += loan * monthlyRate;
            loan -= Y;
        }

        System.out.println(month);
    }
}
