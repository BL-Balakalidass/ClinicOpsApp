import java.util.Scanner;

public class ScannerHelper {

    /**
     * Appointment Slots
     * Morning : 8 Slots
     * Evening : 8 Slots
     */
    private static final String[] APPOINTMENT_SLOTS = {

            "09:00 AM",
            "09:30 AM",
            "10:00 AM",
            "10:30 AM",
            "11:00 AM",
            "11:30 AM",
            "12:00 PM",
            "12:30 PM",

            "04:00 PM",
            "04:30 PM",
            "05:00 PM",
            "05:30 PM",
            "06:00 PM",
            "06:30 PM",
            "07:00 PM",
            "07:30 PM"
    };

    /**
     * Reads Menu Integer
     */
    public static int readInteger(Scanner scanner,
                                  String message) {

        while (true) {

            try {

                System.out.print(message);

                int value =
                        Integer.parseInt(scanner.nextLine());

                return value;

            } catch (NumberFormatException e) {

                System.out.println("Please enter a valid integer.");

            }

        }

    }

    /**
     * Reads Non Empty String
     */
    public static String readString(Scanner scanner,
                                    String message) {

        while (true) {

            System.out.print(message);

            String input =
                    scanner.nextLine().trim();

            if (!input.isEmpty()) {

                return input;

            }

            System.out.println("Input cannot be empty.");

        }

    }

    /**
     * Reads Indian Mobile Number
     */
    public static String readMobileNumber(
            Scanner scanner,
            String message) {

        while (true) {

            System.out.print(message);

            String mobile =
                    scanner.nextLine().trim();

            if (mobile.matches("^[6-9]\\d{9}$")) {

                invalidMobileAttempts = 0;

                return mobile;

            }

            invalidMobileAttempts++;

            System.out.println(
                    "Invalid Indian Mobile Number.");

            AuditLogger.logWarning(
                    "Invalid Mobile Number Entered : "
                            + mobile);

            if (invalidMobileAttempts
                    >= MAX_INVALID_MOBILE_ATTEMPTS) {

                AuditLogger.logError(
                        "SECURITY ALERT : "
                                + invalidMobileAttempts
                                + " consecutive invalid mobile numbers entered.");

            }

        }

    }

    /**
     * Generic Enum Reader
     */
    public static <T extends Enum<T>> T readEnumChoice(
            Scanner scanner,
            Class<T> enumClass,
            String message) {

        T[] values = enumClass.getEnumConstants();

        while (true) {

            System.out.println();

            System.out.println(message);

            for (int i = 0; i < values.length; i++) {

                System.out.println((i + 1) + ". " + values[i]);

            }

            int choice =
                    readInteger(scanner,
                            "Enter Choice : ");

            if (choice >= 1 &&
                    choice <= values.length) {

                return values[choice - 1];

            }

            System.out.println("Invalid Choice.");

        }

    }

    /**
     * Displays Appointment Slots
     */
    private static void displayAppointmentSlots() {

        System.out.println();

        System.out.println("Available Appointment Slots");

        System.out.println("--------------------------------");

        for (int i = 0; i < APPOINTMENT_SLOTS.length; i++) {

            System.out.printf("%2d. %s%n",
                    i + 1,
                    APPOINTMENT_SLOTS[i]);

        }

        System.out.println("--------------------------------");

    }

    /**
     * Read Appointment Slot
     */
    public static String readAppointmentSlot(
            Scanner scanner) {

        while (true) {

            displayAppointmentSlots();

            int choice =
                    readInteger(scanner,
                            "Select Slot : ");

            if (choice >= 1 &&
                    choice <= APPOINTMENT_SLOTS.length) {

                return APPOINTMENT_SLOTS[choice - 1];

            }

            System.out.println("Invalid Slot Selection.");

        }

    }


    private static final int MAX_INVALID_MOBILE_ATTEMPTS = 3;

    private static int invalidMobileAttempts = 0;

}