package ai0618.array;

import java.util.Arrays;
import java.util.Scanner;

public class ArrayTest1 {
    public static void main(String[] args) {
        // 5개의 성적을 입력받아서 저장할 수 있는 1차원 배열 객체를 생성
        int[] scores = new int[5];
        String[] subjects = {"프로그래밍언어실습", "데이터베이스", "융합UI실습", "인공지능개론", "직업과경력개발"};

        // 콘솔창에서 키보드로 입력한 성적을 가져와서 배열에 저장
        Scanner scanner = new Scanner(System.in);

        for (int i = 0; i < scores.length; i++) {
            // [입력]받아서 저장하는 반복문
            System.out.printf("- %s 과목의 성적 입력(정수값): ", subjects[i]);
            scores[i] = scanner.nextInt();
        }

        for (int i = 0; i < scores.length; i++) {
            // [출력]하는 반복문
            System.out.printf("%s 과목의 점수: %d  ", subjects[i], scores[i]);
        }
        System.out.println();
        System.out.printf("점수 총합: %d", Arrays.stream(scores).sum());

        System.out.println();
        System.out.println();

        int sum = 0;
        System.out.print("세부성적: ");
//        for (int i = 0; i < scores.length; i++) {
//            System.out.print(scores[i] + " ");
//            sum += scores[i];
//        }

        // enhanced for문(foreach문)
        int i = 0;
        for (int score : scores) {
            System.out.print(subjects[i] + ":" + score + " ");
            sum += score;
            i++;
        }

        System.out.println();
        System.out.println("합계: " + sum);
        System.out.println("평균: " + sum / (double)scores.length);

        scanner.close();
    }
}
