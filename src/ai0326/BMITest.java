package ai0326;

import java.util.Scanner;

public class BMITest {
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);
        Scanner s1 = new Scanner(System.in); // 입력 버퍼 문제로 Scanner 두 개 사용

        System.out.println("=========== BMI (Body Index Mass) =========== \n");

        System.out.print("* 체중(kg, 실수값) 입력:");
        double weight = s.nextDouble();

        System.out.print("* 키(cm, 실수값) 입력:");
        double height = s.nextDouble();

        System.out.print("* 성명 입력:");
        String name = s1.nextLine();

        double bmi = weight / Math.pow(height/100, 2);

        System.out.printf("* %s님의 BMI 지수 결과: %.2fkg/㎡", name, bmi);

        s.close();
        s1.close();
    }
}
