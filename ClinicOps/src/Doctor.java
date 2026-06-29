public class Doctor {

    private String doctorId;
    private String doctorName;
    private Specialization specialization;
    private int experience;
    private Shift shift;

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

    @Override
    public String toString() {

        return "Doctor ID       : " + doctorId
                + "\nDoctor Name     : " + doctorName
                + "\nSpecialization  : " + specialization
                + "\nExperience      : " + experience + " Years"
                + "\nShift           : " + shift;
    }

}