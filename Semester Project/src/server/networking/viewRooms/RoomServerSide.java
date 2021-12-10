package server.networking.viewRooms;

import server.model.rooms.RoomHandler;
import shared.networking.clientInterfaces.RoomsCallBack;
import shared.networking.serverInterfaces.RoomServer;
import shared.utils.Observer;
import shared.utils.Request;
import shared.utils.reservation.Reservation;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomServerSide implements RoomServer {

    private RoomHandler roomHandler;

    private RoomsCallBack roomsCallBack;

    public RoomServerSide(RoomHandler roomHandler) throws RemoteException {
        this.roomHandler = roomHandler;
        UnicastRemoteObject.exportObject(this, 0);
        roomHandler.addListener(Observer.AVAILABLEROOMS.toString(), this::fireAvailableRooms);
    }

    @Override
    public ArrayList<Room> getRooms() {
        return roomHandler.getRooms();
    }

    @Override
    public void updateRoom(Room room) {
        roomHandler.updateRoom(room);
    }

    @Override
    public Request searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
       // System.out.println("Reached server...");
       return roomHandler.searchRoom(dateFrom, dateTo, roomType);
    }

    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        return roomHandler.getDescriptionByCategory(roomType);
    }

    @Override
    public String getPriceByCategory(RoomType roomType) {
        return roomHandler.getPriceByCategory(roomType);
    }

    @Override
    public void registerRoomClient(RoomsCallBack roomsCallBack) {
        this.roomsCallBack=roomsCallBack;
    }

    @Override
    public Request bookRoom(Reservation reservation) {
        System.out.println("server room");
        return roomHandler.bookRoom(reservation);
    }

    @Override
    public Request searchByUsername(String username) {
     return  roomHandler.searchByUsername(username);
    }

    @Override
    public Request updateReservation(String username, LocalDate previousStart, LocalDate previousEnd, String roomName, LocalDate newStart, LocalDate newEnd, String newRoom) {
     return    roomHandler.updateReservation(username,previousStart,previousEnd,roomName,newStart,newEnd,newRoom);
    }

    @Override public Request removeReservation(int id)
    {
        return roomHandler.removeReservation(id);
    }

    @Override
    public Request createRoom(Room room) throws RemoteException {
        return roomHandler.createRoom(room);
    }

    private void fireAvailableRooms(PropertyChangeEvent event) {
        try {
          //  System.out.println("\n\n\n "+event.getNewValue());
            roomsCallBack.roomsFromServer((List<Room>) event.getNewValue());
        } catch (RemoteException e) {
            throw new RuntimeException("Error in server");
        }

    }

}
