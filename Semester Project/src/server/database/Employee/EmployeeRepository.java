package server.database.Employee;

import shared.utils.User;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for database
 */
public interface EmployeeRepository {
    void insertEmployee(User user) throws SQLException;
    User getEmployee(int userID) throws SQLException;
    User getEmployeeLogin(String userName, String password) throws SQLException;
    void updateEmployee(int userID, User newUser) throws SQLException;
    ArrayList<User> getEmployees() throws SQLException;
}
