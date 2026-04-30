package ai0430;

public class ForTest1 {
    public static void main(String[] args) {
        String[] subjectArr = {"자바프로그래밍언어", "데이터베이스", "융합UI실습", "인공지능개론"};
        for (int i = 0; i < subjectArr.length; i++) {
            System.out.printf("%d. 저는 %s를 이번에 처음 공부해요.\n", i + 1, subjectArr[i]);
        }
    }
}
