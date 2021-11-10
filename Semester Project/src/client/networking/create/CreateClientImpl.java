package client.networking.create;

import shared.networking.serverInterfaces.Server;

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
    public boolean isConnectionPossible(String username) {
        try {
           return server.getCreateAccountServer().doesUsernameExists(username);
        } catch (RemoteException e) {
            e.printStackTrace();
            throw new RuntimeException("Cannot contact the server");
        }
    }

    @Override
    public String addUser(String firstname, String lastname, String username, String password) {
        return null;
    }
}
