package server.networking.viewRooms;

import server.model.viewRooms.ViewRoomHandler;
import shared.networking.clientInterfaces.RoomsCallBack;
import shared.networking.serverInterfaces.ViewRoomServer;
import shared.utils.Observer;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;

public class ViewRoomServerSide implements ViewRoomServer {

    private ViewRoomHandler viewRoomHandler;

    private RoomsCallBack roomsCallBack;

    public ViewRoomServerSide(ViewRoomHandler viewRoomHandler) throws RemoteException {
        this.viewRoomHandler = viewRoomHandler;
        UnicastRemoteObject.exportObject(this, 0);
        viewRoomHandler.addListener(Observer.AVAILABLEROOMS.toString(), this::fireAvailableRooms);
    }

    @Override
    public void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        System.out.println("Reached server...");
        viewRoomHandler.searchRoom(dateFrom, dateTo, roomType);
    }

    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        return viewRoomHandler.getDescriptionByCategory(roomType);
    }

    @Override
    public String getPriceByCategory(RoomType roomType) {
        return viewRoomHandler.getPriceByCategory(roomType);
    }

    @Override
    public void registerViewRoomClient(RoomsCallBack roomsCallBack) {
        this.roomsCallBack=roomsCallBack;
    }

    private void fireAvailableRooms(PropertyChangeEvent event) {
        try {
            System.out.println("\n\n\n "+event.getNewValue());
            roomsCallBack.roomsFromServer((List<Room>) event.getNewValue());
        } catch (RemoteException e) {
            throw new RuntimeException("Error in server");
        }

    }

}
