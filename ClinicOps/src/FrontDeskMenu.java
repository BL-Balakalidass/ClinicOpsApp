import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class FrontDeskMenu {

    private static final int REGISTER_PATIENT = 1;
    private static final int BOOK_APPOINTMENT = 2;
    private static final int VIEW_PATIENTS = 3;
    private static final int LOGOUT = 4;

    private static ArrayList<Patient> patients = new ArrayList<>();

    private static ArrayList<Appointment> appointments = new ArrayList<>();

    private static int patientCounter = 1;

    public static void showFrontDeskMenu(Scanner scanner) {

        boolean logout = false;

        while (!logout) {

            displayFrontDeskOptions();

            int choice = ScannerHelper.readInteger(
                    scanner,
                    "Enter your choice : ");

            switch (choice) {

                case REGISTER_PATIENT:
                    registerPatient(scanner);
                    break;

                case BOOK_APPOINTMENT:
                    bookAppointment(scanner);
                    break;

                case VIEW_PATIENTS:
                    viewPatients();
                    break;

                case LOGOUT:
                    System.out.println("\nLogging out from Front Desk...");
                    logout = true;
                    break;

                default:
                    System.out.println("\nInvalid Menu Option.");
            }

        }

    }

    private static void displayFrontDeskOptions() {

        System.out.println();
        System.out.println("=====================================");
        System.out.println("         FRONT DESK MENU");
        System.out.println("=====================================");
        System.out.println("1. Register Patient");
        System.out.println("2. Book Appointment");
        System.out.println("3. View Patients");
        System.out.println("4. Logout");
        System.out.println("=====================================");

    }

    /**
     * UC8 Registration Flow
     */
    private static void registerPatient(Scanner scanner) {

        System.out.println();

        String mobileNumber =
                ScannerHelper.readMobileNumber(
                        scanner,
                        "Mobile Number : ");

        Patient existingPatient =
                findPatientByMobileNumber(mobileNumber);

        if (existingPatient != null) {

            System.out.println();
            System.out.println("Patient Already Registered.");
            System.out.println("Welcome Back "
                    + existingPatient.getPatientName() + "!");
            System.out.println();

            System.out.println(existingPatient);

            return;
        }

        String patientName =
                ScannerHelper.readString(
                        scanner,
                        "Patient Name : ");

        String gender =
                ScannerHelper.readString(
                        scanner,
                        "Gender : ");

        int age =
                ScannerHelper.readInteger(
                        scanner,
                        "Age : ");

        String patientId =
                String.format("P%04d", patientCounter++);

        Patient patient =
                new Patient(
                        patientId,
                        patientName,
                        gender,
                        age,
                        mobileNumber);

        patients.add(patient);

        AuditLogger.log(
                "Patient Registered : "
                        + patient.getPatientId(),
                "INFO");

        System.out.println();
        System.out.println("Patient Registered Successfully.");

    }

    /**
     * Linear Search
     */
    private static Patient findPatientByMobileNumber(
            String mobileNumber) {

        for (Patient patient : patients) {

            if (patient.getMobileNumber().equals(mobileNumber)) {

                return patient;

            }

        }

        return null;

    }

    private static void viewPatients() {

        System.out.println();

        if (patients.isEmpty()) {

            System.out.println("No Patients Registered.");
            return;
        }

        System.out.println("=======================================");
        System.out.println("       REGISTERED PATIENTS");
        System.out.println("=======================================");

        for (Patient patient : patients) {

            System.out.println(patient);
            System.out.println("---------------------------------------");

        }

    }
    /**
     * UC9
     * Books appointment for a registered patient.
     */
    private static void bookAppointment(Scanner scanner) {

        System.out.println();

        String mobileNumber =
                ScannerHelper.readMobileNumber(
                        scanner,
                        "Enter Patient Mobile Number : ");

        Patient patient =
                findPatientByMobileNumber(mobileNumber);

        if (patient == null) {

            System.out.println();
            System.out.println("Patient is not registered.");
            return;
        }

        System.out.println();
        System.out.println("Select Required Specialization");

        Specialization specialization =
                ScannerHelper.readEnumChoice(
                        scanner,
                        Specialization.class,
                        "Choose Specialization");

        String slot =
                ScannerHelper.readAppointmentSlot(scanner);

        ArrayList<Doctor> doctors =
                AdminMenu.getDoctors();

        if (doctors.isEmpty()) {

            System.out.println();
            System.out.println("No Doctors Available.");
            return;
        }

        // Check whether any doctor exists for selected specialization

        boolean specializationExists =
                doctors.stream()
                        .anyMatch(doc ->
                                doc.getSpecialization() == specialization);

        if (!specializationExists) {

            System.out.println();
            System.out.println(
                    "No Doctor available for "
                            + specialization);

            return;
        }

        // Find first doctor with specialization and free slot

        Doctor assignedDoctor =
                doctors.stream()

                        // Filter 1
                        .filter(doc ->
                                doc.getSpecialization() == specialization)

                        // Filter 2
                        .filter(doc ->
                                doc.isShiftCompatible(slot))

                        // Filter 3
                        .filter(doc ->
                                doc.isSlotAvailable(slot))

                        .findFirst()

                        .orElse(null);

        if (assignedDoctor == null) {

            System.out.println();
            System.out.println(
                    "No Doctor Available for selected slot.");
            return;
        }

        assignedDoctor.bookSlot(slot);

        Appointment appointment =
                new Appointment(
                        patient,
                        assignedDoctor,
                        slot);

        appointments.add(appointment);

        AuditLogger.log(
                "Appointment Booked : "
                        + patient.getPatientId()
                        + " -> "
                        + assignedDoctor.getDoctorId()
                        + " at "
                        + slot,
                "INFO");
        System.out.println();
        System.out.println(appointment);

    }

    private static void viewAppointments() {

        if (appointments.isEmpty()) {

            System.out.println();

            System.out.println("No Appointments Booked.");

            return;

        }

        for (Appointment appointment : appointments) {

            System.out.println(appointment);

        }

    }

}