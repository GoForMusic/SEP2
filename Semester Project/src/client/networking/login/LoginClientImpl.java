package client.networking.login;

import shared.networking.serverInterfaces.Server;
import shared.utils.User.User;

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
    public String isLoginPossible(User user) {
        try {
            return server.getLoginServer().isLoginPossible(user);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
