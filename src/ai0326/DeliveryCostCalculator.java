package ai0326;

import java.util.Scanner;

class DeliveryInfo {
    private String name;
    private String address;
    private int weightG;

    public DeliveryInfo(String name, String address, int weightG) {
        this.name = name;
        this.address = address;
        this.weightG = weightG;
    }

    public int weightPerCost() {
        return weightG * 5;
    }

    public String getName() {
        return name;
    }

    public String getAddress() {
        return address;
    }

    public int getWeightG() {
        return weightG;
    }
}

public class DeliveryCostCalculator {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========== 택배 보내기 =========== \n");
        System.out.print("* 받는 사람 입력 : ");
        String name = scanner.nextLine();

        System.out.print("* 주소 입력 : ");
        String address = scanner.nextLine();

        System.out.print("* 수하물 무게(단위: g, 형식: 정수) 입력 : ");
        int weightG = Integer.parseInt(scanner.nextLine());

        DeliveryInfo deliveryInfo = new DeliveryInfo(name, address, weightG);

        System.out.println();

        System.out.printf("** 받는 사람 ==> %s\n", deliveryInfo.getName());
        System.out.printf("** 주소 ==> %s\n", deliveryInfo.getAddress());
        System.out.printf("** 수하물 무게 ==> %sg\n", deliveryInfo.getWeightG());
        System.out.printf("** 배송비 ==> %d\n", deliveryInfo.weightPerCost());
    }
}
