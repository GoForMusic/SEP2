package server.database.room;

import shared.utils.room.Room;

import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sachin Baral
 * The data access object for room
 */
public interface RoomDAO {
    void create(Room room) throws SQLException;
    void updateRoom(Room room) throws SQLException;
    ArrayList<Room> getAllRooms() throws SQLException;
    List<Room> getAllRoomsByType(String category) throws SQLException;
    List<Room> getAllAvailableRoomsByType(String category, LocalDate dateFrom, LocalDate dateTo) throws SQLException;

}
