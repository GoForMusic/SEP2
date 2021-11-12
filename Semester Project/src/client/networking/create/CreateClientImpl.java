package client.networking.create;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.User.User;

import java.rmi.RemoteException;

public class CreateClientImpl implements CreateClient {
    private Server server;

    public CreateClientImpl() {
           server = GetServer.getServerFromRmi();
    }
    @Override
    public String addUser(User user) {
        try {
            return server.getCreateAccountServer().addUser(user);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot connect to the server");
        }
    }
}
