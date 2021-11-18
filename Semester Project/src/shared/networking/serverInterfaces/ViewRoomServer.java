package shared.networking.serverInterfaces;

import shared.utils.RoomType;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

public interface ViewRoomServer extends Remote {

    void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) throws RemoteException;

    String getDescriptionByCategory(RoomType roomType);

    double getPriceByCategory(RoomType roomType);
}
