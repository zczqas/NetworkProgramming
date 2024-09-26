// WAP to print get the localhost of a system, also get the network
// interface of “localhost”

import java.net.InetAddress;
import java.net.NetworkInterface;

public class LocalhostInfo {
    public static void main(String[] args) {
        try {
            InetAddress localhost = InetAddress.getLocalHost();
            System.out.println("Localhost: " + localhost.getHostAddress());

            NetworkInterface ni = NetworkInterface.getByInetAddress(localhost);
            if (ni != null) {
                System.out.println("Interface name: " + ni.getName());
                System.out.println("Display name: " + ni.getDisplayName());
            } else {
                System.out.println("No network interface found for localhost");
            }
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}