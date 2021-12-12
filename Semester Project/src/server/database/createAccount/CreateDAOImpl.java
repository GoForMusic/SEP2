package server.database.createAccount;

import server.database.DataBaseConnection;

import java.sql.*;

/**
 * @author Sachin Baral
 * @version 1.0
 */
public class CreateDAOImpl implements CreateDAO {

    /**
     * A constructor that will initialize the with the db driver
     */
    public CreateDAOImpl() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * A function that will add a user to db
     * @param firstname the firstname of the user
     * @param lastname the lastname of the user
     * @param username the username of the user
     * @param password the pasword of the user
     * @param userType the type of user
     * @return a message
     */
    @Override
    public String addUser(String firstname, String lastname, String username, String password, String userType) {
        //FIXME to make the parameter
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * from \"User\" where \"username\"=?;");
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()) {
                connection.close();
                return "Username is already taken";
            } else {
                PreparedStatement statement2 = connection.prepareStatement("INSERT INTO \"User\"(\"username\", \"firstname\", \"lastname\", \"password\", \"access_type\") VALUES (?,?,?,?,?);");
                statement2.setString(1, username);
                statement2.setString(2, firstname);
                statement2.setString(3, lastname);
                statement2.setString(4, password);
                statement2.setString(5, userType);
                statement2.executeUpdate();
                connection.close();
                return "User created successfully";
            }
        } catch (SQLException throwables) {
            return throwables.getMessage();
        }
    }





}
