package shared.networking.serverInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    LoginServer getLoginServer() throws RemoteException;
    CreateAccountServer getCreateAccountServer() throws RemoteException;

}
