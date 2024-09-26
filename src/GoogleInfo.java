// WAP to print the hostname, hostaddress, port and protocol of www.google.com

import java.net.InetAddress;
import java.net.URL;

public class GoogleInfo {
    public static void main(String[] args) {
        try {
            URL url = new URL("https://www.google.com");
            InetAddress address = InetAddress.getByName(url.getHost());

            System.out.println("Hostname: " + url.getHost());
            System.out.println("Host Address: " + address.getHostAddress());
            System.out.println("Port: " + (url.getPort() == -1 ? url.getDefaultPort() : url.getPort()));
            System.out.println("Protocol: " + url.getProtocol());
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}