// You are given a URI “http://example.com” and a path
// “colleges/KCT”, now resolve them to form a complete URI.

import java.net.URI;
import java.net.URISyntaxException;

public class ResolveURI {
    public static void main(String[] args) {
        try {
            String baseUri = "http://example.com";
            String relativePath = "colleges/KCT";

            URI base = new URI(baseUri);
            URI resolvedUri = base.resolve(relativePath);


            System.out.println("Complete URI: " + resolvedUri);

        } catch (URISyntaxException e) {
            e.printStackTrace();
        }
    }
}
