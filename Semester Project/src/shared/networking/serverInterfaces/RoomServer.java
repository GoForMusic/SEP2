package shared.networking.serverInterfaces;

import shared.networking.clientInterfaces.RoomsCallBack;
import shared.utils.Request;
import shared.utils.reservation.Reservation;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.List;

public interface RoomServer extends Remote {

    void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) throws RemoteException;

    String getDescriptionByCategory(RoomType roomType) throws RemoteException;

    String getPriceByCategory(RoomType roomType) throws RemoteException;

    void registerRoomClient(RoomsCallBack roomsCallBack) throws RemoteException;

    Request bookRoom(Reservation reservation);
}
