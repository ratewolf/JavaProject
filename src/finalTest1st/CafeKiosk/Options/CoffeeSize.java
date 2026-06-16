package finalTest1st.CafeKiosk.Options;

public enum CoffeeSize {

    SMALL("Small", 0),
    MEDIUM("Medium", 500),
    LARGE("Large", 1_000);

    private final String displayName;
    private final int additionalPrice;

    CoffeeSize(String displayName, int additionalPrice) {
        this.displayName = displayName;
        this.additionalPrice = additionalPrice;
    }

    public String getDisplayName() {
        return displayName;
    }

    public int getAdditionalPrice() {
        return additionalPrice;
    }

    public String getFormattedAdditionalPrice() {
        if (additionalPrice == 0) {
            return "추가 금액 없음";
        }

        return String.format("+%,d원", additionalPrice);
    }

    @Override
    public String toString() {
        return displayName + " (" + getFormattedAdditionalPrice() + ")";
    }
}