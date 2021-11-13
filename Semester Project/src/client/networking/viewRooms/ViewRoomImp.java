package client.networking.viewRooms;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;

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
    public void searchRooms(LocalDate dateFrom, LocalDate dateTo, String category) {

        try {
            server.getViewRoomServer().searchRooms(dateFrom, dateTo, category);
        } catch (RemoteException e) {
            e.printStackTrace();
        }

    }
}
