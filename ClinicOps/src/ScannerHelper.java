import java.util.Scanner;

public class ScannerHelper {

    /**
     * Reads an integer from the user.
     * Keeps asking until a valid integer is entered.
     *
     * @param scanner Scanner object
     * @param message Prompt message
     * @return Valid integer entered by user
     */
    public static int readInteger(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            try {
                int value = Integer.parseInt(scanner.nextLine());
                return value;

            } catch (NumberFormatException e) {

                System.out.println("---------------------------------------");
                System.out.println("Invalid Input!");
                System.out.println("Please enter a valid numeric value.");
                System.out.println("---------------------------------------");
            }
        }
    }
}