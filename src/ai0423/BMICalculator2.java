package ai0423;

import java.util.Scanner;

public class BMICalculator2 {
    public static class Person {
        private final String name;
        private final double heightCm;
        private final double weightKg;

        Person(String name, double heightCm, double weightKg) {
            this.name = name;
            this.heightCm = heightCm;
            this.weightKg = weightKg;
        }

        public String getName() { return name; }
        public double getHeightCm() { return heightCm; }
        public double getWeightKg() { return weightKg; }
    }

    public static class BMIService {
        public double calculate(Person person) {
            final double heightM = centimeterToMeter(person.getHeightCm());
            return person.getWeightKg() / Math.pow(heightM, 2);
        }
        public BMICategory getCategory(double bmi) {
            if (bmi < BMICategory.UNDERWEIGHT.maxValue) {
                return BMICategory.UNDERWEIGHT;
            } else if (bmi < BMICategory.NORMALWEIGHT.maxValue) {
                return BMICategory.NORMALWEIGHT;
            } else if (bmi < BMICategory.OVERWEIGHT.maxValue) {
                return BMICategory.OVERWEIGHT;
            } else if (bmi < BMICategory.OBESITY.maxValue) {
                return BMICategory.OBESITY;
            } else {
                return BMICategory.SEVEREOBESITY;
            }
        }
        private double centimeterToMeter(double heightCm) {
            return heightCm / 100.0;
        }
    }

    public enum BMICategory {
        UNDERWEIGHT("저체중", 0, 18.5),
        NORMALWEIGHT("정상체중", 18.5, 23.0),
        OVERWEIGHT("과체중", 23.0, 25.0),
        OBESITY("비만", 25.0, 30.0),
        SEVEREOBESITY("고도비만", 30.0, Double.MAX_VALUE);

        private final String categoryName;
        private final double minValue;
        private final double maxValue;

        BMICategory(String categoryName, double minValue, double maxValue) {
            this.categoryName = categoryName;
            this.minValue = minValue;
            this.maxValue = maxValue;
        }

        public String getCategoryName() { return categoryName; }
        public double getMinValue() { return minValue; }
        public double getMaxValue() { return maxValue; }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.printf("=========== BMI (Body Index Mass) =========== \n\n");

        System.out.printf("이름(문자열)을 입력해주세요: ");
        String name = scanner.nextLine();

        System.out.printf("키(cm, 실수값)와 체중(kg, 실수값)을 입력해주세요: ");
        double heightCm = scanner.nextDouble();
        double weightKg = scanner.nextDouble();

        Person person = new Person(name, heightCm, weightKg);
        BMIService bmiService = new BMIService();

        double bmi = bmiService.calculate(person);
        System.out.printf("%s님의 BMI 지수 결과: %.2fkg/㎡ (%s)", name, bmi, bmiService.getCategory(bmi).getCategoryName());

        scanner.close();
    }
}
