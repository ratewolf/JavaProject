package ai0423;

import java.util.Scanner;

public class PCRoomAccess {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        final int age;

        System.out.print("나이 입력 ==> ");
        age = scanner.nextInt();

        if (age >= 19)
        {
            System.out.println("즐거운 시간 보내세요.");
        }
        else
        {
            System.out.println("이용 불가입니다. 돌아가주세요.");
        }

        System.out.println("협조 감사드립니다.");
    }
}
