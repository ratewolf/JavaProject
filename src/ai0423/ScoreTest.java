package ai0423;

import java.util.Scanner;

public class ScoreTest {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int score;
        char grade = 'F';

        System.out.println("* 프로그래밍언어실습: ");
        System.out.print("점수 입력 ==> ");
        score = scanner.nextInt();

        if (score >= 90)
        {
            grade = 'A';
        }
        else if(score >= 80)
        {
            grade = 'B';
        }
        else if(score >= 70)
        {
            grade = 'C';
        }
        else if(score >= 60)
        {
            grade = 'D';
        }

        System.out.printf("점수는 %d점, 따라서 학점은 %c입니다.", score, grade);

        scanner.close();
    }
}
