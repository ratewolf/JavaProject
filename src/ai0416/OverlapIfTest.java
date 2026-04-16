package ai0416;

import java.util.Scanner;

public class OverlapIfTest {
    public static void main(String[] args) {
        System.out.println("===== 특정 범위 숫자 판별 프로그램 =====");
        Scanner scanner = new Scanner(System.in);

        System.out.print("* 정수를 입력: ");
        int num = scanner.nextInt();

        if (num > 100)
        {
            if (num < 1000)
                System.out.printf("%d는 100보다 크고 1000보다 작은 숫자입니다.\n", num);
            else
                System.out.printf("%d는 1000보다 큰 숫자입니다.\n", num);
        }
        else
        {
            System.out.printf("%d는 100보다 작은 숫자입니다.\n", num);
        }

        scanner.close();
    }
}
