package shared.networking.serverInterfaces;

import shared.utils.User.User;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface CreateAccountServer extends Remote {
    String addUser(User user) throws RemoteException;
}
