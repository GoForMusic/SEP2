package client.networking.rooms;

import client.networking.GetServer;
import shared.networking.clientInterfaces.RoomsCallBack;
import shared.networking.serverInterfaces.Server;
import shared.utils.Observer;
import shared.utils.Request;
import shared.utils.reservation.Reservation;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/** @author Emil
 * creating a class for the rooms view
 */
public class RoomsClientImp implements RoomsClient, RoomsCallBack {
    private Server server;
    private PropertyChangeSupport support;

    /**
     * Constructor initializing the server
     */

    public RoomsClientImp()  {
        try {
            UnicastRemoteObject.exportObject(this,0);
            support= new PropertyChangeSupport(this);
            server = GetServer.getServerFromRmi();
            server.getRoomsServer().registerRoomClient(this);
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
    public Request searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        try {
            System.out.println("View room impl");
           return server.getRoomsServer().searchRooms(dateFrom, dateTo, roomType);
        } catch (RemoteException e) {
           return new Request("Cannot connect to the server",null);
        }

    }

    /**
     * A function that will return a list of rooms
     * @return room of list
     */
    @Override
    public ArrayList<Room> getRooms() {
        try {
            return server.getRoomsServer().getRooms();
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * A function that will update room details
     * @param room
     */
    @Override
    public void updateRoom(Room room) {
        try {
            server.getRoomsServer().updateRoom(room);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * A function that will return description by category
     * @param roomType
     * @return description
     */
    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        try {
            return server.getRoomsServer().getDescriptionByCategory(roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * A function that will return price by category
     * @param roomType
     * @return
     */
    @Override
    public String getPriceByCategory(RoomType roomType) {
        try {
            return server.getRoomsServer().getPriceByCategory(roomType);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return "Error...";
    }

    /**
     * A function that will book a room
     * @param reservation
     * @return a message
     */
    @Override
    public Request bookRoom(Reservation reservation) {
        System.out.println("Rooms client impl");
        try {
            return server.getRoomsServer().bookRoom(reservation);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return new Request("Error connecting to server",null);
    }

    /**
     * A function that will search by username
     * @param username
     * @return a message
     */
    @Override
    public Request searchByUsername(String username) {
        try {
            return server.getRoomsServer().searchByUsername(username);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        return new Request("Error connecting to server",null);
    }

    /**
     * A function that will update the reservation
     * @param username
     * @param previousStart
     * @param previousEnd
     * @param roomName
     * @param newStart
     * @param newEnd
     * @param newRoom
     * @return a message
     */
    @Override
    public Request updateReservation(String username, LocalDate previousStart, LocalDate previousEnd, String roomName, LocalDate newStart, LocalDate newEnd, String newRoom)  {
        try {
            return server.getRoomsServer().updateReservation(username,previousStart,previousEnd,roomName,newStart,newEnd,newRoom);
        } catch (RemoteException e) {
            return new Request("Cannot connect to server",null);
        }
    }

    /**
     * A function that will remove a reservation
     * @param id
     * @return a message
     */
    @Override public Request removeReservation(int id)
    {
        try {
            return server.getRoomsServer().removeReservation(id);
        } catch (RemoteException e) {
            return new Request("Cannot connect to server",null);
        }
    }

    /**
     * A function that will create a room
     * @param room
     * @return a message
     */
    @Override
    public Request createRoom(Room room) {
        try {
           return server.getRoomsServer().createRoom(room);
        } catch (RemoteException e) {
            return new Request(e.getMessage(),null);
        }
    }

    /**
     * A function that will print a list of rooms and fire property change
     * @param roomList
     * @throws RemoteException
     */
    @Override
    public void roomsFromServer(List<Room> roomList) throws RemoteException {
        System.out.println(roomList);
        support.firePropertyChange(Observer.AVAILABLEROOMS.toString(),null,roomList);
    }

    /**
     * A function that add a listener
     * @param eventName
     * @param listener
     */
    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName,listener);
    }

    /**
     * A function that remove a lsitener
     * @param eventName
     * @param listener
     */
    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName,listener);

    }
}
