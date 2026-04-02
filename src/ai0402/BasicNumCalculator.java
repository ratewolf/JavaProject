package ai0402;

import java.util.Scanner;

class PublicBasicOperations {
    private final int number1;
    private final int number2;

    public PublicBasicOperations(int number1, int number2) {
        this.number1 = number1;
        this.number2 = number2;
    }

    public int addition() {
        return number1 + number2;
    }

    public int subtraction() {
        return number1 - number2;
    }

    public int multiplication() {
        return number1 * number2;
    }

    public double division() {
        if (number2 == 0) {
            return -1.0;
        }
        return (double) number1 / number2;
    }

    public int remain() {
        if (number2 == 0) {
            return -1;
        }
        return number1 % number2;
    }
}

public class BasicNumCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========== 간단한 사칙연산 계산기 =========== \n");

        System.out.print("정수1 입력 ===> ");
        int number1 = scanner.nextInt();

        System.out.print("정수2 입력 ===> ");
        int number2 = scanner.nextInt();

        if (number2 == 0) {
            System.out.println("0으로 나누기는 불가능하므로 나눗셈과 나머지 결과는 -1로 반환합니다.");
        }

        PublicBasicOperations calculator = new PublicBasicOperations(number1, number2);

        System.out.printf("%d + %d = %d\n", number1, number2, calculator.addition());
        System.out.printf("%d - %d = %d\n", number1, number2, calculator.subtraction());
        System.out.printf("%d × %d = %d\n", number1, number2, calculator.multiplication());
        System.out.printf("%d ÷ %d = %.2f\n", number1, number2, calculator.division());
        System.out.printf("%d %% %d = %d\n", number1, number2, calculator.remain());

//        교수님은 아직 우리가 클래스를 안 배웠고, 간단한 예제인만큼 다음과 같이 작성하셨습니다.
//        System.out.println();
//
//        System.out.printf("%d + %d = %d\n", number1, number2, number1 + number2);
//        System.out.printf("%d - %d = %d\n", number1, number2, number1 - number2);
//        System.out.printf("%d × %d = %d\n", number1, number2, number1 * number2);
//        System.out.printf("%d ÷ %d = %.2f\n", number1, number2, number2 == 0 ? -1.0 : (double) number1 / number2);
//        System.out.printf("%d %% %d = %d\n", number1, number2, number2 == 0 ? -1 : number1 % number2);

        scanner.close();
    }
}
