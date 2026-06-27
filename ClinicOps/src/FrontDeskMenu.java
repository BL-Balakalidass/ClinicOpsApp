import java.util.Scanner;

public class FrontDeskMenu {

    private static final int PATIENT_REGISTRATION = 1;
    private static final int BOOK_APPOINTMENT = 2;
    private static final int LOGOUT = 3;

    public static void showFrontDeskMenu(Scanner scanner) {

        boolean logout = false;

        while (!logout) {

            System.out.println();
            System.out.println("==================================");
            System.out.println("   FRONT DESK EXECUTIVE MENU");
            System.out.println("==================================");
            System.out.println("1. Patient Registration");
            System.out.println("2. Book Appointment");
            System.out.println("3. Logout");
            System.out.println("==================================");

            int choice = ScannerHelper.readInteger(scanner,
                    "Enter your choice: ");

            switch (choice) {

                case PATIENT_REGISTRATION:
                    System.out.println();
                    System.out.println("Patient Registration");
                    System.out.println("Feature will be implemented in UC3.");
                    break;

                case BOOK_APPOINTMENT:
                    System.out.println();
                    System.out.println("Book Appointment");
                    System.out.println("Feature will be implemented in UC4.");
                    break;

                case LOGOUT:
                    System.out.println();
                    System.out.println("Logging out from Front Desk Executive...");
                    logout = true;
                    break;

                default:
                    System.out.println();
                    System.out.println("Invalid Choice!");
                    System.out.println("Please select between 1 and 3.");
            }
        }
    }
}