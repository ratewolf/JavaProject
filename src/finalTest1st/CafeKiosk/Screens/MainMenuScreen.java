package finalTest1st.CafeKiosk.Screens;

import finalTest1st.CafeKiosk.ConsoleRenderer;
import finalTest1st.CafeKiosk.KioskScreen;
import finalTest1st.CafeKiosk.Menu;

import java.util.List;
import java.util.Objects;

public final class MainMenuScreen implements KioskScreen {

    private final List<Menu> menus;
    private String message;

    public MainMenuScreen(List<Menu> menus) {
        Objects.requireNonNull(
                menus,
                "메뉴 목록은 null일 수 없습니다."
        );

        if (menus.isEmpty()) {
            throw new IllegalArgumentException(
                    "메뉴가 하나 이상 필요합니다."
            );
        }

        this.menus = List.copyOf(menus);
        this.message = "주문할 상품 번호를 입력해주세요.";
    }

    @Override
    public void render(ConsoleRenderer renderer) {
        renderer.printLine("========================================");
        renderer.printLine("             JAVA CAFE KIOSK");
        renderer.printLine("========================================");
        renderer.printLine();

        renderer.printLine("[ 음료 메뉴 ]");
        renderer.printLine("----------------------------------------");

        for (Menu menu : menus) {
            renderer.printLine(menu.toString());
            renderer.printLine("   " + menu.getDescription());
        }

        renderer.printLine("----------------------------------------");
        renderer.printLine("0. 키오스크 종료");
        renderer.printLine();
        renderer.printLine(message);
        renderer.print("> ");
    }

    @Override
    public KioskScreen handleInput(String input) {
        if (input == null) {
            return null;
        }

        String trimmedInput = input.trim();

        if (trimmedInput.equals("0")) {
            return null;
        }

        Integer selectedId = parseMenuId(trimmedInput);

        if (selectedId == null) {
            message = "숫자로 된 상품 번호를 입력해주세요.";
            return this;
        }

        Menu selectedMenu = findMenuById(selectedId);

        if (selectedMenu == null) {
            message = "존재하지 않는 상품 번호입니다.";
            return this;
        }

        return new ProductDetailScreen(
                selectedMenu,
                this
        );
    }

    private Integer parseMenuId(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return null;
        }
    }

    private Menu findMenuById(int menuId) {
        for (Menu menu : menus) {
            if (menu.getId() == menuId) {
                return menu;
            }
        }

        return null;
    }
}