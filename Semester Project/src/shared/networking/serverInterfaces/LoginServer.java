package shared.networking.serverInterfaces;

import shared.utils.User.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface LoginServer extends Remote {
    String  isLoginPossible(User user) throws RemoteException;

}
