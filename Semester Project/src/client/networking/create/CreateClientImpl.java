package client.networking.create;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.User.User;

import java.rmi.RemoteException;

public class CreateClientImpl implements CreateClient {
    private Server server;

    public CreateClientImpl() {
        try {
            server = GetServer.getServerFromRmi();
        } catch (Exception e) {
            throw e;
        }
    }

    @Override
    public String addUser(String firstname, String lastname, String username, String password, String userType) {
        try {
            return server.getCreateAccountServer().addUser(firstname,lastname,username,password,userType);
        } catch (RemoteException e) {
            return "Cannot connect to server";
        }
    }
}
