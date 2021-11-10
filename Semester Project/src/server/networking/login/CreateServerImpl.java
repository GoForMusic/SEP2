package server.networking.login;

import server.model.create.CreateHandler;
import shared.networking.serverInterfaces.CreateAccountServer;
import shared.utils.User;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CreateServerImpl implements CreateAccountServer {

   private CreateHandler createHandler;

    public CreateServerImpl(CreateHandler createHandler) throws RemoteException {
        this.createHandler = createHandler;
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public boolean addUser(User user) throws RemoteException {
      return createHandler.addUser(user);
    }

    @Override
    public boolean doesUsernameExists(String username) throws RemoteException {
       return createHandler.doesUsernameExists(username);
    }
}
