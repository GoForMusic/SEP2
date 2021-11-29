package client.model.viewRooms;

import client.networking.viewRooms.ViewRoomClient;
import shared.utils.Observer;
import shared.utils.room.RoomType;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.time.LocalDate;

/**
 * @author Adrian
 * @version 0.1
 */
public class ViewRoomsModelImpl implements ViewRoomsModel {
    private ViewRoomClient client;
    private PropertyChangeSupport support;
    private LocalDate tempStartDate;
    private LocalDate tempEndDate;

    /**
     * A constructor that will initialize the client
     *
     * @param viewRoomClient
     */
    public ViewRoomsModelImpl(ViewRoomClient viewRoomClient) {
        this.client = viewRoomClient;
        support = new PropertyChangeSupport(this);
        client.addListener(Observer.AVAILABLEROOMS.toString(), this::fireProperty);
    }

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
    public void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        System.out.println(" room model");
        client.searchRooms(dateFrom, dateTo, roomType);
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

    @Override
    public void setTempStartAndEndDate(LocalDate startDate, LocalDate endDate) {
        this.tempStartDate = startDate;
        this.tempEndDate = endDate;
    }

    @Override
    public LocalDate getTempStartDate() {
        return tempStartDate;
    }

    @Override
    public LocalDate getTempEndDate() {
        return tempEndDate;
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
