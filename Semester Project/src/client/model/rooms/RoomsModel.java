package client.model.rooms;

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
    Request searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType);

    ArrayList<Room> getRooms();

    void updateRoom(Room room);

    String getDescriptionByCategory(RoomType roomType);

    String getPriceByCategory(RoomType roomType);

    void setTempStartAndEndDate(LocalDate startDate, LocalDate endDate);

    LocalDate getTempStartDate();

    LocalDate getTempEndDate();

    Request bookRoom(String username, List<Room> selectedRooms, LocalDate startDate, LocalDate endDate);

    Request searchByUsername(String username);

    Reservation getSelectedReservation();

    void setSelectedReservation(Reservation reservation);

    void setTempUsername(String text);

    String getUsername();

    Request updateReservation(String username, LocalDate previousStart, LocalDate previousEnd, String roomName, LocalDate newStart, LocalDate newEnd, String newRoom);

    Request removeReservation(int id);

    Request createRoom(Room room);
}
