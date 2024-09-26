import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

// Server class implementing the remote interface
public class HelloImpl extends UnicastRemoteObject implements Hello {

    // Constructor
    protected HelloImpl() throws RemoteException {
        super();
    }

    // Method implementation
    public String sayHello() throws RemoteException {
        return "Hi from server!";
    }
}
