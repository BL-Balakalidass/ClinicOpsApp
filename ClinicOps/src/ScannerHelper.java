import java.util.Scanner;

public class ScannerHelper {

    /**
     * Reads an integer from the user.
     */
    public static int readInteger(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            try {
                return Integer.parseInt(scanner.nextLine());

            } catch (NumberFormatException e) {

                System.out.println("Invalid input! Please enter a valid number.");
            }
        }
    }

    /**
     * Reads a non-empty string.
     */
    public static String readString(Scanner scanner, String message) {

        while (true) {

            System.out.print(message);

            String value = scanner.nextLine().trim();

            if (!value.isEmpty()) {
                return value;
            }

            System.out.println("Input cannot be empty.");
        }
    }

    public static <T extends Enum<T>> T readEnumChoice(
            Scanner scanner,
            String message,
            T[] values) {

        while (true) {

            System.out.println();
            System.out.println(message);

            for (int i = 0; i < values.length; i++) {

                System.out.println((i + 1) + ". " + values[i]);
            }

            int choice = readInteger(scanner, "Enter Choice : ");

            if (choice >= 1 && choice <= values.length) {

                return values[choice - 1];
            }

            System.out.println("Invalid Choice.");
        }

    }

}