package server.networking.login;

import shared.networking.serverInterfaces.CreateAccountServer;
import shared.networking.serverInterfaces.LoginServer;

import java.rmi.RemoteException;

public class LoginServerImpl implements CreateAccountServer, LoginServer {


    @Override
    public boolean addUser(User user) throws RemoteException {
//        if (isConnectionPossible(user))
//      // return Database.addUser(user);
    }

    @Override
    public boolean doesUsernameExists(String username) throws RemoteException {
//        return Database.doesUsernameExists(username);
    }

    @Override
    public boolean isConnectionPossible(User user) {
        return DataBase.isConnectionPossible(user);
    }

    @Override
    public String isLoginPossible(User user) {
        try {
            String result = DataBase.isLoginPossible(user);
            return  result;
        } catch (Exception e) {
            e.printStackTrace();
            return e.getMessage();
        }
    }
}
