package server.database.roomType;

import server.database.room.RoomDAO;
import server.database.room.RoomDAOImpl;

import java.sql.SQLException;
import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        RoomDAO roomDAO = new RoomDAOImpl();
        try {
            System.out.println(roomDAO.getAllAvailableRoomsByType("SINGLE", LocalDate.now(),LocalDate.now()));
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
