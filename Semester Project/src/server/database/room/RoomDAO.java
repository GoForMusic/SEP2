package server.database.room;

import shared.utils.room.Room;

import java.sql.SQLException;
import java.util.List;

/**
 * @author Sachin Baral
 * The data access object for room
 */
public interface RoomDAO {
    void create(String type,double price) throws SQLException;
    List<Room> getAllRooms() throws SQLException;
    List<Room> getAllRoomsByType(String type) throws SQLException;

}
