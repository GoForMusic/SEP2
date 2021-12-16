package server.database.Reservation;

import server.database.DataBaseConnection;
import shared.utils.Request;
import shared.utils.reservation.Reservation;

import javax.security.auth.login.AppConfigurationEntry;
import java.sql.*;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/**
 * @author Sachin
 */
public class ReservationDAOImp implements ReservationDAO {

    private static ReservationDAO instance;
    private static Lock lock = new ReentrantLock();


    private ReservationDAOImp() {

    }

    /**
     * A function that will do instance in singleton
     * @return instance
     */
    public static ReservationDAO getInstance() {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ReservationDAOImp();
                }
            }
        }
        return instance;
    }

    /**
     * A function that add reservation
     * @param username
     * @param startDate
     * @param endDate
     * @param roomName
     * @return a message
     */
    @Override
    public Request addReservation(String username, LocalDate startDate, LocalDate endDate, String roomName) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT into \"Reservation\"(\"userName\",\"startDate\",\"endDate\",\"roomName\") VALUES(?,?,?,?);");
            statement.setString(1, username);
            statement.setDate(2, Date.valueOf(startDate));
            statement.setDate(3, Date.valueOf(endDate));
            statement.setString(4, roomName);
            statement.executeUpdate();
            return new Request("Room is booked", null);
        } catch (SQLException throwables) {
            return new Request("Username doesnt exist", null);
        }
    }

    /**
     * A function that will get reservation by username
     * @param username
     * @return reservation or error message
     */
    @Override
    public Request getReservationByUsername(String username) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from \"User\" WHERE \"username\"=?;");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                statement = connection.prepareStatement("SELECT * FROM \"Reservation\" WHERE \"userName\"=?;");
                statement.setString(1, username);
                resultSet = statement.executeQuery();
                List<Reservation> reservations = new ArrayList<>();
                LocalDate startDate = null;
                LocalDate endDate = null;
                int id = 0;
                while (resultSet.next()) {
                    String roomName = resultSet.getString("roomName");
                    startDate = (resultSet.getDate("startDate")).toLocalDate();
                    endDate = (resultSet.getDate("endDate")).toLocalDate();
                    id=(resultSet.getInt("Reservation_Id"));
                    reservations.add(new Reservation(roomName,startDate,endDate,id));
                }
                if (startDate == null || endDate == null || reservations.isEmpty()) {
                    return new Request("User has not reserved any room", null);
                } else {
                    return new Request("Reservation found..", reservations);
                }
            } else {
                return new Request("Username doesnot exist", null);
            }

        } catch (SQLException throwables) {
            return new Request(throwables.getMessage(), null);
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }

    }

    @Override
    public Request updateReservation(String username, LocalDate previousStart, LocalDate previousEnd, String roomName, LocalDate newStart, LocalDate newEnd, String newRoom) {
        try(Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE \"Reservation\" SET \"startDate\" =?,\"endDate\" =?, \"roomName\"=? WHERE \"userName\"=? AND \"startDate\" =? AND\"endDate\" =? AND \"roomName\"=?;");
            statement.setDate(1,Date.valueOf(newStart));
            statement.setDate(2,Date.valueOf(newEnd));
            statement.setString(3,newRoom);
            statement.setString(4,username);
            statement.setDate(5,Date.valueOf(previousStart));
            statement.setDate(6,Date.valueOf(previousEnd));
            statement.setString(7,roomName);
            statement.executeUpdate();
            return new Request("Updated successfully",null);
        } catch (SQLException throwables) {
            return new Request(throwables.getMessage(),null);
        }
    }

    @Override public Request removeReservation(int id)
    {

            try (Connection connection = DataBaseConnection.getConnection())
            {

                PreparedStatement statement = connection.prepareStatement(
                    "delete from \"Reservation\" where  \"Reservation_id\" = ?;");
                statement.setInt(1, id);

                statement.executeQuery();
                return new Request("Removed successfully", null);
            }
            catch (SQLException throwables)
            {
                return new Request(throwables.getMessage(), null);
            }
        }
    }



