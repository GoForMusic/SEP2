package client.networking.viewRooms;

import shared.utils.Subject;
import shared.utils.room.RoomType;

import java.time.LocalDate;

/**
 * @author Sachin Baral
 * The client intergface dealing with viewing rooms
 */
public interface ViewRoomClient extends Subject {
    /**
     * Searches room
     * @param dateFrom the date to search from
     * @param dateTo the date to search upto
     * @param roomType the category of the room to search
     */
    void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType);

    String getDescriptionByCategory(RoomType roomType);

    String getPriceByCategory(RoomType roomType);
}
