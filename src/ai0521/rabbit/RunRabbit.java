package ai0521.rabbit;

import java.util.Scanner;

// 접근 제한 지시자: 외부에서 속성이나 메서드에 접근하도록 허용할지 여부를 지정가능. -> private, public, protected, default
public class RunRabbit {
    public static void main(String[] args) {
        Rabbit rabbit1 = new Rabbit();
        Rabbit rabbit2 = new Rabbit("좁은 네모");

        rabbit1.setLocation(50, 50);
        rabbit2.setLocation(150, 70);

        rabbit1.setShape("기본");
        rabbit1.printInfo();
        rabbit2.printInfo();

        // 기본 모양의 토끼를 다이아몬드 모양의 토끼로 변경, 위치는 현재 x좌표에서 오른쪽으로 60 이동, y좌표에서 아래쪽으로 20 이동한 후 출력
        rabbit1.setShape("다이아몬드");
        rabbit1.setxPos(rabbit1.getxPos() + 60);
        rabbit1.setyPos(rabbit1.getyPos() + 20);

        rabbit1.printInfo();

        rabbit2.printInfo();

        rabbit2.moveRight(5);
        rabbit2.printInfo();

        rabbit2.moveLeft(2);
        rabbit2.printInfo();
        System.out.println();

        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.printf("다음 작업은 위에서 정의한 두 마리의 토끼를 사용자 입력으로 직접 이동시키는 겁니다. 이동은 10단위로 됩니다. 나가시려면 토끼 선택에서 -1을 입력해주세요.\n");

            int rabbitIndex;
            int changeXValue;
            int changeYValue;

            System.out.printf("이동할 토끼 ==> ");
            rabbitIndex = scanner.nextInt();
            if (rabbitIndex == -1) {
                break;
            }

            System.out.printf("토끼가 이동할 x좌표 ==> ");
            changeXValue = scanner.nextInt();

            System.out.printf("토끼가 이동할 y좌표 ==> ");
            changeYValue = scanner.nextInt();

            if (changeXValue < 0) {
                changeXValue = changeXValue * -1;
                rabbit2.moveLeft(changeXValue);
            }
            else {
                rabbit2.moveRight(changeXValue);
            }

            if (changeYValue < 0) {
                changeYValue = changeYValue * -1;
                rabbit2.moveDown(changeYValue);
            }
            else {
                rabbit2.moveDown(changeYValue);
            }

            rabbit2.printInfo();
            System.out.println();
        }

        scanner.close();
    }
}
