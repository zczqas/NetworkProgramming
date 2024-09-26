import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

public class WebLogProcessor {

    public static void main(String[] args) throws IOException {
        // Path to the web log file
        String logFilePath = "weblog.txt";

        BufferedReader br = new BufferedReader(new FileReader(logFilePath));
        String line;
        while ((line = br.readLine()) != null) {
            processLogEntry(line);
        }
    } 

    // Simple processing of each log entry (for now, we just print it)
    private static void processLogEntry(String logEntry) {
        System.out.println("Log Entry: " + logEntry);
    }
}
