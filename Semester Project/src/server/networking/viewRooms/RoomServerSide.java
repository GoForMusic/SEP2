package server.networking.viewRooms;

import server.model.viewRooms.RoomHandler;
import shared.networking.clientInterfaces.RoomsCallBack;
import shared.networking.serverInterfaces.RoomServer;
import shared.utils.Observer;
import shared.utils.Request;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.beans.PropertyChangeEvent;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
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
    public void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
       // System.out.println("Reached server...");
        roomHandler.searchRoom(dateFrom, dateTo, roomType);
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
    public Request bookRoom(String username, List<Room> selectedRooms, LocalDate startDate, LocalDate endDate) {
        return roomHandler.bookRoom(username,selectedRooms,startDate,endDate);
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
