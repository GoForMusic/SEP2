package server.database.Reservation;

import server.database.DataBaseConnection;
import shared.utils.Request;

import java.sql.*;
import java.time.LocalDate;

public class ReservationDAOImp implements ReservationDAO {

    @Override
    public Request addReservation(String username, LocalDate startDate, LocalDate endDate, String roomName) throws Exception {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT into \"Reservation\"(username,startDate,endDate,roomName) VALUES(?,?,?,?);");
            statement.setString(1, username);
            statement.setDate(2, Date.valueOf(startDate));
            statement.setDate(3, Date.valueOf(endDate));
            statement.setString(4, roomName);
            statement.executeUpdate();
            return new Request("Room is booked", null);
        } catch (SQLException throwables) {
            return new Request(throwables.getMessage(), null);
        }
    }

    @Override
    public Request getReservationByUsername(String username) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Reservation\" WHERE \"userName\"=?;");
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            List<Roo>

        } catch (SQLException throwables) {
            return new Request(throwables.getMessage(),null);
        }

    }
}
