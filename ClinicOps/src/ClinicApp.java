import java.util.Scanner;

public class ClinicApp {

    private static final int ROLE_ADMIN = 1;
    private static final int ROLE_FRONT_DESK = 2;
    private static final int EXIT = 3;

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        boolean exitSystem = false;

        System.out.println("==========================================");
        System.out.println("     WELCOME TO TOWNCLINIC");
        System.out.println(" Clinic Operations Management System");
        System.out.println("==========================================");

        while (!exitSystem) {

            System.out.println("\n========== MAIN MENU ==========");
            System.out.println("1. Clinic Administrator");
            System.out.println("2. Front Desk Executive");
            System.out.println("3. Exit");
            System.out.println("===============================");

            int choice = ScannerHelper.readInteger(scanner,
                    "Enter your choice: ");

            switch (choice) {

                case ROLE_ADMIN:
                    AdminMenu.showAdminMenu(scanner);
                    break;

                case ROLE_FRONT_DESK:
                    FrontDeskMenu.showFrontDeskMenu(scanner);
                    break;

                case EXIT:
                    System.out.println("\nThank you for using TownClinic.");
                    System.out.println("Have a Nice Day!");
                    exitSystem = true;
                    break;

                default:
                    System.out.println("\nInvalid Choice!");
                    System.out.println("Please enter 1, 2 or 3.");
            }
        }

        scanner.close();
    }
}