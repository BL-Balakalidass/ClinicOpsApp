import java.util.Scanner;

public class AdminMenu {

    // Doctor 1
    private static String doctorName1 = "";
    private static String specialization1 = "";
    private static int experience1 = 0;
    private static String shift1 = "";

    // Doctor 2
    private static String doctorName2 = "";
    private static String specialization2 = "";
    private static int experience2 = 0;
    private static String shift2 = "";

    // Doctor 3
    private static String doctorName3 = "";
    private static String specialization3 = "";
    private static int experience3 = 0;
    private static String shift3 = "";

    private static final int DOCTOR_ENTRY = 1;
    private static final int BULK_ENTRY = 2;
    private static final int AUDIT = 3;
    private static final int DISPLAY_DOCTORS = 4;
    private static final int LOGOUT = 5;

    public static void showAdminMenu(Scanner scanner) {

        boolean logout = false;

        while (!logout) {

            displayAdminOptions();

            int choice = ScannerHelper.readInteger(scanner,
                    "Enter your choice: ");

            switch (choice) {

                case DOCTOR_ENTRY:

                    registerDoctors(scanner);
                    break;

                case BULK_ENTRY:

                    System.out.println("\nBulk Entry feature will be implemented in future UC.");
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
        System.out.println("==================================");
        System.out.println("        ADMIN MENU");
        System.out.println("==================================");
        System.out.println("1. Doctor's Data Entry");
        System.out.println("2. Bulk Data Entry");
        System.out.println("3. View Audit Logs");
        System.out.println("4. Display Doctors");
        System.out.println("5. Logout");
        System.out.println("==================================");

    }

    private static void registerDoctors(Scanner scanner) {

        System.out.println("\nEnter Details of Doctor 1");

        doctorName1 = ScannerHelper.readString(scanner,
                "Doctor Name : ");

        specialization1 = ScannerHelper.readString(scanner,
                "Specialization : ");

        experience1 = ScannerHelper.readInteger(scanner,
                "Experience (Years): ");

        shift1 = ScannerHelper.readString(scanner,
                "Availability Shift : ");

        System.out.println();

        System.out.println("Enter Details of Doctor 2");

        doctorName2 = ScannerHelper.readString(scanner,
                "Doctor Name : ");

        specialization2 = ScannerHelper.readString(scanner,
                "Specialization : ");

        experience2 = ScannerHelper.readInteger(scanner,
                "Experience (Years): ");

        shift2 = ScannerHelper.readString(scanner,
                "Availability Shift : ");

        System.out.println();

        System.out.println("Enter Details of Doctor 3");

        doctorName3 = ScannerHelper.readString(scanner,
                "Doctor Name : ");

        specialization3 = ScannerHelper.readString(scanner,
                "Specialization : ");

        experience3 = ScannerHelper.readInteger(scanner,
                "Experience (Years): ");

        shift3 = ScannerHelper.readString(scanner,
                "Availability Shift : ");

        System.out.println();
        System.out.println("Doctor Details Registered Successfully.");

    }

    private static void displayDoctors() {

        System.out.println();

        System.out.println("============== DOCTOR LIST ==============");

        if (doctorName1.isEmpty()) {

            System.out.println("No Doctors Registered.");

            return;
        }

        System.out.println("------------------------------------------");
        System.out.println("Doctor 1");
        System.out.println("Name            : " + doctorName1);
        System.out.println("Specialization  : " + specialization1);
        System.out.println("Experience      : " + experience1 + " Years");
        System.out.println("Shift           : " + shift1);

        System.out.println("------------------------------------------");

        System.out.println("Doctor 2");
        System.out.println("Name            : " + doctorName2);
        System.out.println("Specialization  : " + specialization2);
        System.out.println("Experience      : " + experience2 + " Years");
        System.out.println("Shift           : " + shift2);

        System.out.println("------------------------------------------");

        System.out.println("Doctor 3");
        System.out.println("Name            : " + doctorName3);
        System.out.println("Specialization  : " + specialization3);
        System.out.println("Experience      : " + experience3 + " Years");
        System.out.println("Shift           : " + shift3);

        System.out.println("==========================================");

    }

}