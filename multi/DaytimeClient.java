import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class DaytimeClient {
    public static void main(String[] args) {
        String hostname = "localhost"; // Server address
        int port = 8080;

        try (Socket socket = new Socket(hostname, port);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {
            String serverTime = in.readLine();
            System.out.println("Server responded with: " + serverTime);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
