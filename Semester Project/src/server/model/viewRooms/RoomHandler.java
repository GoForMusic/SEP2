package server.model.viewRooms;

import shared.utils.Request;
import shared.utils.Subject;
import shared.utils.reservation.Reservation;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.time.LocalDate;
import java.util.List;

/**
 * @author Sachin Baral
 */
public interface RoomHandler extends Subject {
    /**
     * Asks dataBase to search the room
     * @param dateFrom the date to search from
     * @param dateTo the date to search upto
     * @param roomType the category of the room to search
     */
    void searchRoom(LocalDate dateFrom, LocalDate dateTo, RoomType roomType);

    String getDescriptionByCategory(RoomType roomType);

    String getPriceByCategory(RoomType roomType);

    Request bookRoom(Reservation reservation);

    Request searchByUsername(String username);
}
