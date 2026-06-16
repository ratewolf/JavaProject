package finalTest1st.CafeKiosk;

import finalTest1st.CafeKiosk.Menus.Americano;
import finalTest1st.CafeKiosk.Menus.CafeLatte;
import finalTest1st.CafeKiosk.Screens.MainMenuScreen;

import java.util.List;

public class Main {

    public static void main(String[] args) {
        List<Menu> menus = createMenus();

        KioskScreen firstScreen = new MainMenuScreen(menus);
        KioskApplication application = new KioskApplication(firstScreen);

        application.run();
    }

    private static List<Menu> createMenus() {
        return List.of(
                new Americano(1, 3_000),
                new CafeLatte(2, 4_000)
        );
    }
}