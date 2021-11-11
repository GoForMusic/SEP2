package server.database.Employee;

import shared.utils.User.User;

import java.sql.SQLException;
import java.util.ArrayList;

/**
 * Interface for database
 */
public interface EmployeeRepository {
    void insertEmployee(User user);
    User getEmployee(int userID);
    User getEmployeeLogin(String userName, String password);
    void updateEmployee(int userID, User newUser);
    ArrayList<User> getEmployees();
    void deleteEmployee(int userID);
}
