package client.networking;

import client.model.login.LoginModel;
import client.model.login.LoginModelImpl;
import shared.networking.serverInterfaces.Server;
import shared.utils.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class LoginClientImpl implements LoginClient{

    private Server server;

    public LoginClientImpl(){
        try {
            Registry registry = LocateRegistry.getRegistry(1099);
            server =(Server) registry.lookup("Server");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }
    }

    @Override
    public boolean isConnectionPossible(String username) {
        try {
            return server.getLoginServer().isConnectionPossible(username);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return false;
    }

    @Override
    public String isLoginPossible(User user) {
        try {
            return server.getLoginServer().isLoginPossible(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
