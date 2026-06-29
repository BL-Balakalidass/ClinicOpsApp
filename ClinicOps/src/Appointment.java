public class Appointment {

    private Patient patient;
    private Doctor doctor;
    private String appointmentSlot;

    /**
     * Constructor
     */
    public Appointment(Patient patient,
                       Doctor doctor,
                       String appointmentSlot) {

        this.patient = patient;
        this.doctor = doctor;
        this.appointmentSlot = appointmentSlot;
    }

    /**
     * Returns the Patient Object
     */
    public Patient getPatient() {
        return patient;
    }

    /**
     * Returns the Doctor Object
     */
    public Doctor getDoctor() {
        return doctor;
    }

    /**
     * Returns the Appointment Slot
     */
    public String getAppointmentSlot() {
        return appointmentSlot;
    }

    /**
     * Displays Appointment Details
     */
    @Override
    public String toString() {

        StringBuilder builder = new StringBuilder();

        builder.append("\n=====================================\n");
        builder.append("      APPOINTMENT CONFIRMED\n");
        builder.append("=====================================\n");

        builder.append("Patient ID        : ")
                .append(patient.getPatientId())
                .append("\n");

        builder.append("Patient Name      : ")
                .append(patient.getPatientName())
                .append("\n");

        builder.append("Doctor ID         : ")
                .append(doctor.getDoctorId())
                .append("\n");

        builder.append("Doctor Name       : ")
                .append(doctor.getDoctorName())
                .append("\n");

        builder.append("Appointment Slot  : ")
                .append(appointmentSlot)
                .append("\n");

        builder.append("=====================================");

        return builder.toString();
    }

}