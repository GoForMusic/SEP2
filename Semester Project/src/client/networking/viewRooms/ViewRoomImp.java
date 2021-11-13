package client.networking.viewRooms;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.room.RoomType;

import java.rmi.RemoteException;
import java.time.LocalDate;

/** @author Emil
 * creating a class for the rooms view
 *
 */
public class ViewRoomImp implements ViewRoomClient {
    private Server server;

    /**
     * Constructor initializing the server
     */

    public ViewRoomImp() {
        server = GetServer.getServerFromRmi();
    }

    /**
     *
     * @param dateFrom the date to search from
     * @param dateTo the date to search upto
     * @param category the category of the room to search
     */
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

    @Override
    public double getPriceByCategory(RoomType roomType) {
        try {
            return server.getViewRoomServer().getPriceByCategory(roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return 0;
    }
}
