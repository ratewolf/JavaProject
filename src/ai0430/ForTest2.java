package ai0430;

public class ForTest2 {
    public static void main(String[] args) {
        final int OUTPUT_NUMBERS = 100;
        final int OUTPUT_FORMAT = 20;

        for (int i = 1; i <= OUTPUT_NUMBERS; i++) {
            System.out.printf("%3d ", i);

            if (i % OUTPUT_FORMAT == 0) {
                System.out.println();
            }
        }
    }
}
