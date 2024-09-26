import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Server {
    public static void main(String[] args) throws Exception {
        // Create the object
        HelloImpl obj = new HelloImpl();

        // Create and bind to the RMI registry
        Registry registry = LocateRegistry.createRegistry(1099);  // Default port 1099
        registry.rebind("Hello", obj);

        System.out.println("Server is ready.");
    }
}
