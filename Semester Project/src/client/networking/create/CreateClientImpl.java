package client.networking.create;

import shared.networking.serverInterfaces.Server;
import shared.utils.User.User;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class CreateClientImpl implements CreateClient {
    private Server server;

    public CreateClientImpl() {
        Registry registry = null;
        try {
            registry = LocateRegistry.getRegistry(1099);
            server = (Server) registry.lookup("Server");
        } catch (RemoteException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }

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
