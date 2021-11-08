package shared.networking.serverInterfaces;

import shared.utils.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface LoginServer extends Remote {
    boolean isConnectionPossible(String username) throws RemoteException;
    String  isLoginPossible(User user) throws RemoteException;

}
