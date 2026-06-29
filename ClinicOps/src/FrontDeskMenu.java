import java.util.ArrayList;
import java.util.Scanner;

public class FrontDeskMenu {

    private static final int REGISTER_PATIENT = 1;
    private static final int BOOK_APPOINTMENT = 2;
    private static final int VIEW_PATIENTS = 3;
    private static final int LOGOUT = 4;

    private static ArrayList<Patient> patients = new ArrayList<>();

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

                    System.out.println("\nAppointment Booking will be implemented in next UC.");
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
        System.out.println("      FRONT DESK MENU");
        System.out.println("=====================================");
        System.out.println("1. Register Patient");
        System.out.println("2. Book Appointment");
        System.out.println("3. View Patients");
        System.out.println("4. Logout");
        System.out.println("=====================================");

    }

    private static void registerPatient(Scanner scanner) {

        System.out.println();

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

        String mobileNumber =
                ScannerHelper.readMobileNumber(
                        scanner,
                        "Mobile Number : ");

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

        System.out.println();
        System.out.println("Patient Registered Successfully.");

    }

    private static void viewPatients() {

        System.out.println();

        if (patients.isEmpty()) {

            System.out.println("No Patients Registered.");

            return;
        }

        System.out.println("=======================================");
        System.out.println("        REGISTERED PATIENTS");
        System.out.println("=======================================");

        for (Patient patient : patients) {

            System.out.println(patient);

            System.out.println("---------------------------------------");

        }

    }

}