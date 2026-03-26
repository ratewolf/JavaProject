package ai0326;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class ScannerTest2 {
    public static void main(String[] args) throws FileNotFoundException {
        System.out.println(new File(".").getAbsolutePath());
        Scanner scanner = new Scanner(new File("src/ai0326/test.txt"));
        var input = scanner.next();
        System.out.println(input);
        scanner.close();
    }
}
