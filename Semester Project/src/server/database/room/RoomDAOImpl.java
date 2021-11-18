package server.database.room;

import server.database.DataBaseConnection;
import shared.utils.room.Room;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {


    @Override
    public void create(String type, double price) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO Room(type ,price)VALUES(?,?);");

            statement.setString(1, type);
            statement.setString(2, type);
            statement.executeUpdate();
        }

    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }

    @Override
    public List<Room> getAllRoomsByType(String type) throws SQLException {
//        try(Connection connection = DataBaseConnection.getConnection()){
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM Room WHERE type =?");
//            statement.setString(1,type);
//            ResultSet resultSet = statement.executeQuery();
//            List<Room> rooms= new ArrayList<>();
//            while (resultSet.next()){
//                String room_type = resultSet.getString("Room_type");
//                String room_price = resultSet.getString("Room_price");
//
//            }
//        }
        return null;
    }
}
