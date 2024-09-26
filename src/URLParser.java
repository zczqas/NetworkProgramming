// WAP to print scheme, authority, port, path, section, and query
// string of http://example.com:7880/en/4.2/querysets/?q=query#queryset-api

import java.net.URI;
import java.net.URISyntaxException;

public class URLParser {
    public static void main(String[] args) throws URISyntaxException {
        String urlString = "http://example.com:7880/en/4.2/querysets/?q=query#queryset-api";
        URI url = new URI(urlString);
        System.out.println("Scheme: " + url.getScheme());
        System.out.println("Authority: " + url.getAuthority());
        System.out.println("Port: " + url.getPort());
        System.out.println("Path: " + url.getPath());
        System.out.println("Query: " + url.getQuery());
        System.out.println("Fragment: " + url.getFragment());

    }
}
