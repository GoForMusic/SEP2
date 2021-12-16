package shared.networking.serverInterfaces;

import shared.networking.clientInterfaces.RoomsCallBack;
import shared.utils.Request;
import shared.utils.reservation.Reservation;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public interface RoomServer extends Remote {

    ArrayList<Room> getRooms() throws RemoteException;

    void updateRoom(Room room) throws RemoteException;

    Request searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) throws RemoteException;

    String getDescriptionByCategory(RoomType roomType) throws RemoteException;

    String getPriceByCategory(RoomType roomType) throws RemoteException;

    void registerRoomClient(RoomsCallBack roomsCallBack) throws RemoteException;

    Request bookRoom(Reservation reservation) throws RemoteException;

    Request searchByUsername(String username) throws RemoteException;

    Request updateReservation(String username, LocalDate previousStart, LocalDate previousEnd, String roomName, LocalDate newStart, LocalDate newEnd, String newRoom) throws RemoteException;

    Request removeReservation(int id) throws RemoteException;

    Request createRoom(Room room) throws  RemoteException;
}
