package ai0409;

import java.util.Scanner;

public class GPACalculator {
    public enum Subject {
        CAREER(2, "직업과경력개발"),
        PROMPT(2, "프롬프트엔지니어링"),
        DB(2, "데이터베이스"),
        SERVER(3, "서버구축및운영실습"),
        ALGORITHM(3, "알고리즘실습"),
        INTRO(2, "인공지능개론"),
        UI(3, "융합UI실습"),
        VISION(3, "영상인공지능처리"),
        WEB(3, "웹프로그래밍기초"),
        JAVA(3, "프로그래밍언어실습");

        private final int credit;
        private final String name;

        Subject(int credit, String name) {
            this.credit = credit;
            this.name = name;
        }

        public int getCredit() {
            return credit;
        }

        public String getName() {
            return name;
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.println("=========== 과목 성적 평균 ===========");
        System.out.println("* 성적 입력값은 0.0~4.5 사이의 값을 입력하세요.");
        System.out.println("* 아직 성적이 나오지 않았다면 -1을 입력해주세요.");

        int totalCredit = 0;
        int gradedSubjectCount = 0;
        double weightedScore = 0.0;

        for (Subject subject : Subject.values()) {
            double score = readScore(scanner, subject);

            if (score == -1.0) {
                continue;
            }

            gradedSubjectCount++;
            weightedScore += score * subject.getCredit();
            totalCredit += subject.getCredit();
        }

        if (totalCredit == 0) {
            System.out.println("입력된 성적이 없어 평균을 계산할 수 없습니다.");
        } else {
            double avg = weightedScore / totalCredit;
            System.out.printf("%d과목 평균: %.2f%n", gradedSubjectCount, avg);
        }

        scanner.close();
    }

    private static double readScore(Scanner scanner, Subject subject) {
        while (true) {
            System.out.printf("%s(%d학점) 성적 입력: ", subject.getName(), subject.getCredit());

            if (!scanner.hasNextDouble()) {
                System.out.println("숫자를 입력해주세요.");
                scanner.next();
                continue;
            }

            double score = scanner.nextDouble();

            if (score == -1.0 || (score >= 0.0 && score <= 4.5)) {
                return score;
            }

            System.out.println("0.0~4.5 또는 -1만 입력할 수 있습니다.");
        }
    }
}