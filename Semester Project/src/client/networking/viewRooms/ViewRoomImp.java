package client.networking.viewRooms;

import client.networking.GetServer;
import shared.networking.clientInterfaces.RoomsCallBack;
import shared.networking.serverInterfaces.Server;
import shared.utils.Observer;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.List;

/** @author Emil
 * creating a class for the rooms view
 *
 */
public class ViewRoomImp implements ViewRoomClient, RoomsCallBack {
    private Server server;
    private PropertyChangeSupport support;

    /**
     * Constructor initializing the server
     */

    public ViewRoomImp()  {
        try {
            UnicastRemoteObject.exportObject(this,0);
            support= new PropertyChangeSupport(this);
            server = GetServer.getServerFromRmi();
            server.getViewRoomServer().registerViewRoomClient(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     *
     * @param dateFrom the date to search from
     * @param dateTo the date to search upto
     */
    @Override
    public void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        try {
            System.out.println("View room impl");
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
    public String getPriceByCategory(RoomType roomType) {
        try {
            return server.getViewRoomServer().getPriceByCategory(roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error...";
    }

    @Override
    public void roomsFromServer(List<Room> roomList) throws RemoteException {
        System.out.println(roomList);
        support.firePropertyChange(Observer.AVAILABLEROOMS.toString(),null,roomList);
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);

    }
}
