package finalTest1st.CafeKiosk;

public final class ConsoleRenderer {

    public void print(String text) {
        System.out.print(text);
    }

    public void printLine(String text) {
        System.out.println(text);
    }

    public void printLine() {
        System.out.println();
    }

    public void printScreenSeparator() {
        System.out.println();
        System.out.println();
        System.out.println("########################################");
        System.out.println();
    }
}