package ai0514;

import java.util.Scanner;

public class WhileTest02 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int hap = 0;
        int num1, num2;

        while (true) {
            System.out.print("숫자1 ==> ");
            num1 = scanner.nextInt();

            if (num1 == -1) {
                break;
            }

            System.out.print("숫자2 ==> ");
            num2 = scanner.nextInt();

            hap = num1 + num2;
            System.out.println(num1 + " + " + num2 + " = " + hap);
        }

        scanner.close();
    }
}
