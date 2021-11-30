package client.model.viewRooms;

import shared.utils.Subject;
import shared.utils.room.RoomType;

import java.time.LocalDate;

/**
 * @author Sachin Baral
 * Model for viewing rooms
 */
public interface ViewRoomsModel extends Subject {
    /**
     * searches available rooms on the given time period
     *
     * @param dateFrom the date to search from
     * @param dateTo the date to search upto
     * @param roomType the category of the room
     */
    void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType);

    String getDescriptionByCategory(RoomType roomType);

    String getPriceByCategory(RoomType roomType);
}