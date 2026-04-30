package ai0430;

public class ForTest3 {
    public static void main(String[] args) {
        int hap = 0;
        final int LENGTH = 10;

        for (int i = 1; i <= LENGTH; i++) {
            if (i == LENGTH) {
                System.out.print(i + " = ");
            }
            else {
                System.out.print(i + " + ");
            }
            hap += i;
        }

        System.out.println(hap);
    }
}
