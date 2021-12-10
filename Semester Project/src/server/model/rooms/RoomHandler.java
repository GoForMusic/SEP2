package server.model.rooms;

import shared.utils.Request;
import shared.utils.Subject;
import shared.utils.reservation.Reservation;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.time.LocalDate;
import java.util.ArrayList;
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
    Request searchRoom(LocalDate dateFrom, LocalDate dateTo, RoomType roomType);

    String getDescriptionByCategory(RoomType roomType);

    ArrayList<Room> getRooms();

    void updateRoom(Room room);

    String getPriceByCategory(RoomType roomType);

    Request bookRoom(Reservation reservation);

    Request searchByUsername(String username);

    Request updateReservation(String username, LocalDate previousStart, LocalDate previousEnd, String roomName, LocalDate newStart, LocalDate newEnd, String newRoom);
    Request removeReservation(int id);
    Request createRoom(Room room);
}
