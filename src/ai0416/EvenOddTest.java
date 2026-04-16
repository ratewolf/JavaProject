package ai0416;

import java.util.Scanner;

public class EvenOddTest {
    public static void main(String[] args) {
        System.out.println("======== 짝수/홀수 판별 프로그램 ========");
        Scanner scanner = new Scanner(System.in);

        System.out.print("정수를 입력해주세요 ==> ");
        final int num = scanner.nextInt();
        String result = "";

        if (num % 2 == 0)
        {
            System.out.printf("%d는 짝수입니다.\n", num);
            result = "짝수";
        }
        else
        {
            System.out.printf("%d는 홀수입니다.\n", num);
            result = "홀수";
        }

        System.out.printf("입력된 정수 %d는 %s입니다.", num, result);

        scanner.close();
    }
}
