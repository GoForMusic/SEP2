package client.model.rooms;

import client.networking.rooms.RoomsClient;
import shared.utils.Observer;
import shared.utils.Request;
import shared.utils.reservation.Reservation;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Adrian
 * @version 0.1
 * A class that is implement all the function from room model
 */
public class RoomsModelImpl implements RoomsModel {
    private RoomsClient client;
    private PropertyChangeSupport support;
    private LocalDate tempStartDate;
    private LocalDate tempEndDate;
    private Reservation selectedReservation;
    private String tempUsername;

    /**
     * A constructor that will initialize the client
     */
    public RoomsModelImpl(RoomsClient roomsClient) {
        this.client = roomsClient;
        support = new PropertyChangeSupport(this);
        client.addListener(Observer.AVAILABLEROOMS.toString(), this::fireProperty);
    }

    /**
     * A function that is starting a fire property
     */
    private void fireProperty(PropertyChangeEvent event) {
        support.firePropertyChange(event);

    }

    /**
     * An override method that will search for a room and passing the values to the RMI
     *
     * @param dateFrom the date to search from
     * @param dateTo   the date to search upto
     * @param roomType the category of the room
     */
    @Override
    public Request searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        System.out.println(" room model");
      return   client.searchRooms(dateFrom, dateTo, roomType);
    }

    /**
     * A function that is returning a list of rooms
     * @return list of rooms
     */
    @Override
    public ArrayList<Room> getRooms() {
        return client.getRooms();
    }

    /**
     * A function that will update room details
     */
    @Override
    public void updateRoom(Room room) {
        client.updateRoom(room);
    }

    /**
     * An override method that will search for a room and get the descriptions
     *
     * @param roomType search base on the type
     * @return the specific description
     */
    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        return client.getDescriptionByCategory(roomType);
    }

    /**
     * An override method that will search for a room and get the price
     *
     * @param roomType search base on the type
     * @return the specific price
     */
    @Override
    public String getPriceByCategory(RoomType roomType) {
        return client.getPriceByCategory(roomType);
    }

    /**
     * A function that is set start date and end date
     */
    @Override
    public void setTempStartAndEndDate(LocalDate startDate, LocalDate endDate) {
        this.tempStartDate = startDate;
        this.tempEndDate = endDate;
    }

    /**
     * A function that start date
     */
    @Override
    public LocalDate getTempStartDate() {
        return tempStartDate;
    }

    /**
     * A function that will get end date
     */
    @Override
    public LocalDate getTempEndDate() {
        return tempEndDate;
    }

    /**
     * A function that will book a room
     */
    @Override
    public Request bookRoom(String username, List<Room> selectedRooms, LocalDate startDate, LocalDate endDate) {

        System.out.println("Rooms model impl");
        List<String> temp = new ArrayList<>();
        for (Room i : selectedRooms
        ) {
            temp.add(i.getName());
        }

        try {
            Reservation reservation = new Reservation(username, startDate, endDate, temp);
            return client.bookRoom(reservation);
        } catch (Exception e) {
            //  e.printStackTrace();
            return new Request(e.getMessage(), null);
        }

    }

    /**
     * A function that will search base on username
     */
    @Override
    public Request searchByUsername(String username) {
        return client.searchByUsername(username);
    }

    /**
     * A function that will return a reservation
     * @return reservation
     * */
    @Override
    public Reservation getSelectedReservation() {
        return selectedReservation;
    }

    /**
     * A function that set select reservation
     */
    @Override
    public void setSelectedReservation(Reservation reservation) {
        this.selectedReservation = reservation;
    }

    /**
     * A function to set username
     */
    @Override
    public void setTempUsername(String text) {
        this.tempUsername = text;
    }

    /**
     * A function that get username
     * @return
     */
    @Override
    public String getUsername() {
        return tempUsername;
    }

    /**
     * A function that update reservation
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
    public Request updateReservation(String username, LocalDate previousStart, LocalDate previousEnd, String roomName, LocalDate newStart, LocalDate newEnd, String newRoom) {
        return client.updateReservation(username,previousStart, previousEnd,  roomName,  newStart,  newEnd,  newRoom);
    }

    /**
     * A function that remove reservation
     * @param id
     * @return a message
     */
    @Override public Request removeReservation(int id)
    {
        return client.removeReservation(id);
    }

    /**
     * A function that create a room
     * @param room
     * @return a message
     */
    @Override
    public Request createRoom(Room room) {
    return  client.createRoom(room);
    }

    /**
     * A function that add property change listener
     * @param eventName
     * @param listener
     */
    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    /**
     * A function that remove listener
     * @param eventName
     * @param listener
     */
    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }

}
