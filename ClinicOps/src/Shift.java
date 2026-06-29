public enum Shift {

    MORNING("Morning (9:00 AM - 1:00 PM)"),
    EVENING("Evening (4:00 PM - 8:00 PM)"),
    BOTH("Both");

    private final String displayName;

    Shift(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

}