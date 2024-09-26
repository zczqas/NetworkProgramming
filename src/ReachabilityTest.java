import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.NetworkInterface;
import java.net.URL;

public class ReachabilityTest {
    public static void main(String[] args) throws IOException {
        String url = "https://example.com";  // Replace with your URL
        // Get the loopback interface "lo"
        NetworkInterface loInterface = NetworkInterface.getByName("lo");

        // Check if the interface exists and is up
        if (loInterface != null && loInterface.isUp()) {
            // Set a timeout of 2 seconds
            HttpURLConnection connection = (HttpURLConnection) new URL(url).openConnection();
            connection.setConnectTimeout(2000); // 2 seconds timeout
            connection.connect();

            // Check if the connection is successful
            if (connection.getResponseCode() == 200) {
                System.out.println("URL is reachable through 'lo' interface.");
            } else {
                System.out.println("URL is not reachable.");
            }
        } else {
            System.out.println("'lo' interface is not available or not up.");
        }
    }
}
