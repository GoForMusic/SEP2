package shared.networking.clientInterfaces;

import shared.utils.Subject;
import shared.utils.room.Room;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface RoomsCallBack extends Remote {
    void roomsFromServer(List<Room> roomListo) throws RemoteException;
}
