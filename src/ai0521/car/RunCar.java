package ai0521.car;

public class RunCar {
    public static void main(String[] args) {
        Car sonata = new Car("현대자동차", "소나타", 1600, 40000000, "은색");
        System.out.println("========== 자동차 정보 ==========");

        System.out.printf("제조사: %s, 기종: %s, 배기량: %dcc, 색상: %s, 가격: %d원\n\n", sonata.getProduct(), sonata.getName(), sonata.getDisplacement(), sonata.getColor(), sonata.getPrice());

        sonata.setName("그랜저");
        
        System.out.println("제조사: " + sonata.getProduct());
        System.out.println("자동차 모델: " + sonata.getName());
        System.out.println("자동차 배기량: " + sonata.getDisplacement());
        System.out.println("자동차 색상: " + sonata.getColor());
        System.out.println("자동차 가격: " + sonata.getPrice());
        System.out.println();

        sonata.startOn();
        sonata.startOff();
        sonata.drive();
        sonata.forward();
        sonata.rotate("좌회전");
        sonata.drive();
        System.out.println();
        
        Car ev6 = new Car();
        ev6.setProduct("기아자동차");
        ev6.setName("ev6");
        ev6.setDisplacement(2000);
        ev6.setColor("파랑");
        ev6.setPrice(50000000);

        System.out.println("제조사: " + ev6.getProduct());
        System.out.println("자동차 모델: " + ev6.getName());
        System.out.println("자동차 배기량: " + ev6.getDisplacement());
        System.out.println("자동차 색상: " + ev6.getColor());
        System.out.println("자동차 가격: " + ev6.getPrice());
        System.out.println();
    }
}
