// WAP to print the last modified date, content length, and
// content type of URL of your choice.

import java.io.IOException;
import java.net.HttpURLConnection;
import java.net.URL;

public class URLInfo {
    public static void main(String[] args) {
        String urlString = "http://example.com";
        

        try {
            HttpURLConnection connection = (HttpURLConnection) new URL(urlString).openConnection();

            long lastModified = connection.getLastModified();
            int contentLength = connection.getContentLength();
            String contentType = connection.getContentType();

            System.out.println("URL: " + urlString);
            System.out.println("Last Modified Date: " + (lastModified > 0 ? new java.util.Date(lastModified) : "Not available"));
            System.out.println("Content Length: " + (contentLength > 0 ? contentLength + " bytes" : "Not available"));
            System.out.println("Content Type: " + (contentType != null ? contentType : "Not available"));

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
