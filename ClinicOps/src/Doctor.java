public class Doctor {

    private String doctorId;
    private String doctorName;
    private String specialization;
    private int experience;
    private String shift;

    public Doctor(String doctorId, String doctorName,
                  String specialization,
                  int experience,
                  String shift) {

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

    public String getSpecialization() {
        return specialization;
    }

    public int getExperience() {
        return experience;
    }

    public String getShift() {
        return shift;
    }

    @Override
    public String toString() {

        return "Doctor ID       : " + doctorId +
                "\nDoctor Name     : " + doctorName +
                "\nSpecialization  : " + specialization +
                "\nExperience      : " + experience + " Years" +
                "\nShift           : " + shift;
    }

}