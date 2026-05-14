package ai0514;

import java.util.Random;
import java.util.Scanner;

public class NumberAdjustGame {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Random random = new Random();
        int count = 1;
        int num = 0;
        while (true) {
            int dice1 = random.nextInt(5) + 1;
            System.out.print("게임 " + count + "회: 컴퓨터가 생각한 숫자는 무엇일까요? ");
            num = scanner.nextInt();

            if (dice1 == num) {
                System.out.println("정답입니다!");
                System.out.println("같은 숫자가 나올 때까지 " + count + "회 시도하셨습니다.");
                break;
            }

            System.out.println("아까워요. " + dice1 + "였는데, 다시 도전해보세요.");
            count++;
        }

        System.out.println("게임을 마칩니다.");
        scanner.close();
    }
}
