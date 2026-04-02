package ai0402;

import java.util.Scanner;

public class PoundKgInterconversion {
    private static final double FACTOR_POUNDS_TO_KILOGRAMS = 0.453592;
    private static final double FACTOR_KILOGRAMS_TO_POUNDS = 2.204623;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("파운드(lb)를 입력하세요: ");
        double pound = scanner.nextDouble();
        System.out.printf("%.1f파운드(lb)는 %.3f킬로그램(kg)입니다.\n", pound, poundToKg(pound));

        System.out.print("킬로그램(kg)을 입력하세요: ");
        double kg = scanner.nextDouble();
        System.out.printf("%.1f킬로그램(kg)은 %.3f파운드(lb)입니다.\n", kg, kgToPound(kg));

        scanner.close();
    }

    public static double poundToKg(double pound) {
        return pound * FACTOR_POUNDS_TO_KILOGRAMS;
    }

    public static double kgToPound(double kg) {
        return kg * FACTOR_KILOGRAMS_TO_POUNDS;
    }
}
