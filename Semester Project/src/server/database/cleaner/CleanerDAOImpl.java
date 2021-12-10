package server.database.cleaner;

import server.database.DataBaseConnection;
import shared.utils.User.Cleaner;
import shared.utils.User.Customer;
import shared.utils.Request;

import java.sql.*;
import java.util.ArrayList;

public class CleanerDAOImpl implements CleanerDAO {

    public CleanerDAOImpl() throws SQLException {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    @Override
    public void updateCleaner(Cleaner cleaner, String oldUsername) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE \"User\" SET (firstname, lastname, username, password)=(?,?,?,?) WHERE \"username\"=?");
            statement.setString(1, cleaner.getFirstname());
            statement.setString(2, cleaner.getLastName());
            statement.setString(3, cleaner.getUserName());
            statement.setString(4, cleaner.getPassword());
            statement.setString(5, oldUsername);
            statement.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void removeCleaner(Cleaner cleaner) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM \"User\" WHERE \"username\"=?;");
            statement.setString(1, cleaner.getUserName());

            statement.executeUpdate();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }



    @Override
    public Cleaner getCleaner(String username) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"User\" WHERE \"username\"=?;");
            statement.setString(1, username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String password = resultSet.getString("password");
                connection.close();
                return new Cleaner(firstname, lastname, username, password);
            } else {
                connection.close();
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    @Override
    public ArrayList<Cleaner> getCleaners() {
        ArrayList<Cleaner> list = new ArrayList<>();
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"User\" WHERE access_type = 'CLEANER';");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()) {
                String firstname = resultSet.getString("firstname");
                String lastname = resultSet.getString("lastname");
                String username = resultSet.getString("username");
                String password = resultSet.getString("password");
                list.add(new Cleaner(firstname, lastname, username, password));
            }
            connection.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        System.out.println(list);
        return list;
    }
}
