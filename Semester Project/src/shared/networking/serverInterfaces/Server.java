package shared.networking.serverInterfaces;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    LoginServer getLoginServer() throws RemoteException;
    CreateAccountServer getCreateAccountServer() throws RemoteException;
    void startServer() throws RemoteException, AlreadyBoundException;
    RoomServer getRoomsServer() throws RemoteException;
    CustomerListServer getCustomerListServer() throws RemoteException;
    ChatServer getChatServer() throws RemoteException;
}
