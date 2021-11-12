package client.networking.viewRooms;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;

import java.time.LocalDate;

public class ViewRoomImp implements ViewRoomClient {
    private Server server;

    public ViewRoomImp() {
        server = GetServer.getServerFromRmi();
    }

    @Override
    public void searchRooms(LocalDate dateFrom, LocalDate dateTo, String category) {

    }
}
