// WAP to print all the headers and its corresponding values
// present in any HTTP response

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;
import java.util.Map;

public class Headers {
    public static void main(String[] args) throws IOException {
        // Specify the URL you want to connect to
        URL url = new URL("https://www.example.com");

        // Open a connection to the URL
        HttpURLConnection connection = (HttpURLConnection) url.openConnection();

        // Make a GET request
        connection.setRequestMethod("GET");

        // Get all headers and print them
        Map<String, java.util.List<String>> headers = connection.getHeaderFields();
        for (Map.Entry<String, java.util.List<String>> header : headers.entrySet()) {
            System.out.println(header.getKey() + ": " + header.getValue());
        }
    }
}
