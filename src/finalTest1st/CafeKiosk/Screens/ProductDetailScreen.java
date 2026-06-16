package finalTest1st.CafeKiosk.Screens;

import finalTest1st.CafeKiosk.ConsoleRenderer;
import finalTest1st.CafeKiosk.KioskScreen;
import finalTest1st.CafeKiosk.Menu;
import finalTest1st.CafeKiosk.Options.CoffeeSize;
import finalTest1st.CafeKiosk.Options.Temperature;

import java.util.List;
import java.util.Objects;

public final class ProductDetailScreen implements KioskScreen {

    private final Menu selectedMenu;
    private final KioskScreen previousScreen;

    private String message;

    public ProductDetailScreen(
            Menu selectedMenu,
            KioskScreen previousScreen
    ) {
        this.selectedMenu = Objects.requireNonNull(
                selectedMenu,
                "선택된 메뉴는 null일 수 없습니다."
        );

        this.previousScreen = Objects.requireNonNull(
                previousScreen,
                "이전 화면은 null일 수 없습니다."
        );

        this.message = "원하는 메뉴를 선택해주세요.";
    }

    @Override
    public void render(ConsoleRenderer renderer) {
        renderer.printLine("========================================");
        renderer.printLine("             상품 상세 정보");
        renderer.printLine("========================================");
        renderer.printLine();

        renderer.printLine(
                "상품명 : " + selectedMenu.getName()
        );

        renderer.printLine(
                "가격   : " + selectedMenu.getFormattedBasePrice()
        );

        renderer.printLine(
                "설명   : " + selectedMenu.getDescription()
        );

        renderer.printLine();

        renderAvailableSizes(renderer);
        renderAvailableTemperatures(renderer);

        renderer.printLine("----------------------------------------");
        renderer.printLine("1. 옵션 선택");
        renderer.printLine("0. 이전 화면");
        renderer.printLine("----------------------------------------");
        renderer.printLine();

        renderer.printLine(message);
        renderer.print("> ");
    }

    private void renderAvailableSizes(ConsoleRenderer renderer) {
        List<CoffeeSize> sizes =
                selectedMenu.getAvailableSizes();

        renderer.print("[ 선택 가능한 사이즈 ] ");

        if (sizes.isEmpty()) {
            renderer.printLine("없음");
            return;
        }

        for (int i = 0; i < sizes.size(); i++) {
            CoffeeSize size = sizes.get(i);

            renderer.print(size.getDisplayName());

            if (i < sizes.size() - 1) {
                renderer.print(" / ");
            }
        }

        renderer.printLine();
    }

    private void renderAvailableTemperatures(
            ConsoleRenderer renderer
    ) {
        List<Temperature> temperatures =
                selectedMenu.getAvailableTemperatures();

        renderer.print("[ 선택 가능한 온도 ] ");

        if (temperatures.isEmpty()) {
            renderer.printLine("없음");
            return;
        }

        for (int i = 0; i < temperatures.size(); i++) {
            Temperature temperature = temperatures.get(i);

            renderer.print(temperature.getDisplayName());

            if (i < temperatures.size() - 1) {
                renderer.print(" / ");
            }
        }

        renderer.printLine();
        renderer.printLine();
    }

    @Override
    public KioskScreen handleInput(String input) {
        if (input == null) {
            return null;
        }

        String trimmedInput = input.trim();

        return switch (trimmedInput) {
            case "1" -> handleOptionSelection();
            case "0" -> previousScreen;
            default -> {
                message = "0 또는 1을 입력해주세요.";
                yield this;
            }
        };
    }

    private KioskScreen handleOptionSelection() {
        return new OptionSelectionScreen(
                selectedMenu,
                this
        );
    }
}