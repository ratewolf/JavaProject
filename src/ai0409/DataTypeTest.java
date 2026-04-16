package ai0409;

import javax.sound.midi.SoundbankResource;

// 기본자료형(1. 숫자형, 2. 숫자가 아닌형)
public class DataTypeTest {
    public static void main(String[] args) {
        // 1. 숫자형: 정수형
        byte bt = -128;
        short st = 300;
        st = bt;
        int it = st;
        System.out.println("it 변수에 저장된 값: " + it);
        long lg = 70000000;
        // 1. 숫자형: 실수형
        float f1 = 1000;
        f1 = lg;
        f1 = 1000.0f;
        f1 = 1000.0F;
        f1 = (float) 1000.0;

        double d1 = 20000;
        d1 = f1;
        d1 = bt;
        d1 = 207.999;

        System.out.printf("%4.2f\n", d1);

        // 2. 숫자가 아닌형: 문자형
        char c = 'a';
        System.out.println(c+1); // c = c + 1은 안 된다.
        System.out.println(c);
        System.out.println((int)c);
        System.out.println((char)(c+1)); // unicode 값을 연산할 수 있다. (자바는 unicode 기준)

        // 2. 숫자가 아닌형: 논리형
        boolean b = true;
        System.out.println(b);
        System.out.println(!b);
        System.out.println(bt == st);
    }
}
