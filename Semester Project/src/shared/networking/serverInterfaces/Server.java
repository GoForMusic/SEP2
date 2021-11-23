package shared.networking.serverInterfaces;

import client.networking.viewRooms.ViewRoomImp;
import shared.networking.clientInterfaces.RoomsCallBack;

import java.rmi.AlreadyBoundException;
import java.rmi.Remote;
import java.rmi.RemoteException;

public interface Server extends Remote {
    LoginServer getLoginServer() throws RemoteException;
    CreateAccountServer getCreateAccountServer() throws RemoteException;
    void startServer() throws RemoteException, AlreadyBoundException;
    ViewRoomServer getViewRoomServer() throws RemoteException;
}
