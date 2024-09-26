import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.ServerSocket;
import java.net.Socket;

public class ReadServerSocket {
    public static void main(String[] args) {
        int port = 12345;  // Port number where the server will listen

        try {
            // Create a ServerSocket that listens on the specified port
            ServerSocket serverSocket = new ServerSocket(port);
            System.out.println("Server started and is listening on port " + port);

            // Continuously accept client connections
            while (true) {
                try {
                    // Accept a connection from a client
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected from " + clientSocket.getInetAddress().getHostAddress());

                    // Create a BufferedWriter to send data to the client
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    // Send a message to the client
                    writer.write("Hello, client! Welcome to the server.\n");
                    writer.flush();  // Ensure data is sent

                    // Close the connection with the client
                    writer.close();
                    clientSocket.close();

                    System.out.println("Client disconnected");
                } catch (IOException e) {
                    System.err.println("Error handling client connection: " + e.getMessage());
                }
            }
        } catch (IOException e) {
            System.err.println("Server failed to start: " + e.getMessage());
        }
    }
}
