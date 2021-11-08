package server.networking.login;

import shared.networking.serverInterfaces.CreateAccountServer;
import shared.networking.serverInterfaces.LoginServer;
import shared.utils.User;

import java.rmi.RemoteException;

public class LoginServerImpl implements CreateAccountServer, LoginServer {


    @Override
    public boolean addUser(User user) throws RemoteException {
//        if (isConnectionPossible(user))
//      // return Database.addUser(user);
        return false;
    }

    @Override
    public boolean doesUsernameExists(String username) throws RemoteException {
//        return Database.doesUsernameExists(username);
        return false;
    }

    @Override
    public boolean isConnectionPossible(String username) {
//        return DataBase.isConnectionPossible(user);

        return false;
    }

    @Override
    public String isLoginPossible(User user) {
      return null;
    }
}
