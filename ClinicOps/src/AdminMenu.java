import java.util.ArrayList;
import java.util.Scanner;

public class AdminMenu {

    private static final int DOCTOR_ENTRY = 1;
    private static final int BULK_ENTRY = 2;
    private static final int AUDIT = 3;
    private static final int DISPLAY_DOCTORS = 4;
    private static final int LOGOUT = 5;

    private static ArrayList<Doctor> doctors = new ArrayList<>();

    /**
     * Returns all registered doctors.
     * Used by FrontDeskMenu for appointment booking.
     */
    public static ArrayList<Doctor> getDoctors() {

        return doctors;

    }
    private static int doctorCounter = 1;

    public static void showAdminMenu(Scanner scanner) {

        boolean logout = false;

        while (!logout) {

            displayAdminOptions();

            int choice = ScannerHelper.readInteger(scanner,
                    "Enter your choice : ");

            switch (choice) {

                case DOCTOR_ENTRY:

                    registerDoctors(scanner);
                    break;

                case BULK_ENTRY:

                    bulkImportDoctors(scanner);
                    break;

                case AUDIT:

                    System.out.println("\nAudit Log feature will be implemented in future UC.");
                    break;

                case DISPLAY_DOCTORS:

                    displayDoctors();
                    break;

                case LOGOUT:

                    System.out.println("\nLogging out from Admin...");
                    logout = true;
                    break;

                default:

                    System.out.println("\nInvalid Menu Option.");
            }
        }
    }

    private static void displayAdminOptions() {

        System.out.println();
        System.out.println("=================================");
        System.out.println("         ADMIN MENU");
        System.out.println("=================================");
        System.out.println("1. Doctor's Data Entry");
        System.out.println("2. Bulk Data Entry");
        System.out.println("3. View Audit Logs");
        System.out.println("4. Display Doctors");
        System.out.println("5. Logout");
        System.out.println("=================================");
    }

    private static void registerDoctors(Scanner scanner) {

        int numberOfDoctors =
                ScannerHelper.readInteger(
                        scanner,
                        "\nHow many doctors do you want to register? : ");

        for (int i = 1; i <= numberOfDoctors; i++) {

            System.out.println();
            System.out.println("Enter Details of Doctor " + i);

            String doctorName =
                    ScannerHelper.readString(
                            scanner,
                            "Doctor Name : ");

            Specialization specialization =
                    ScannerHelper.readEnumChoice(
                            scanner,
                            Specialization.class,
                            "Select Specialization");

            int experience =
                    ScannerHelper.readInteger(
                            scanner,
                            "Experience : ");

            Shift shift =
                    ScannerHelper.readEnumChoice(
                            scanner,
                            Shift.class,
                            "Select Shift");

            String doctorId =
                    String.format("D%04d", doctorCounter++);

            Doctor doctor =
                    new Doctor(
                            doctorId,
                            doctorName,
                            specialization,
                            experience,
                            shift);

            doctors.add(doctor);

            System.out.println();
            System.out.println("Doctor Registered Successfully.");
        }
    }

    private static void displayDoctors() {

        System.out.println();

        if (doctors.isEmpty()) {

            System.out.println("No Doctors Registered.");
            return;
        }

        System.out.println("==============================================");
        System.out.println("          REGISTERED DOCTORS");
        System.out.println("==============================================");

        for (Doctor doctor : doctors) {

            System.out.println(doctor);

            System.out.println("----------------------------------------------");
        }


    }

    private static void bulkImportDoctors(Scanner scanner) {

        System.out.println();

        String fileName =
                ScannerHelper.readString(
                        scanner,
                        "Enter CSV File Path : ");

        ArrayList<Doctor> importedDoctors =
                FileHandler.readDoctorsFromCSV(
                        fileName,
                        doctorCounter,
                        doctors);

        doctors.addAll(importedDoctors);

        doctorCounter += importedDoctors.size();

        System.out.println();

        System.out.println(importedDoctors.size()
                + " Doctor(s) Imported Successfully.");

    }

}