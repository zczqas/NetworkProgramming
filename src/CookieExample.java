import java.net.CookieManager;
import java.net.CookieStore;
import java.net.HttpCookie;
import java.net.URI;
import java.util.List;

public class CookieExample {
    public static void main(String[] args) throws Exception {
        // Create a CookieManager and CookieStore
        CookieManager cookieManager = new CookieManager();
        CookieStore cookieStore = cookieManager.getCookieStore();

        // Create a new cookie for example.com
        HttpCookie cookie = new HttpCookie("username", "Sanchar Limbu");
        cookie.setDomain("example.com");
        cookie.setPath("/");

        // Add the cookie to the store
        cookieStore.add(new URI("http://example.com"), cookie);

        // Get cookies from the store for example.com
        List<HttpCookie> cookies = cookieStore.get(new URI("http://example.com"));

        // Print the cookies
        for (HttpCookie c : cookies) {
            System.out.println("Cookie: " + c.getName() + " = " + c.getValue());
        }
    }
}
