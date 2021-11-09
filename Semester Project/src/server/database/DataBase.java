package server.database;

import shared.utils.User;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for database
 */
public interface DataBase {
    void insertUser(User user) throws SQLException;
    User getUser(int userID) throws SQLException;
    void updateUser(int userID, User newUser) throws SQLException;
    ArrayList<User> getUsers() throws SQLException;
}
