package server.database.Employee;

import server.database.DataBaseConnection;
import shared.utils.User.Admin;
import shared.utils.User.Cleaner;
import shared.utils.User.Receptionist;
import shared.utils.User.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class is the connection with database where is the actions CREATE/UPDATE/DELETE are executed.
 * @author Adrian
 * @version 0.2
 */
public class EmployeeRepositoryImpl implements EmployeeRepository {
    private Connection connection;

    /**
     * A constructor where the driver for postgresql will be register
     */
    public EmployeeRepositoryImpl() throws SQLException {
            DriverManager.registerDriver(new org.postgresql.Driver());
    }


    /**
     * A method that will insert a new User to the employee table
     * @param user the user object
     * @throws SQLException
     */
    @Override
    public void insertEmployee(User user) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Employee\"(\"firstName\",\"lastName\",\"userName\",password,\"Employee_type\") VALUES(?,?,?,?,?);");


            //set the parameters on the SQL statement
            statement.setString(1, user.getFirstname());
            statement.setString(2, user.getLastName());
            statement.setString(3, user.getUserName());
            statement.setString(4, user.getPassword());
            statement.setString(5, user.getEmployeeType());

            //execute update
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * A method that will get a user from the database base on the userID
     * @param userID user id provided for the search
     * @return return the user object
     * @throws SQLException
     */
    @Override
    public User getEmployee(int userID){
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Employee\" WHERE \"Employee_id\" = ?;");

            //set the parameters on the SQL statement
            statement.setInt(1,userID);

            //execute query
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                //store in a array all the objects from a row
                for(int i=0;i<row.length;i++) {
                    row[i] = resultSet.getObject(i+1);
                }

                //base on the last element will return a specific object
                if(row[4].equals("Admin"))
                {
                    return new Admin((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4]);
                }else if(row[4].equals("Cleaner")){
                    return new Cleaner((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4]);
                }else if(row[4].equals("Receptionist")){
                    return new Receptionist((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4]);
                }
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * A method that will return a user when username and password match (used for login system)
     * @param userName username from GUI
     * @param password password from GUI
     * @return user object base on the sql query
     * @throws SQLException
     */
    @Override
    public User getEmployeeLogin(String userName, String password){
        User temp = null;
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Employee\" WHERE \"userName\" = ? AND password = ?;");
            //set the parameters on the SQL statement
            statement.setString(1,userName);
            statement.setString(2,password);

            //execute query
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                //store in a array all the objects from a row
                for(int i=0;i<row.length;i++) {
                    row[i] = resultSet.getObject(i+1);
                }

                //base on the last element will return a specific object
                if(row[5].equals("Admin"))
                {
                    temp= new Admin((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4]);
                }else if(row[4].equals("Cleaner")){
                    temp = new Cleaner((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4]);
                }else if(row[4].equals("Receptionist")){
                    temp = new Receptionist((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4]);
                }
            }
            //resultSet.close();
            //statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    /**
     * A method that will update the User on the employee table.
     * @param userID user ID provide to search on table
     * @param newUser new user object that will update the existing one on database
     * @throws SQLException
     */
    @Override
    public void updateEmployee(int userID, User newUser){
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("UPDATE \"Employee\" SET(\"firstName\", \"lastName\",\"userName\",password,\"Employee_type\") = (?,?,?,?,?) WHERE \"Employee_id\"=?;");

            //set the userID parameters on the SQL statment
            statement.setInt(6,userID);

            //set the parameters on the SQL statement
            statement.setString(1,newUser.getFirstname());
            statement.setString(2,newUser.getLastName());
            statement.setString(3,newUser.getPassword());
            statement.setString(4,newUser.getPassword());
            statement.setString(5,newUser.getEmployeeType());


            //execude UPDATE
            statement.executeUpdate();
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
    }

    /**
     * A method that will get a list of users from the database
     * @return return the list of users
     * @throws SQLException
     */
    @Override
    public ArrayList<User> getEmployees(){
        ArrayList<User> temp = new ArrayList<>();
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Employee\";");

            //exegute command
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                //store in a array all the objects from a row
                for(int i=0;i<row.length;i++) {
                    row[i] = resultSet.getObject(i+1);
                }

                //base on the last element will return a specific object
                if(row[4].equals("Admin"))
                {
                    temp.add(new Admin((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4]));
                }else if(row[4].equals("Cleaner")){
                    temp.add(new Cleaner((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4]));
                }else if(row[4].equals("Receptionist")){
                    temp.add(new Receptionist((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4]));
                }
            }
            resultSet.close();
            statement.close();
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return temp;
    }

    /**
     * A method that will delete a user from the table
     * @param userID user id provided for the search
     * @throws SQLException
     */
    @Override
    public void deleteEmployee(int userID){
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM \"Employee\" WHERE \"Employee_id\"=?;");
            statement.setInt(1, userID);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
