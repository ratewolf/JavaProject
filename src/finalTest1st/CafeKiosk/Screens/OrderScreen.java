package finalTest1st.CafeKiosk.Screens;

import finalTest1st.CafeKiosk.ConsoleRenderer;
import finalTest1st.CafeKiosk.KioskScreen;
import finalTest1st.CafeKiosk.Options.CoffeeSize;
import finalTest1st.CafeKiosk.Options.Temperature;
import finalTest1st.CafeKiosk.OrderItem;

import java.util.Objects;

public final class OrderScreen implements KioskScreen {

    private final OrderItem orderItem;
    private final KioskScreen optionScreen;

    private boolean orderConfirmed;
    private String message;

    public OrderScreen(
            OrderItem orderItem,
            KioskScreen optionScreen
    ) {
        this.orderItem = Objects.requireNonNull(
                orderItem,
                "주문 항목은 null일 수 없습니다."
        );

        this.optionScreen = Objects.requireNonNull(
                optionScreen,
                "옵션 화면은 null일 수 없습니다."
        );

        this.orderConfirmed = false;
        this.message = "주문 내용을 확인해주세요.";
    }

    @Override
    public void render(ConsoleRenderer renderer) {
        renderer.printLine("========================================");
        renderer.printLine("              주문 확인");
        renderer.printLine("========================================");
        renderer.printLine();

        renderOrderInformation(renderer);

        renderer.printLine("----------------------------------------");

        if (orderConfirmed) {
            renderConfirmedMenu(renderer);
        } else {
            renderConfirmationMenu(renderer);
        }

        renderer.printLine("----------------------------------------");
        renderer.printLine();
        renderer.printLine(message);
        renderer.print("> ");
    }

    private void renderOrderInformation(ConsoleRenderer renderer) {
        renderer.printLine(
                "상품명 : " + orderItem.getMenu().getName()
        );

        renderer.printLine(
                "사이즈 : " + getSizeText()
        );

        renderer.printLine(
                "온도   : " + getTemperatureText()
        );

        renderer.printLine(
                "수량   : " + orderItem.getQuantity() + "개"
        );

        renderer.printLine(
                "단가   : " + orderItem.getFormattedUnitPrice()
        );

        renderer.printLine();

        renderer.printLine(
                "최종 결제 금액 : "
                        + orderItem.getFormattedTotalPrice()
        );

        renderer.printLine();
    }

    private String getSizeText() {
        CoffeeSize size = orderItem.getSize();

        if (size == null) {
            return "해당 없음";
        }

        return size.getDisplayName();
    }

    private String getTemperatureText() {
        Temperature temperature =
                orderItem.getTemperature();

        if (temperature == null) {
            return "해당 없음";
        }

        return temperature.getDisplayName();
    }

    private void renderConfirmationMenu(
            ConsoleRenderer renderer
    ) {
        renderer.printLine("1. 주문 확정");
        renderer.printLine("0. 옵션 다시 선택");
    }

    private void renderConfirmedMenu(
            ConsoleRenderer renderer
    ) {
        renderer.printLine("0. 키오스크 종료");
    }

    @Override
    public KioskScreen handleInput(String input) {
        if (input == null) {
            return null;
        }

        String trimmedInput = input.trim();

        if (orderConfirmed) {
            return handleConfirmedInput(trimmedInput);
        }

        return handleConfirmationInput(trimmedInput);
    }

    private KioskScreen handleConfirmationInput(String input) {
        return switch (input) {
            case "1" -> confirmOrder();
            case "0" -> optionScreen;
            default -> {
                message = "0 또는 1을 입력해주세요.";
                yield this;
            }
        };
    }

    private KioskScreen confirmOrder() {
        orderConfirmed = true;
        message = "주문이 정상적으로 접수되었습니다.";

        return this;
    }

    private KioskScreen handleConfirmedInput(String input) {
        if (input.equals("0")) {
            return null;
        }

        message = "주문이 완료되었습니다. 0을 입력해주세요.";
        return this;
    }
}