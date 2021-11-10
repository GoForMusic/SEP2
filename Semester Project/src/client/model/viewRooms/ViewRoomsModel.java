package client.model.viewRooms;

import java.time.LocalDate;

/**
 * @author Sachin Baral
 * Model for viewing rooms
 */
public interface ViewRoomsModel {
    /**
     * searches available rooms on the given time period
     *
     * @param dateFrom the date to search from
     * @param dateTo the date to search upto
     * @param category the category of the room
     */
    void searchRooms(LocalDate dateFrom, LocalDate dateTo, String category);
}
