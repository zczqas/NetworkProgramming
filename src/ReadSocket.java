import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.net.Socket;

public class ReadSocket {
    public static void main(String[] args) {
        String hostname = "localhost";
        int port = 12345;

        try (Socket socket = new Socket(hostname, port);
             BufferedReader reader = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            String line;
            while ((line = reader.readLine()) != null) {
                System.out.println("Received: " + line);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}