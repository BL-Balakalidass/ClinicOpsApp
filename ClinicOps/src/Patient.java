public class Patient {

    private String patientId;
    private String patientName;
    private String gender;
    private int age;
    private String mobileNumber;

    public Patient(String patientId,
                   String patientName,
                   String gender,
                   int age,
                   String mobileNumber) {

        this.patientId = patientId;
        this.patientName = patientName;
        this.gender = gender;
        this.age = age;
        this.mobileNumber = mobileNumber;
    }

    public String getPatientId() {
        return patientId;
    }

    public String getPatientName() {
        return patientName;
    }


    public String getGender() {
        return gender;
    }

    public int getAge() {
        return age;
    }

    public String getMobileNumber() {
        return mobileNumber;
    }

    @Override
    public String toString() {

        return "Patient ID      : " + patientId
                + "\nPatient Name    : " + patientName
                + "\nGender          : " + gender
                + "\nAge             : " + age
                + "\nMobile Number   : " + mobileNumber;
    }

}