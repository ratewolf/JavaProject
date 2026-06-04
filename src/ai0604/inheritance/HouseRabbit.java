package ai0604.inheritance;

// 상속은 자원(필드와 메소드)을 확장해서 사용하는 것을 의미한다.
public class HouseRabbit extends Rabbit {
    // 주인 이름
    String masterName;

    // 사료 먹기
    public void eatFeed(String feedName) {
        System.out.println("집토끼가 " + masterName +" 주인이 주는 " + feedName + " 사료를 먹는다.");
    }

    // 메소드 오버라이딩(재정의): super 클래스에 정의된 메소드를 sub 클래스에서 다시 정의하는 것

    // 토끼의 x좌표가 울타리의 좌측 끝(0)을 벗어나지 않고 10씩 감소하게
    @Override
    public void moveLeft(int times) {
        if (xPos > 10 * times) {
            super.moveLeft(times);
        } else {
            xPos = 0;
        }
    }

    // 토끼의 x좌표가 울타리의 우측 끝(500)을 벗어나지 않고 10씩 증가하게
    @Override
    public void moveRight(int times) {
        if (xPos + 10 * times < 500) {
            super.moveRight(times);
        } else {
            xPos = 500;
        }
    }
}
