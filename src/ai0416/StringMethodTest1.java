package ai0416;

public class StringMethodTest1 {
    public static void main(String[] args) {
        final String originalStr = new String("   한국 폴리텍  대학      서울  정수    캠퍼스   ");
        final String cutStr = originalStr.replaceAll(" ", "");
        System.out.println("원래 문자열: " + originalStr);
        System.out.println("바꾼 문자열: " + cutStr);
        System.out.println();

        final String thirdStr = "인공지능소프트웨어과 1학년";
        System.out.println("\"지능\"의 인덱스 번호: " + thirdStr.indexOf("지능"));
        System.out.println("\"웨\"의 인덱스 번호: " + thirdStr.indexOf("웨"));
        System.out.println();

        final String javaStr = "한국에는 한국 폴리텍대학이 한국 전체의 많은 곳에 캠퍼스가 위치해 있습니다.";
        System.out.println(javaStr.indexOf("한국"));
        System.out.println(javaStr.indexOf("한국", 4)); // 뒤의 4는 이 인덱스부터 탐색을 의미.
        System.out.println(javaStr.indexOf("한국", 5)); // 탐색하는 위치는 인덱스를 포함함.
        System.out.println();

        final String seoulStr = "서울정수";
        System.out.println("전체 문자열 길이: " + seoulStr.length());
        System.out.println(seoulStr.charAt(0));
        System.out.println(seoulStr.charAt(1));
        System.out.println(seoulStr.charAt(2));
        System.out.println(seoulStr.charAt(3));
        System.out.println();

        // seoulStr에서 "울정" 문자열만 반환받는 예제
        System.out.println(seoulStr.substring(1, 3));
    }
}
