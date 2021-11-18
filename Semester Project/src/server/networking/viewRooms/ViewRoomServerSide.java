package server.networking.viewRooms;

import server.model.viewRooms.ViewRoomHandler;
import shared.networking.serverInterfaces.ViewRoomServer;
import shared.utils.Room;
import shared.utils.RoomType;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

public class ViewRoomServerSide implements ViewRoomServer {

    private ViewRoomHandler viewRoomHandler;

    public ViewRoomServerSide(ViewRoomHandler viewRoomHandler) throws RemoteException {
        this.viewRoomHandler = viewRoomHandler;
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        viewRoomHandler.searchRoom(dateFrom,dateTo,roomType);

    }

    @Override
    public String getDescriptionByCategory(RoomType roomType) {
       return viewRoomHandler.getDescriptionByCategory(roomType);
    }
}
