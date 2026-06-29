public enum Specialization {

    CARDIOLOGY("Cardiology"),
    NEUROLOGY("Neurology"),
    PEDIATRICS("Pediatrics"),
    ORTHOPEDICS("Orthopedics"),
    GENERAL_MEDICINE("General Medicine"),
    DERMATOLOGY("Dermatology"),
    ENT("ENT"),
    GYNECOLOGY("Gynecology");

    private final String displayName;

    Specialization(String displayName) {
        this.displayName = displayName;
    }

    @Override
    public String toString() {
        return displayName;
    }

}