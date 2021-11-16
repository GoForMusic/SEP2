package server.networking.viewRooms;

import client.model.viewRooms.ViewRoomsModel;
import shared.networking.serverInterfaces.ViewRoomServer;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;

public class ViewRoomServerSide implements ViewRoomsModel, Remote {

    private ViewRoomServer server;

    public ViewRoomServerSide(ViewRoomServer server) {
        this.server = server;
    }

    public ViewRoomServerSide() throws RemoteException
    {
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void searchRooms(LocalDate dateFrom, LocalDate dateTo, String category) {

        try {
            server.searchRooms(dateFrom,dateTo,category);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
