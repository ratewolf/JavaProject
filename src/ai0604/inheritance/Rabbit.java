package ai0604.inheritance;

public class Rabbit {
    // super 클래스의 필도 또는 메소드 앞에 private를 붙이면 sub 클래스의 사용이 제한된다.
    String shape;
    int xPos;
    int yPos;

    public Rabbit() {
    }

    public Rabbit(String shape) {
        this.shape = shape;
    }

    public void setLocation(int xPos, int yPos) {
        this.xPos = xPos;
        this.yPos = yPos;
    }

    // x축으로 10씩 오른쪽으로 이동하는 메소드
    public void moveRight(int times) {
        for (int i = 0; i < times; i++) {
            xPos += 10;
        }
    }

    // x축으로 10씩 오른쪽으로 이동하는 메소드
    public void moveLeft(int times) {
        for (int i = 0; i < times; i++) {
            xPos -= 10;
        }
    }

    // y축으로 10씩 위쪽으로 이동하는 메소드
    public void moveUp(int times) {
        for (int i = 0; i < times; i++) {
            yPos += 10;
        }
    }

    // y축으로 10씩 아래쪽으로 이동하는 메소드
    public void moveDown(int times) {
        for (int i = 0; i < times; i++) {
            yPos -= 10;
        }
    }

    public void printInfo() {
        System.out.printf("%s 모양의 토끼는 (%d, %d) 좌표에 위치하고 있다.\n", shape, xPos, yPos);
    }
}
