package server.database.room;

import server.database.DataBaseConnection;
import shared.utils.room.Room;

import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomDAOImpl implements RoomDAO {


    @Override
    public void create(String type, double price) throws SQLException {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Room\"(\"Room_name\" ,\"Room_type\")VALUES(?,?);");

            statement.setString(1, type);
            statement.setString(2, type);
            statement.executeUpdate();
        }

    }

    @Override
    public List<Room> getAllRooms() throws SQLException{
        return null;
    }

    @Override
    public List<Room> getAllRoomsByType(String category) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Room\" WHERE \"Room_type\" =?");
            statement.setString(1, category);
            return getRooms(statement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException("Error in database");
        }
    }

    @Override
    public List<Room> getAllAvailableRoomsByType(String category, LocalDate dateFrom, LocalDate dateTo) throws SQLException{

        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Room\" where \"Room_type\" =? and \"Room_name\" not in (SELECT \"Room_id\" from \"Reservation\" where \"startDate\"<=? and \"endDate\">=? )");
            statement.setString(1, category);
            statement.setDate(2, Date.valueOf(dateFrom));
            statement.setDate(3, Date.valueOf(dateTo));
            return getRooms(statement);
        }
    }

    private List<Room> getRooms(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        List<Room> rooms = new ArrayList<>();
        while (resultSet.next()){
            String room_type = resultSet.getString("Room_type");
            Room room = new Room("hello",room_type);
            rooms.add(room);
        }
        return rooms;
    }
}
