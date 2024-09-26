// WAP to get the network interface associated with “127.0.0.1” and
// print the short and full name of it.

import java.net.InetAddress;
import java.net.NetworkInterface;

public class LoopbackInterfaceInfo {
    public static void main(String[] args) {
        try {
            InetAddress loopbackAddr = InetAddress.getByName("127.0.0.1");

            NetworkInterface loopbackInterface = NetworkInterface.getByInetAddress(loopbackAddr);

            if (loopbackInterface != null) {
                System.out.println("Short name: " + loopbackInterface.getName());
                System.out.println("Full name: " + loopbackInterface.getDisplayName());
            } else {
                System.out.println("No interface found for 127.0.0.1");
            }
        } catch (Exception e) {
            System.out.println("An error occurred: " + e.getMessage());
        }
    }
}