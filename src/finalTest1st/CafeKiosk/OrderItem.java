package finalTest1st.CafeKiosk;

import finalTest1st.CafeKiosk.Options.CoffeeSize;
import finalTest1st.CafeKiosk.Options.Temperature;

import java.util.Objects;

public final class OrderItem {

    private final Menu menu;
    private final CoffeeSize size;
    private final Temperature temperature;
    private final int quantity;

    public OrderItem(
            Menu menu,
            CoffeeSize size,
            Temperature temperature,
            int quantity
    ) {
        this.menu = Objects.requireNonNull(
                menu,
                "메뉴는 null일 수 없습니다."
        );

        if (quantity <= 0) {
            throw new IllegalArgumentException(
                    "수량은 1 이상이어야 합니다."
            );
        }

        this.size = size;
        this.temperature = temperature;
        this.quantity = quantity;
    }

    public Menu getMenu() {
        return menu;
    }

    public CoffeeSize getSize() {
        return size;
    }

    public Temperature getTemperature() {
        return temperature;
    }

    public int getQuantity() {
        return quantity;
    }

    public int getUnitPrice() {
        return menu.calculatePrice(size);
    }

    public int getTotalPrice() {
        return getUnitPrice() * quantity;
    }

    public String getFormattedUnitPrice() {
        return String.format("%,d원", getUnitPrice());
    }

    public String getFormattedTotalPrice() {
        return String.format("%,d원", getTotalPrice());
    }
}