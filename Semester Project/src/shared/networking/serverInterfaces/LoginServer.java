package shared.networking.serverInterfaces;

import shared.utils.Request;
import shared.utils.User.User;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.SQLException;

public interface LoginServer extends Remote {
    Request isLoginPossible(String username, String password) throws RemoteException;

}
