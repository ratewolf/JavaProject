package ai0402;

import java.util.Scanner;

public class ComparisonTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("======== 운전면허 필기 시험 합격 여부 확인 ========");
        System.out.print("필기시험 점수 입력: ");

        final int score = scanner.nextInt();
        String result = ""; //empty String

        if (score >= 70) {
            result = "합격";
        }
        else {
            result = "불합격";
        }

        System.out.printf("%d점이므로 결과는 %s입니다.", score, result);

        scanner.close();
    }
}
