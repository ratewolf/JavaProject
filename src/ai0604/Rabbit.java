package ai0604;

public class Rabbit {
    private String shape;
    private int xPos;
    private int yPos;
    public static int count;

    // JVM은 클래스 내에 생성자가 하나도 없는 경우 기본 생성자를 만들어서 사용한다.
    // 그러나 클래스 내에 생성자가 하나라도 선언되어 있다면, 선언된 생성자만 사용할 수 있다.
    public Rabbit() {
        count++;
    }

    public Rabbit(String shape) {
        this.shape = shape;
    }

    // getter(필드값 반환), setter(필드값 설정)
    public String getShape() {
        return shape;
    }

    public void setShape(String shape) {
        this.shape = shape;
    }

    public int getxPos() {
        return xPos;
    }

    public void setxPos(int xPos) {
        this.xPos = xPos;
    }

    public int getyPos() {
        return yPos;
    }

    public void setyPos(int yPos) {
        this.yPos = yPos;
    }

    // 토끼의 좌표(위치)값을 설정하는 메소드 구현
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