// WAP to print all the network interfaces available in a machine
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.Enumeration;

public class NetworkInterfacesInfo {
    public static void main(String[] args) {
        try {
            Enumeration<NetworkInterface> interfaces = NetworkInterface.getNetworkInterfaces();
            while (interfaces.hasMoreElements()) {
                NetworkInterface netInterface = interfaces.nextElement();
                System.out.println("Interface: " + netInterface.getName());
                System.out.println("Display name: " + netInterface.getDisplayName());
                System.out.println("--------------------");
            }
        } catch (SocketException e) {
            System.out.println("Error: " + e.getMessage());
        }
    }
}