package server.networking.login;

import server.model.login.LoginHandler;
import shared.networking.serverInterfaces.LoginServer;
import shared.utils.Request;
import shared.utils.User.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class LoginServerImpl implements LoginServer {
    private LoginHandler loginHandler;

    public LoginServerImpl(LoginHandler loginHandler) throws RemoteException {
        this.loginHandler = loginHandler;
        UnicastRemoteObject.exportObject(this, 0);

    }

    @Override
    public Request isLoginPossible(String username, String password) {
        return loginHandler.login( username, password);
    }
}
