package middleTest;

import java.time.Duration;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.time.format.DateTimeParseException;
import java.util.Scanner;

public class TimeCalculator {

    public static class Time {
        private final String timeString; // 연.월.일 시:분:초
        private final LocalDateTime dateTime;

        Time(String timeString) {
            this.timeString = timeString;
            this.dateTime = calculateStringToDateTime();
        }

        public String getTimeString() {
            return timeString;
        }

        public LocalDateTime getDateTime() {
            return dateTime;
        }

        private LocalDateTime calculateStringToDateTime() {
            DateTimeFormatter formatter =
                    DateTimeFormatter.ofPattern("yyyy.MM.dd HH:mm:ss");

            return LocalDateTime.parse(timeString, formatter);
        }
    }

    public static class TimeDuration {
        private final Time startTime;
        private final Time endTime;
        private final long totalSeconds;

        TimeDuration(Time startTime, Time endTime) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.totalSeconds = Math.abs(
                    Duration.between(startTime.getDateTime(), endTime.getDateTime()).getSeconds()
            );
        }

        public long getTotalSeconds() {
            return totalSeconds;
        }

        public long getDays() {
            return totalSeconds / (24 * 60 * 60);
        }

        public long getHours() {
            return (totalSeconds % (24 * 60 * 60)) / (60 * 60);
        }

        public long getMinutes() {
            return (totalSeconds % (60 * 60)) / 60;
        }

        public long getSeconds() {
            return totalSeconds % 60;
        }

        public void printResult() {
            System.out.println("\n=========== 계산 결과 ===========");
            System.out.println("기준 시간: " + startTime.getTimeString());
            System.out.println("비교 시간: " + endTime.getTimeString());
            System.out.println();

            System.out.println("총 경과 초: " + totalSeconds + "초");
            System.out.printf(
                    "경과 시간: %d일 %d시간 %d분 %d초\n",
                    getDays(), getHours(), getMinutes(), getSeconds()
            );
            System.out.println("================================\n");
        }
    }

    public static class TimeService {
        private final Scanner scanner;

        TimeService(Scanner scanner) {
            this.scanner = scanner;
        }

        public void run() {
            while (true) {
                printMenu();

                String input = scanner.nextLine();

                if (input.equals("0")) {
                    System.out.println("프로그램을 종료합니다.");
                    break;
                }

                if (input.equals("1")) {
                    calculateDuration();
                } else {
                    System.out.println("잘못된 입력입니다.\n");
                }
            }
        }

        private void printMenu() {
            System.out.println("=========== Time Calculator ===========");
            System.out.println("1. 두 시간 사이의 경과 시간 계산");
            System.out.println("0. 종료");
            System.out.print("메뉴 선택: ");
        }

        private void calculateDuration() {
            try {
                System.out.println("\n입력 형식: yyyy.MM.dd HH:mm:ss");
                System.out.print("기준 시간을 입력하세요: ");
                Time startTime = new Time(scanner.nextLine());

                System.out.print("비교 시간을 입력하세요: ");
                Time endTime = new Time(scanner.nextLine());

                TimeDuration duration = new TimeDuration(startTime, endTime);
                duration.printResult();

            } catch (DateTimeParseException e) {
                System.out.println("\n날짜 형식이 올바르지 않습니다.");
                System.out.println("예시처럼 입력해주세요: 2024.04.15 13:30:00\n");
            }
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        TimeService timeService = new TimeService(scanner);
        timeService.run();

        scanner.close();
    }
}
