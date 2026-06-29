import java.util.ArrayList;
import java.util.Objects;

public class Doctor {

    private String doctorId;
    private String doctorName;
    private Specialization specialization;
    private int experience;
    private Shift shift;

    // UC9
    // Stores all booked appointment slots
    private ArrayList<String> bookedSlots;

    /**
     * Constructor
     */
    public Doctor(String doctorId,
                  String doctorName,
                  Specialization specialization,
                  int experience,
                  Shift shift) {

        this.doctorId = doctorId;
        this.doctorName = doctorName;
        this.specialization = specialization;
        this.experience = experience;
        this.shift = shift;

        // Initially doctor has no appointments
        this.bookedSlots = new ArrayList<>();
    }

    // ===========================
    // Getters
    // ===========================

    public String getDoctorId() {
        return doctorId;
    }

    public String getDoctorName() {
        return doctorName;
    }

    public Specialization getSpecialization() {
        return specialization;
    }

    public int getExperience() {
        return experience;
    }

    public Shift getShift() {
        return shift;
    }

    /**
     * Returns booked slots
     */
    public ArrayList<String> getBookedSlots() {
        return bookedSlots;
    }

    // ===========================
    // Setters
    // ===========================

    public void setDoctorId(String doctorId) {
        this.doctorId = doctorId;
    }

    public void setDoctorName(String doctorName) {
        this.doctorName = doctorName;
    }

    public void setSpecialization(Specialization specialization) {
        this.specialization = specialization;
    }

    public void setExperience(int experience) {
        this.experience = experience;
    }

    public void setShift(Shift shift) {
        this.shift = shift;
    }

    // ===========================
    // UC9 Appointment Methods
    // ===========================

    /**
     * Checks whether the given slot is available.
     *
     * @param slot Appointment Slot
     * @return true if available
     */
    public boolean isSlotAvailable(String slot) {

        return !bookedSlots.contains(slot);

    }

    /**
     * Books the slot.
     *
     * @param slot Appointment Slot
     */
    public void bookSlot(String slot) {

        if (isSlotAvailable(slot)) {

            bookedSlots.add(slot);

        }

    }

    // ===========================
    // Duplicate Detection (UC6)
    // ===========================

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null ||
                getClass() != obj.getClass()) {
            return false;
        }

        Doctor doctor = (Doctor) obj;

        return experience == doctor.experience
                &&
                doctorName.equalsIgnoreCase(
                        doctor.doctorName)
                &&
                specialization == doctor.specialization;

    }

    @Override
    public int hashCode() {

        return Objects.hash(
                doctorName.toLowerCase(),
                specialization,
                experience);

    }

    // ===========================
    // Display Doctor Details
    // ===========================

    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("----------------------------------------\n");
        builder.append("Doctor ID       : ")
                .append(doctorId)
                .append("\n");

        builder.append("Doctor Name     : ")
                .append(doctorName)
                .append("\n");

        builder.append("Specialization  : ")
                .append(specialization)
                .append("\n");

        builder.append("Experience      : ")
                .append(experience)
                .append(" Years\n");

        builder.append("Shift           : ")
                .append(shift)
                .append("\n");

        builder.append("----------------------------------------");

        return builder.toString();

    }

}