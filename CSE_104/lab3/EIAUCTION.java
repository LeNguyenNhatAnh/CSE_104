package lab3;

import java.util.Scanner;

public class EIAUCTION {
    private static final int MAX_VALUE = 6;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        int numberOfRolls = scanner.nextInt();
        int[] rolls = new int[numberOfRolls];
        int[] frequency = new int[MAX_VALUE + 1];

        for (int i = 0; i < numberOfRolls; i++) {
            rolls[i] = scanner.nextInt();
            frequency[rolls[i]]++;
        }

        int highestUniqueValue = -1;
        for (int value = MAX_VALUE; value >= 1; value--) {
            if (frequency[value] == 1) {
                highestUniqueValue = value;
                break;
            }
        }

        if (highestUniqueValue == -1) {
            System.out.println("none");
            scanner.close();
            return;
        }

        for (int i = 0; i < numberOfRolls; i++) {
            if (rolls[i] == highestUniqueValue) {
                System.out.println(i + 1); // index starts from 1
                break;
            }
        }

        scanner.close();
    }
}