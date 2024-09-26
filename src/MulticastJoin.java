import java.net.DatagramPacket;
import java.net.InetAddress;
import java.net.MulticastSocket;

public class MulticastJoin {
    public static void main(String[] args) {
        String multicastAddress = "224.0.0.1";
        int port = 5000;

        try (MulticastSocket socket = new MulticastSocket(port)) {
            InetAddress group = InetAddress.getByName(multicastAddress);
            socket.joinGroup(group);

            System.out.println("Joined the multicast group: " + multicastAddress);

            byte[] buffer = new byte[256];
            DatagramPacket packet = new DatagramPacket(buffer, buffer.length);

            socket.receive(packet);
            String receivedMessage = new String(packet.getData(), 0, packet.getLength());
            System.out.println("Message received: " + receivedMessage);

            // Leave the group (optional)
            socket.leaveGroup(group);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
