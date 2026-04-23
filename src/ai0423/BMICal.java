package ai0423;

import java.util.Scanner;

class BMI {
    private final double heightCm;
    private final double weightKg;

    public BMI(double heightCm, double weightKg) {
        this.heightCm = heightCm;
        this.weightKg = weightKg;
    }

    public double centimeterToMeter() {
        return heightCm / 100.0;
    }

    public double calculateBMI() {
        double meter = centimeterToMeter();
        return weightKg / Math.pow(meter, 2.0);
    }

    public static String getCategory(double bmi) {
        if (bmi < 18.5) {
            return "저체중";
        } else if (bmi < 23.0) {
            return "정상";
        } else if (bmi < 25.0) {
            return "과체중";
        } else if (bmi < 30.0) {
            return "비만";
        } else {
            return "고도비만";
        }
    }
}

public class BMICal {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========== BMI (Body Index Mass) =========== \n");

        System.out.print("이름(문자열)을 입력해주세요: ");
        String name = scanner.nextLine();

        System.out.print("키(cm, 실수값)와 체중(kg, 실수값)을 입력해주세요: ");

        double height = scanner.nextDouble();
        double weight = scanner.nextDouble();

        if (height <= 0 || weight <= 0) {
            System.out.println("잘못된 입력입니다.");
            return;
        }

        BMI userBMI = new BMI(height, weight);
        double bmi = userBMI.calculateBMI();
        System.out.printf("%s님의 BMI 지수 결과: %.2fkg/㎡ (%s)", name, bmi, BMI.getCategory(bmi));

        scanner.close();
    }
}
