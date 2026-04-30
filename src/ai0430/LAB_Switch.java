package ai0430;

import java.util.Scanner;

public class LAB_Switch {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("========= 출생년도에 따른 십이간지 출력 =========");
        System.out.print("* 출생년도 입력: ");
        int birthYear = scanner.nextInt();
        String result = "";

        switch (birthYear % 12) {
            case 0:
                result = "원숭이";
                break;
            case 1:
                result = "닭";
                break;
            case 2:
                result = "개";
                break;
            case 3:
                result = "돼지";
                break;
            case 4:
                result = "쥐";
                break;
            case 5:
                result = "소";
                break;
            case 6:
                result = "호랑이";
                break;
            case 7:
                result = "토끼";
                break;
            case 8:
                result = "용";
                break;
            case 9:
                result = "뱀";
                break;
            case 10:
                result = "말";
                break;
            case 11:
                result = "양";
                break;
            default:
                result = "계산할 수 없는 띠";
                break;
        }

        System.out.printf("출생년도 %d년, 당신의 십이간지는 %s입니다.\n", birthYear, result);

        scanner.close();
    }
}
