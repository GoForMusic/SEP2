package server.networking;


import shared.networking.serverInterfaces.CreateAccountServer;
import shared.networking.serverInterfaces.LoginServer;
import shared.networking.serverInterfaces.Server;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server {

    private LoginServer loginServer;
    private CreateAccountServer createAccountServer;

    public ServerImpl(LoginServer loginServer,CreateAccountServer createAccountServer) throws RemoteException {
        this.loginServer = loginServer;
        this.createAccountServer=createAccountServer;
        UnicastRemoteObject.exportObject(this,0);
    }

    public void startServer() throws AlreadyBoundException, RemoteException {
        Registry registry= LocateRegistry.createRegistry(1099);
        registry.bind("Server",this);
        System.out.println("Server started.....");
    }

    @Override
    public LoginServer getLoginServer() throws RemoteException {
        return loginServer;
    }

    @Override
    public CreateAccountServer getCreateAccountServer() throws RemoteException {
        return createAccountServer;
    }
}
