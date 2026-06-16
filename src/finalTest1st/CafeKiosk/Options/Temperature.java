package finalTest1st.CafeKiosk.Options;

public enum Temperature {

    HOT("HOT"),
    ICE("ICE");

    private final String displayName;

    Temperature(String displayName) {
        this.displayName = displayName;
    }

    public String getDisplayName() {
        return displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }
}