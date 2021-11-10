package server.model.viewRooms;

import java.time.LocalDate;

/**
 * @author Sachin Baral
 */
public interface ViewRoomHandler {
    /**
     * Asks dataBase to search the room
     * @param dateFrom the date to search from
     * @param dateTo the date to search upto
     * @param category the category of the room to search
     */
    void searchRoom(LocalDate dateFrom, LocalDate dateTo, String category);
}
