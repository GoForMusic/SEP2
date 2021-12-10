package shared.networking.serverInterfaces;

import shared.utils.roomType.RoomType;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface RoomTypeListServer extends Remote {
    void updateRoomType(shared.utils.roomType.RoomType roomType) throws RemoteException;
    RoomType getRoomType(String type) throws RemoteException;
    ArrayList<RoomType> getRoomTypes() throws RemoteException;

}
