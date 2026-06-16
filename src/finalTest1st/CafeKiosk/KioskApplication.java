package finalTest1st.CafeKiosk;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Objects;

public final class KioskApplication {

    private final BufferedReader inputReader;
    private final ConsoleRenderer renderer;

    private KioskScreen currentScreen;
    private boolean running;

    public KioskApplication(KioskScreen firstScreen) {
        this.currentScreen = Objects.requireNonNull(
                firstScreen,
                "첫 화면은 null일 수 없습니다."
        );

        this.inputReader = new BufferedReader(
                new InputStreamReader(System.in)
        );

        this.renderer = new ConsoleRenderer();
        this.running = false;
    }

    public void run() {
        running = true;

        while (running && currentScreen != null) {
            drawCurrentScreen();

            String input = readInput();

            if (input == null) {
                stop();
                break;
            }

            currentScreen = currentScreen.handleInput(input);
        }

        showExitMessage();
    }

    private void drawCurrentScreen() {
        renderer.printScreenSeparator();
        currentScreen.render(renderer);
    }

    private String readInput() {
        try {
            return inputReader.readLine();
        } catch (IOException exception) {
            System.err.println("입력을 읽는 중 오류가 발생했습니다.");
            return null;
        }
    }

    private void stop() {
        running = false;
    }

    private void showExitMessage() {
        renderer.printScreenSeparator();
        renderer.printLine("========================================");
        renderer.printLine("          JAVA CAFE KIOSK");
        renderer.printLine("========================================");
        renderer.printLine();
        renderer.printLine("키오스크를 종료합니다.");
        renderer.printLine("이용해주셔서 감사합니다.");
        renderer.printLine("========================================");
    }
}