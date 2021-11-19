package server.database.room;

import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.sql.SQLException;
import java.time.LocalDate;

public class test {
    public static void main(String[] args) {
        RoomDAO roomDAO = new RoomDAOImpl();
        try {
            for (Room room: roomDAO.getAllRoomsByType(RoomType.SINGLE.toString())
                 ) {
                System.out.println(room);
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
