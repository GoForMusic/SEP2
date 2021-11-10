package client.networking.viewRooms;

import java.time.LocalDate;

/**
 * @author Sachin Baral
 * The client intergface dealing with viewing rooms
 */
public interface ViewRoomClient {
    /**
     * Searches room
     * @param dateFrom the date to search from
     * @param dateTo the date to search upto
     * @param category the category of the room to search
     */
    void searchRooms(LocalDate dateFrom, LocalDate dateTo, String category);
}
