import javax.net.ssl.SSLServerSocket;
import javax.net.ssl.SSLServerSocketFactory;
import java.io.BufferedWriter;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.net.Socket;

public class SecureServer {
    public static void main(String[] args) {
        int port = 12345;  // Port number where the server will listen

        try {
            // Create an SSLServerSocket that listens on the specified port
            SSLServerSocketFactory factory = (SSLServerSocketFactory) SSLServerSocketFactory.getDefault();
            SSLServerSocket serverSocket = (SSLServerSocket) factory.createServerSocket(port);

            // Set the enabled protocols and cipher suites
            serverSocket.setEnabledProtocols(new String[]{"TLSv1.2"});
            serverSocket.setEnabledCipherSuites(new String[]{"TLS_ECDHE_RSA_WITH_AES_128_GCM_SHA256"});

            System.out.println("Secure server started and is listening on port " + port);

            // Continuously accept client connections
            while (true) {
                try {
                    // Accept a connection from a client
                    Socket clientSocket = serverSocket.accept();
                    System.out.println("New client connected from " + clientSocket.getInetAddress().getHostAddress());

                    // Create a BufferedWriter to send data to the client
                    BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(clientSocket.getOutputStream()));

                    // Send a message to the client
                    writer.write("Hello, client! Welcome to the secure server.\n");
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
            System.err.println("Secure server failed to start: " + e.getMessage());
        }
    }
}