package ai0514;

public class ContinueTest2 {
    public static void main(String[] args) {
        int sum = 0;

        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 1) {
                continue;
            }
            sum += i;
        }

        System.out.println("4의 배수를 제외한 1~100까지의 합계(짝수의 합계만): " + sum);

        sum = 0;
        for (int i = 1; i <= 100; i++) {
            if (i % 2 == 0) {
                continue;
            }
            sum += i;
        }

        System.out.println("4의 배수를 제외한 1~100까지의 합계(홀수의 합계만): " + sum);
    }
}
