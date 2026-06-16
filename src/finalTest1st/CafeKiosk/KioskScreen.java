package finalTest1st.CafeKiosk;

public interface KioskScreen {

    void render(ConsoleRenderer renderer);

    /*
     * 현재 화면을 유지하려면 this,
     * 다른 화면으로 이동하려면 해당 화면 객체,
     * 종료하려면 null을 반환한다.
     */
    KioskScreen handleInput(String input);
}