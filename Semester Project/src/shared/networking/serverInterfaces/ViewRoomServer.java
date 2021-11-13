package shared.networking.serverInterfaces;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

public interface ViewRoomServer extends Remote {

    void searchRooms(LocalDate dateFrom, LocalDate dateTo, String category) throws RemoteException;

}
