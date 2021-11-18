package client.networking.viewRooms;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.RoomType;

import java.rmi.RemoteException;
import java.time.LocalDate;

public class ViewRoomImp implements ViewRoomClient {
    private Server server;

    public ViewRoomImp() {
        server = GetServer.getServerFromRmi();
    }

    @Override
    public void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        try {
            server.getViewRoomServer().searchRooms(dateFrom, dateTo, roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        try {
            return server.getViewRoomServer().getDescriptionByCategory(roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }
}
