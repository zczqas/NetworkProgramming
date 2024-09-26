// You are given an IP address as “255.234.180.23”, WAP to check
//its address type, and its version (v4 or v6). java short and simple
import java.net.InetAddress;
import java.net.UnknownHostException;

public class IPAddressCheck {
    public static void main(String[] args) {
        String ip = "255.234.180.23";

        try {
            InetAddress inet = InetAddress.getByName(ip);

            if (inet instanceof java.net.Inet4Address) {
                System.out.println(ip + " is an IPv4 address.");
            } else if (inet instanceof java.net.Inet6Address) {
                System.out.println(ip + " is an IPv6 address.");
            } else {
                System.out.println("Unknown IP address type.");
            }
        } catch (UnknownHostException e) {
            System.out.println("Invalid IP address: " + ip);
        }
    }
}
