package client.networking.login;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.User.User;

import java.rmi.RemoteException;

public class LoginClientImpl implements LoginClient{

    private Server server;

    public LoginClientImpl(){
      server = GetServer.getServerFromRmi();
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
