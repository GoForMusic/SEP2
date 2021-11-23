package client.model.viewRooms;

import client.networking.viewRooms.ViewRoomClient;
import shared.utils.room.RoomType;

import java.time.LocalDate;

/**
 * @author Adrian
 * @version 0.1
 */
public class ViewRoomsModelImpl implements ViewRoomsModel{
    private ViewRoomClient client;

    /**
     * A constructor that will initialize the client
     * @param viewRoomClient
     */
    public ViewRoomsModelImpl(ViewRoomClient viewRoomClient){
        this.client=viewRoomClient;
    }

    /**
     * An override method that will search for a room and passing the values to the RMI
     * @param dateFrom the date to search from
     * @param dateTo the date to search upto
     * @param roomType the category of the room
     */
    @Override
    public void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        client.searchRooms(dateFrom, dateTo, roomType);
    }

    /**
     * An override method that will search for a room and get the descriptions
     * @param roomType search base on the type
     * @return the specific description
     */
    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        return client.getDescriptionByCategory(roomType);
    }

    /**
     * An override method that will search for a room and get the price
     * @param roomType search base on the type
     * @return the specific price
     */
    @Override
    public String getPriceByCategory(RoomType roomType) {
        return client.getPriceByCategory(roomType);
    }

}
