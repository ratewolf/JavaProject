package ai0416;

public class ReverseStiringTest {
    public static void main(String[] args) {
        final String originalStr = "블랙핑크";

        System.out.println("원본 문자열 ==> " + originalStr);
        System.out.println("반대 문자열 ==> " + originalStr.charAt(3) + originalStr.charAt(2) + originalStr.charAt(1) + originalStr.charAt(0));
    }
}
