package server.networking.roomType;

import server.model.roomType.RoomTypeListHandler;
import server.model.roomType.RoomTypeListHandlerImpl;
import shared.networking.serverInterfaces.RoomTypeListServer;
import shared.utils.roomType.RoomType;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;

public class RoomTypeListServerImpl implements RoomTypeListServer {

    private RoomTypeListHandler roomTypeListHandler;

    public RoomTypeListServerImpl(RoomTypeListHandler roomTypeListHandler) throws RemoteException
    {
        this.roomTypeListHandler = roomTypeListHandler;
        UnicastRemoteObject.exportObject(this,0);
    }

    @Override
    public void updateRoomType(RoomType roomType) throws RemoteException {
        roomTypeListHandler.updateRoomType(roomType);


    }

    @Override
    public RoomType getRoomType(String type) throws RemoteException {
        return roomTypeListHandler.getRoomType(type);
    }

    @Override
    public ArrayList<RoomType> getRoomTypes() throws RemoteException {
        return roomTypeListHandler.getRoomTypes();
    }
}
