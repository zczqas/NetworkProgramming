import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.HttpURLConnection;
import java.net.InetSocketAddress;
import java.net.Proxy;
import java.net.URL;

public class ProxyDownload {
    public static void main(String[] args) {
        String webPageUrl = "http://www.example.com";  // Webpage URL to download
        String proxyHost = "proxy.example.com";        // Proxy host
        int proxyPort = 8080;                          // Proxy port

        try {
            // Create a URL object
            URL url = new URL(webPageUrl);

            // Create a proxy object
            Proxy proxy = new Proxy(Proxy.Type.HTTP, new InetSocketAddress(proxyHost, proxyPort));

            // Open a connection to the URL using the proxy
            HttpURLConnection connection = (HttpURLConnection) url.openConnection(proxy);

            // Set request method (GET in this case)
            connection.setRequestMethod("GET");

            // Get input stream from the connection and read the web page
            BufferedReader reader = new BufferedReader(new InputStreamReader(connection.getInputStream()));

            // Prepare to save the web page content
            PrintWriter writer = new PrintWriter("downloaded_page.html");

            // Read the web page line by line and write to a file
            String inputLine;
            while ((inputLine = reader.readLine()) != null) {
                writer.println(inputLine);
            }

            // Close resources
            reader.close();
            writer.close();

            System.out.println("Web page downloaded successfully through the proxy!");

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
