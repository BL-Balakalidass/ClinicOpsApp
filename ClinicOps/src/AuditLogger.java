import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

public class AuditLogger {

    private static ArrayList<String> auditLogs = new ArrayList<>();

    private static final DateTimeFormatter FORMATTER =
            DateTimeFormatter.ofPattern("dd-MM-yyyy HH:mm:ss");

    /**
     * Adds a log entry.
     *
     * @param message Log message
     * @param level   INFO / ERROR / WARNING
     */
    public static void log(String message, String level) {

        String timestamp =
                LocalDateTime.now().format(FORMATTER);

        String logEntry =
                "[" + timestamp + "] "
                        + "[" + level.toUpperCase() + "] "
                        + message;

        auditLogs.add(logEntry);

    }

    /**
     * Displays all audit logs.
     */
    public static void displayLogs() {

        System.out.println();

        if (auditLogs.isEmpty()) {

            System.out.println("No Audit Logs Available.");

            return;

        }

        System.out.println("==============================================");
        System.out.println("              AUDIT LOGS");
        System.out.println("==============================================");

        for (String log : auditLogs) {

            System.out.println(log);

        }

        System.out.println("==============================================");

    }

}