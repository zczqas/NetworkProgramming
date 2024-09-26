import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.net.Socket;

public class FactorialClient {
    public static void main(String[] args) {
        try (Socket socket = new Socket("localhost", 1234);
             BufferedReader consoleInput = new BufferedReader(new InputStreamReader(System.in));
             PrintWriter out = new PrintWriter(socket.getOutputStream(), true);
             BufferedReader in = new BufferedReader(new InputStreamReader(socket.getInputStream()))) {

            System.out.print("Enter an integer: ");
            int number = Integer.parseInt(consoleInput.readLine());

            out.println(number);
            String result = in.readLine();
            System.out.println("Factorial of " + number + " is: " + result);

        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
