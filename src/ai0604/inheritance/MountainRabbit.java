package ai0604.inheritance;

public class MountainRabbit extends Rabbit {
    // 산 이름
    String mountainName;

    // 풀 먹기
    public void eatGrass(String grassName) {
        System.out.println("산토끼가 " + mountainName +" 산에 있는 " + grassName + " 풀을 먹는다.");
    }
}
