package finalTest1st.CafeKiosk.Screens;

import finalTest1st.CafeKiosk.ConsoleRenderer;
import finalTest1st.CafeKiosk.KioskScreen;
import finalTest1st.CafeKiosk.Menu;
import finalTest1st.CafeKiosk.Options.CoffeeSize;
import finalTest1st.CafeKiosk.Options.Temperature;
import finalTest1st.CafeKiosk.OrderItem;

import java.util.List;
import java.util.Objects;

public final class OptionSelectionScreen implements KioskScreen {

    private enum SelectionStep {
        SIZE,
        TEMPERATURE,
        READY
    }

    private final Menu selectedMenu;
    private final KioskScreen previousScreen;

    private CoffeeSize selectedSize;
    private Temperature selectedTemperature;
    private SelectionStep currentStep;
    private String message;

    public OptionSelectionScreen(
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

        this.currentStep = determineFirstStep();
        this.message = createInitialMessage();
    }

    private SelectionStep determineFirstStep() {
        if (!selectedMenu.getAvailableSizes().isEmpty()) {
            return SelectionStep.SIZE;
        }

        if (!selectedMenu.getAvailableTemperatures().isEmpty()) {
            return SelectionStep.TEMPERATURE;
        }

        return SelectionStep.READY;
    }

    private String createInitialMessage() {
        return switch (currentStep) {
            case SIZE -> "원하는 사이즈 번호를 입력해주세요.";
            case TEMPERATURE -> "원하는 온도 번호를 입력해주세요.";
            case READY -> "추가 옵션이 없는 상품입니다.";
        };
    }

    @Override
    public void render(ConsoleRenderer renderer) {
        renderer.printLine("========================================");
        renderer.printLine("              옵션 선택");
        renderer.printLine("========================================");
        renderer.printLine();

        renderSelectedMenu(renderer);
        renderCurrentSelections(renderer);

        renderer.printLine("----------------------------------------");

        switch (currentStep) {
            case SIZE -> renderSizeOptions(renderer);
            case TEMPERATURE -> renderTemperatureOptions(renderer);
            case READY -> renderReadyOption(renderer);
        }

        renderer.printLine("----------------------------------------");
        renderer.printLine("0. 상품 상세 화면으로 돌아가기");
        renderer.printLine();
        renderer.printLine(message);
        renderer.print("> ");
    }

    private void renderSelectedMenu(ConsoleRenderer renderer) {
        renderer.printLine("상품명 : " + selectedMenu.getName());
        renderer.printLine(
                "기본 가격 : " + selectedMenu.getFormattedBasePrice()
        );
        renderer.printLine();
    }

    private void renderCurrentSelections(ConsoleRenderer renderer) {
        renderer.printLine("[ 현재 선택 ]");

        renderer.printLine(
                "사이즈 : " + getSelectedSizeText()
        );

        renderer.printLine(
                "온도   : " + getSelectedTemperatureText()
        );

        renderer.printLine(
                "현재 가격 : "
                        + String.format("%,d원", calculateCurrentPrice())
        );

        renderer.printLine();
    }

    private String getSelectedSizeText() {
        if (selectedMenu.getAvailableSizes().isEmpty()) {
            return "해당 없음";
        }

        if (selectedSize == null) {
            return "선택 전";
        }

        return selectedSize.getDisplayName();
    }

    private String getSelectedTemperatureText() {
        if (selectedMenu.getAvailableTemperatures().isEmpty()) {
            return "해당 없음";
        }

        if (selectedTemperature == null) {
            return "선택 전";
        }

        return selectedTemperature.getDisplayName();
    }

    private int calculateCurrentPrice() {
        return selectedMenu.calculatePrice(selectedSize);
    }

    private void renderSizeOptions(ConsoleRenderer renderer) {
        renderer.printLine("[ 사이즈 선택 ]");

        List<CoffeeSize> sizes =
                selectedMenu.getAvailableSizes();

        for (int i = 0; i < sizes.size(); i++) {
            CoffeeSize size = sizes.get(i);

            renderer.printLine(
                    (i + 1)
                            + ". "
                            + size.getDisplayName()
                            + " / "
                            + size.getFormattedAdditionalPrice()
            );
        }
    }

    private void renderTemperatureOptions(
            ConsoleRenderer renderer
    ) {
        renderer.printLine("[ 온도 선택 ]");

        List<Temperature> temperatures =
                selectedMenu.getAvailableTemperatures();

        for (int i = 0; i < temperatures.size(); i++) {
            Temperature temperature = temperatures.get(i);

            renderer.printLine(
                    (i + 1)
                            + ". "
                            + temperature.getDisplayName()
            );
        }
    }

    private void renderReadyOption(ConsoleRenderer renderer) {
        renderer.printLine("[ 옵션 선택 완료 ]");
        renderer.printLine("1. 주문 내용 확인");
    }

    @Override
    public KioskScreen handleInput(String input) {
        if (input == null) {
            return null;
        }

        String trimmedInput = input.trim();

        if (trimmedInput.equals("0")) {
            return previousScreen;
        }

        return switch (currentStep) {
            case SIZE -> handleSizeInput(trimmedInput);
            case TEMPERATURE ->
                    handleTemperatureInput(trimmedInput);
            case READY -> handleReadyInput(trimmedInput);
        };
    }

    private KioskScreen handleSizeInput(String input) {
        Integer selectedNumber = parseNumber(input);

        if (selectedNumber == null) {
            message = "사이즈 번호를 숫자로 입력해주세요.";
            return this;
        }

        List<CoffeeSize> sizes =
                selectedMenu.getAvailableSizes();

        if (!isValidIndex(selectedNumber, sizes.size())) {
            message = "존재하지 않는 사이즈 번호입니다.";
            return this;
        }

        selectedSize = sizes.get(selectedNumber - 1);

        if (selectedMenu.getAvailableTemperatures().isEmpty()) {
            currentStep = SelectionStep.READY;
            message = "옵션 선택이 완료되었습니다.";
            return this;
        }

        currentStep = SelectionStep.TEMPERATURE;
        message = "원하는 온도 번호를 입력해주세요.";

        return this;
    }

    private KioskScreen handleTemperatureInput(String input) {
        Integer selectedNumber = parseNumber(input);

        if (selectedNumber == null) {
            message = "온도 번호를 숫자로 입력해주세요.";
            return this;
        }

        List<Temperature> temperatures =
                selectedMenu.getAvailableTemperatures();

        if (!isValidIndex(
                selectedNumber,
                temperatures.size()
        )) {
            message = "존재하지 않는 온도 번호입니다.";
            return this;
        }

        selectedTemperature =
                temperatures.get(selectedNumber - 1);

        return createOrderScreen();
    }

    private KioskScreen handleReadyInput(String input) {
        if (!input.equals("1")) {
            message = "0 또는 1을 입력해주세요.";
            return this;
        }

        return createOrderScreen();
    }

    private KioskScreen createOrderScreen() {
        OrderItem orderItem = new OrderItem(
                selectedMenu,
                selectedSize,
                selectedTemperature,
                1
        );

        return new OrderScreen(
                orderItem,
                this
        );
    }

    private Integer parseNumber(String input) {
        try {
            return Integer.parseInt(input);
        } catch (NumberFormatException exception) {
            return null;
        }
    }

    private boolean isValidIndex(
            int selectedNumber,
            int listSize
    ) {
        return selectedNumber >= 1
                && selectedNumber <= listSize;
    }
}