package ai0430;

import java.util.Scanner;

public class LAB_SetLine {
    public static void main(String[] args) {
        int fact = 1;
        Scanner scanner = new Scanner(System.in);

        System.out.printf("========== 학생들 줄 세우기(팩토리얼 계산하기) ==========\n");
        System.out.print(" * 몇 명의 학생을 줄 세울지 입력하세요: ");
        int friends_num = scanner.nextInt();

        for (int i = 1; i <= friends_num; i++) {
            fact = fact * i;
        }

        System.out.printf("%d명의 학생들을 순서대로 세우는 경우의 수: %d", friends_num, fact);
    }
}
