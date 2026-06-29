import java.util.Objects;

public class Doctor {

    private String doctorId;
    private String doctorName;
    private Specialization specialization;
    private int experience;
    private Shift shift;

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

    // ===========================
    // Setters (Optional)
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
    // Duplicate Check
    // ===========================
    // Two doctors are considered duplicates if
    // Name + Specialization + Experience are same.

    @Override
    public boolean equals(Object obj) {

        if (this == obj) {
            return true;
        }

        if (obj == null || getClass() != obj.getClass()) {
            return false;
        }

        Doctor doctor = (Doctor) obj;

        return experience == doctor.experience
                && doctorName.equalsIgnoreCase(doctor.doctorName)
                && specialization == doctor.specialization;
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

        builder.append("--------------------------------------\n");
        builder.append("Doctor ID       : ").append(doctorId).append("\n");
        builder.append("Doctor Name     : ").append(doctorName).append("\n");
        builder.append("Specialization  : ").append(specialization).append("\n");
        builder.append("Experience      : ")
                .append(experience)
                .append(" Years\n");
        builder.append("Shift           : ")
                .append(shift)
                .append("\n");
        builder.append("--------------------------------------");

        return builder.toString();
    }

}