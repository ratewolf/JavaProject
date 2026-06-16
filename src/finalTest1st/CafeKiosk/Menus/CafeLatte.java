package finalTest1st.CafeKiosk.Menus;

import finalTest1st.CafeKiosk.Menu;
import finalTest1st.CafeKiosk.Options.CoffeeSize;
import finalTest1st.CafeKiosk.Options.Temperature;

import java.util.List;

public final class CafeLatte extends Menu {

    private static final List<CoffeeSize> AVAILABLE_SIZES = List.of(
            CoffeeSize.SMALL,
            CoffeeSize.MEDIUM,
            CoffeeSize.LARGE
    );

    private static final List<Temperature> AVAILABLE_TEMPERATURES = List.of(
            Temperature.HOT,
            Temperature.ICE
    );

    public CafeLatte(int id, int basePrice) {
        super(id, "카페라떼", basePrice);
    }

    @Override
    public String getDescription() {
        return "에스프레소와 부드러운 우유가 어우러진 커피";
    }

    @Override
    public List<CoffeeSize> getAvailableSizes() {
        return AVAILABLE_SIZES;
    }

    @Override
    public List<Temperature> getAvailableTemperatures() {
        return AVAILABLE_TEMPERATURES;
    }
}