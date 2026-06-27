import java.util.Scanner;

public class AdminMenu {

    private static final int DOCTOR_ENTRY = 1;
    private static final int BULK_ENTRY = 2;
    private static final int AUDIT_LOG = 3;
    private static final int LOGOUT = 4;

    public static void showAdminMenu(Scanner scanner) {

        boolean logout = false;

        while (!logout) {

            System.out.println();
            System.out.println("==================================");
            System.out.println("      CLINIC ADMIN MENU");
            System.out.println("==================================");
            System.out.println("1. Doctor's Data Entry");
            System.out.println("2. Bulk Data Entry");
            System.out.println("3. View Audit Logs");
            System.out.println("4. Logout");
            System.out.println("==================================");

            int choice = ScannerHelper.readInteger(scanner,
                    "Enter your choice: ");

            switch (choice) {

                case DOCTOR_ENTRY:
                    System.out.println();
                    System.out.println("Doctor Data Entry");
                    System.out.println("Feature will be implemented in UC2.");
                    break;

                case BULK_ENTRY:
                    System.out.println();
                    System.out.println("Bulk Doctor Import");
                    System.out.println("Feature will be implemented in future UC.");
                    break;

                case AUDIT_LOG:
                    System.out.println();
                    System.out.println("Audit Logs");
                    System.out.println("Feature will be implemented in future UC.");
                    break;

                case LOGOUT:
                    System.out.println();
                    System.out.println("Logging out from Clinic Administrator...");
                    logout = true;
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid Choice!");
                    System.out.println("Please select between 1 and 4.");
            }
        }
    }
}