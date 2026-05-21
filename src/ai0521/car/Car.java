package ai0521.car;

public class Car {
    // 메소드 바깥쪽에 선언된 변수: 필드
    private String product; // 자동차 제조사
    private String name; // 자동차 이름
    private int displacement; // 자동차 배기량
    private int price; // 자동차 가격
    private String color; // 자동차 색상

    // 생성자: 객체를 생성할 때 사용
    // 생성자의 역할: 객체가 생성될 때 필드의 값을 초기화
    // 기본 생성자(default constructor): 객체만 생성하고 필드의 값을 초기화시키지 않는다.

    // 기본 생성자
    public Car() {
    }


    public Car(String product, String name, int displacement, int price, String color) {
        this.product = product;
        this.name = name;
        this.displacement = displacement;
        this.price = price;
        this.color = color;
    }

    public String getProduct() {
        return product;
    }

    // getter 메소드: 필드에 저장된 값을 반환
    // setter 메소드: 필드에 값을 설정(저장)

    public void setProduct(String product) {
        this.product = product;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getDisplacement() {
        return displacement;
    }

    public void setDisplacement(int displacement) {
        this.displacement = displacement;
    }

    public int getPrice() {
        return price;
    }

    public void setPrice(int price) {
        this.price = price;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    // Car의 기능에 해당하는 메소드
    public void startOn() {
        System.out.println(name + " 자동차의 시동을 건다.");
    }

    public void startOff() {
        System.out.println(name + " 자동차의 시동을 끈다.");
    }

    public void drive() {
        System.out.println(name + " 자동차가 주행을 시작한다.");
    }

    public void stop() {
        System.out.println(name + " 자동차가 주행을 멈춘다.");
    }

    public void forward() {
        System.out.println(name + " 자동차가 전진한다.");
    }

    public void backward() {
        System.out.println(name + " 자동차가 후진한다.");
    }

    public void rotate(String direction) {
        System.out.println(name + " 자동차가 " + direction + "한다.");
    }
}
