package shared.networking.serverInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CreateAccountServer extends Remote {
    boolean addUser(User user) throws RemoteException;
    boolean doesUsernameExists(String username) throws RemoteException;

}
