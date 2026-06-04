package ai0604.inheritance;

public class RunRabbit {
    public static void main(String[] args) {
        HouseRabbit houseRabbit1 = new HouseRabbit();
        houseRabbit1.shape = "동그라미";
        houseRabbit1.setLocation(30, 50);
        houseRabbit1.moveRight(100);
        houseRabbit1.printInfo();
        houseRabbit1.masterName = "폴리";
        houseRabbit1.eatFeed("아주 좋은");

        MountainRabbit mountainRabbit1 = new MountainRabbit();
        mountainRabbit1.shape = "세모";
        mountainRabbit1.setLocation(100, 80);
        mountainRabbit1.moveLeft(2);
        mountainRabbit1.printInfo();
        mountainRabbit1.mountainName = "남산";
        mountainRabbit1.eatGrass("클로버");
    }
}
