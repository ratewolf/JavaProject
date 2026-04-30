package ai0430;

import java.util.Scanner;

public class SwitchTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("* 1 - 10 사이의 정수를 입력하시오: ");
        int num = scanner.nextInt();
        String result = "";

        switch (num)
        {
            case 1:
            case 3:
            case 5:
            case 7:
            case 9:
                result = "홀수";
                break;
            case 2:
            case 4:
            case 6:
            case 8:
            case 10:
                result = "짝수";
                break;
            default:
                result = "범위를 넘어간 수";
                break;
        }

        System.out.printf("입력된 숫자 %d은(는) %s입니다.\n", num, result);

        scanner.close();
    }
}
