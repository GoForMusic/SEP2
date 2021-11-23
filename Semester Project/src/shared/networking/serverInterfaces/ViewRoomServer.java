package shared.networking.serverInterfaces;

import client.networking.viewRooms.ViewRoomImp;
import shared.networking.clientInterfaces.RoomsCallBack;
import shared.utils.Subject;
import shared.utils.room.RoomType;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;

public interface ViewRoomServer extends Remote {

    void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) throws RemoteException;

    String getDescriptionByCategory(RoomType roomType) throws RemoteException;

    String getPriceByCategory(RoomType roomType) throws RemoteException;

    void registerViewRoomClient(RoomsCallBack roomsCallBack) throws RemoteException;
}
