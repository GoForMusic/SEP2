package client.networking.roomType;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.roomType.RoomType;

import java.rmi.RemoteException;
import java.util.ArrayList;

public class RoomTypeInfoImpl implements RoomTypeInfoClient{

    private Server server;

    public RoomTypeInfoImpl()
    {
        try{
            server = GetServer.getServerFromRmi();
        } catch (Exception e){
            throw e;
        }
    }

    @Override
    public void updateRoomInfo(RoomType roomType) {
        try{
            server.getRoomTypeListServer().updateRoomType(roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }

    @Override
    public  RoomType getRoomType(String roomType) {
        try {
            return server.getRoomTypeListServer().getRoomType(roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("Cannot connect!");
        return null;
    }



    @Override
    public  ArrayList<RoomType> getRoomTypes() {
        try {
            return server.getRoomTypeListServer().getRoomTypes();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        System.out.println("Cannot connect!");
        return null;
    }
}
