package server.networking.login;

import server.model.login.LoginHandler;
import shared.networking.serverInterfaces.LoginServer;
import shared.utils.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class LoginServerImpl implements LoginServer {
    private LoginHandler loginHandler;

    public LoginServerImpl(LoginHandler loginHandler) throws RemoteException {
        this.loginHandler = loginHandler;
        UnicastRemoteObject.exportObject(this, 0);

    }

    @Override
    public String isLoginPossible(User user) {
        String result = loginHandler.isLoginPossible(user);
        return result;
    }
}
