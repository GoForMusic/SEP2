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
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Room\"(type ,price)VALUES(?,?);");

            statement.setString(1, type);
            statement.setString(2, type);
            statement.executeUpdate();
            connection.close();
        }

    }

    @Override
    public List<Room> getAllRooms() {
        return null;
    }

    @Override
    public List<Room> getAllRoomsByType(String category) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Room\" WHERE \"Room_type\" =?");
            statement.setString(1, category);
            connection.close();
            return getRooms(statement);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables.getMessage());
        }
    }

    @Override
    public List<Room> getAllAvailableRoomsByType(String category, LocalDate dateFrom, LocalDate dateTo) {

        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Room\" where \"Room_type\" =? and \"Room_name\" not in (SELECT \"Room_name\" from \"Reservation\" where \"startDate\"<=date(?) and \"endDate\">=date(?) )");
            statement.setString(1, category);
            statement.setDate(2,Date.valueOf(dateFrom));
            statement.setDate(3,Date.valueOf(dateTo));

            List<Room> rooms = getRooms(statement);
            return rooms;

        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new RuntimeException(throwables.getMessage());
        }
    }

    private List<Room> getRooms(PreparedStatement statement) throws SQLException {
        ResultSet resultSet = statement.executeQuery();
        List<Room> rooms = new ArrayList<>();
        while (resultSet.next()){
            String room_type = resultSet.getString("Room_type");
            String name = resultSet.getString("Room_name");
            Room room = new Room(name,room_type);
            rooms.add(room);
        }
        return rooms;
    }
}
