package server.database.Employee;

import server.database.DataBaseConnection;
import server.database.Employee.EmployeeRepository;
import shared.utils.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class is the connection with database where is the actions CREATE/UPDATE/DELETE are executed.
 * @author Adrian
 * @version 0.1
 */
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private Connection connection;

    /**
     * A constructor where the driver for postgresql will be register
     */
    public EmployeeRepositoryImpl(){
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }


    @Override
    public void insertEmployee(User user) throws SQLException {
        try(Connection connection = DataBaseConnection.getConnection())
        {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Employee\"(\"firstName\",\"lastName\",\"userName\",password,\"Employee_type\") VALUES(?,?,?,?,?);");
            statement.setString(1,user.getFirstname());
            statement.setString(2,user.getLastName());
            statement.setString(3,user.getUserName());
            statement.setString(4,user.getPassword());
            statement.setString(5,user.getEmployeeType());

            statement.executeUpdate();


        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public User getEmployee(int userID) throws SQLException {
        return null;
    }

    @Override
    public User getEmployeeLogin(String userName, String password) throws SQLException {
        return null;
    }

    @Override
    public void updateEmployee(int userID, User newUser) throws SQLException {

    }

    @Override
    public ArrayList<User> getEmployees() throws SQLException {
        return null;
    }
}
