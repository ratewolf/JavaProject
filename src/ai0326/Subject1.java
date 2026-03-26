package ai0326;
import java.util.Scanner;
import java.util.Calendar;

public class Subject1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Calendar calendar = Calendar.getInstance();

        System.out.print("출생년도를 입력하세요: ");
        int birthYear = scanner.nextInt();
        int curYear = calendar.get(Calendar.YEAR);
        int age = curYear - birthYear;

        System.out.println("당신의 현재 나이는 " + age + "세 입니다.");
        scanner.close();
    }
}
