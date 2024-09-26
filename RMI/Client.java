import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main(String[] args) throws Exception {
        // Locate the registry and get the remote object
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        Hello stub = (Hello) registry.lookup("Hello");

        // Call the remote method
        String response = stub.sayHello();
        System.out.println("Response: " + response);
    }
}

