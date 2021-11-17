package server.networking;


import server.database.Employee.EmployeeRepository;
import server.database.Employee.EmployeeRepositoryImpl;
import shared.networking.serverInterfaces.CreateAccountServer;
import shared.networking.serverInterfaces.LoginServer;
import shared.networking.serverInterfaces.Server;
import shared.networking.serverInterfaces.ViewRoomServer;


import java.rmi.AlreadyBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.rmi.server.UnicastRemoteObject;
import java.sql.SQLException;

public class ServerImpl implements Server {

    private LoginServer loginServer;
    private CreateAccountServer createAccountServer;
    private ViewRoomServer viewRoomServer;

    public ServerImpl(LoginServer loginServer, CreateAccountServer createAccountServer, ViewRoomServer viewRoomServer) throws RemoteException {
        this.loginServer = loginServer;
        this.createAccountServer=createAccountServer;
        this.viewRoomServer=viewRoomServer;
        UnicastRemoteObject.exportObject(this,0);
    }

    public void startServer() throws AlreadyBoundException, RemoteException {
        Registry registry= LocateRegistry.createRegistry(1099);
        registry.bind("Server",this);
        System.out.println("Server started.....");
    }

    @Override
    public ViewRoomServer getViewRoomServer() throws RemoteException {
        return viewRoomServer;
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
