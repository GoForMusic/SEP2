package client.model.rooms;

import shared.utils.Request;
import shared.utils.Subject;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Sachin Baral
 * Model for viewing rooms
 */
public interface RoomsModel extends Subject {
    /**
     * searches available rooms on the given time period
     *
     * @param dateFrom the date to search from
     * @param dateTo   the date to search upto
     * @param roomType the category of the room
     */
    void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType);

    String getDescriptionByCategory(RoomType roomType);

    String getPriceByCategory(RoomType roomType);

    void setTempStartAndEndDate(LocalDate startDate, LocalDate endDate);

    LocalDate getTempStartDate();

    LocalDate getTempEndDate();

    Request bookRoom(String username, List<Room> selectedRooms, LocalDate startDate, LocalDate endDate);
}
