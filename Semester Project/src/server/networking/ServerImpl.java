package server.networking;


import shared.networking.serverInterfaces.*;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;

public class ServerImpl implements Server {

    private LoginServer loginServer;
    private CreateAccountServer createAccountServer;
    private RoomServer roomServer;
    private CustomerListServer customerListServer;

    public ServerImpl(LoginServer loginServer, CreateAccountServer createAccountServer, RoomServer roomServer, CustomerListServer customerListServer) throws RemoteException {
        this.loginServer = loginServer;
        this.createAccountServer=createAccountServer;
        this.roomServer = roomServer;
        this.customerListServer = customerListServer;
        UnicastRemoteObject.exportObject(this,0);
    }

    public void startServer() throws AlreadyBoundException, RemoteException {
        Registry registry= LocateRegistry.createRegistry(1099);
        registry.bind("Server",this);
        System.out.println("Server started.....");
    }

    @Override
    public RoomServer getRoomsServer() throws RemoteException {
        return roomServer;
    }

    @Override
    public CustomerListServer getCustomerListServer() throws RemoteException {
        return customerListServer;
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
