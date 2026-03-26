package ai0326;

import java.util.Scanner;
// import java.lang.* API는 생략 가능하다.

public class ScannerTest1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("좋아하는 정수값을 입력하세요: ");
        var num1 = scanner.nextInt();
        System.out.println("입력한 숫자는 " + num1 + "입니다");
        scanner.close();
    }
}
