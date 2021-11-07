package shared.networking.serverInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginServer extends Remote {
    boolean isConnectionPossible(User user) throws RemoteException;
    String  isLoginPossible(User user) throws RemoteException;

}
