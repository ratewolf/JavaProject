package finalTest1st.CafeKiosk;

import finalTest1st.CafeKiosk.Options.CoffeeSize;
import finalTest1st.CafeKiosk.Options.Temperature;

import java.util.Collections;
import java.util.List;
import java.util.Objects;

public abstract class Menu {

    private final int id;
    private final String name;
    private final int basePrice;

    protected Menu(int id, String name, int basePrice) {
        if (id <= 0) {
            throw new IllegalArgumentException("메뉴 ID는 1 이상이어야 합니다.");
        }

        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("메뉴 이름은 비어 있을 수 없습니다.");
        }

        if (basePrice < 0) {
            throw new IllegalArgumentException("가격은 음수일 수 없습니다.");
        }

        this.id = id;
        this.name = name;
        this.basePrice = basePrice;
    }

    public final int getId() {
        return id;
    }

    public final String getName() {
        return name;
    }

    public final int getBasePrice() {
        return basePrice;
    }

    /*
     * 상품마다 설명이 다르므로 하위 클래스가 반드시 구현해야 한다.
     */
    public abstract String getDescription();

    /*
     * 상품마다 선택 가능한 사이즈가 다를 수 있다.
     * 기본값은 사이즈 선택을 지원하지 않는 것이다.
     */
    public List<CoffeeSize> getAvailableSizes() {
        return Collections.emptyList();
    }

    /*
     * 상품마다 선택 가능한 온도가 다를 수 있다.
     */
    public List<Temperature> getAvailableTemperatures() {
        return Collections.emptyList();
    }

    public int calculatePrice(CoffeeSize size) {
        int optionPrice = size == null ? 0 : size.getAdditionalPrice();
        return basePrice + optionPrice;
    }

    public final String getFormattedBasePrice() {
        return String.format("%,d원", basePrice);
    }

    @Override
    public final String toString() {
        return String.format(
                "%d. %-12s %8s",
                id,
                name,
                getFormattedBasePrice()
        );
    }

    @Override
    public final boolean equals(Object object) {
        if (this == object) {
            return true;
        }

        if (!(object instanceof Menu other)) {
            return false;
        }

        return id == other.id;
    }

    @Override
    public final int hashCode() {
        return Objects.hash(id);
    }
}