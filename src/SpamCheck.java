// WAP to check if a given ip address is marked as spammer or is legit.

import java.net.InetAddress;

public class SpamCheck {
    public static void main(String[] args) {
        String ipToCheck = "142.250.207.196";
        checkIP(ipToCheck);
    }


    public static void checkIP(String ip) {
        try {
            String[] octets = ip.split("\\.");
            String reversedIP = octets[3] + "." + octets[2] + "." + octets[1] + "." + octets[0];

            String query = reversedIP + ".sbl.spamhaus.org";

            InetAddress.getByName(query);

            System.out.println("The IP " + ip + " is listed as potentially malicious.");
        } catch (java.net.UnknownHostException e) {
            System.out.println("The IP " + ip + " is not listed and appears to be legitimate.");
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}