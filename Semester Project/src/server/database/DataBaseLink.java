package server.database;

import shared.utils.User;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class is the connection with database where is the actions CREATE/UPDATE/DELETE are executed
 * @author Adrian
 * @version 0.1
 */
public class DataBaseLink implements DataBase{
    private Connection connection;

    /**
     * A constructor where the driver for postgresql will be register
     */
    public DataBaseLink(){
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * A inset method, where the User will be added to the table users into the database
     * @param user = user details
     * @throws SQLException = will show on the console the specific message from database
     */
    @Override
    public void insertUser(User user) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO users(\"firstName\",\"lastName\",password,\"emailAddress\",department) VALUES(?,?,?,?,?);");
            statement.setString(1,user.getFirstname());
            statement.setString(2,user.getLastName());
            statement.setString(3,user.getPassword());
            statement.setString(4,user.getEmailAddress());
            statement.setString(5,user.getDepartment());

            statement.executeUpdate();
            //return new User(username,password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * A get method, where the user with the specific userID will be extracted from the table users
     * @param userID = specific user ID
     * @return = the user object
     * @throws SQLException = will show on the console the specific message from database
     */
    @Override
    public User getUser(int userID) throws SQLException {
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM users WHERE \"userID\"=?;");
            statement.setInt(1,userID);
            ResultSet resultSet = statement.executeQuery();

            //Still need update base on USER class
            int id = 0;
            String firstName = null;
            String lastName = null;
            String password = null;
            String emailAddress = null;
            String department = null;

            while (resultSet.next())
            {
                id=resultSet.getInt("userID");
                firstName=resultSet.getString("firstName");
                lastName=resultSet.getString("lastName");
                password=resultSet.getString("password");
                emailAddress=resultSet.getString("emailAddress");
                department=resultSet.getString("department");
            }

            return new User(id,firstName,lastName,emailAddress,password,department);

            //return new User(username,password);
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * An update method, where the user information will be updated on the database, every user has unique ID.
     * @param userID = specific user ID
     * @param newUser = new User object that will update the existing user in database
     * @throws SQLException = will show on the console the specific message from database
     */
    @Override
    public void updateUser(int userID, User newUser) throws SQLException{
        try(Connection connection = getConnection()) {
            PreparedStatement statement = connection.prepareStatement("UPDATE users SET \"firstName\"=?,\"lastName\"=?,password=?,\"emailAddress\"=?,department=? WHERE \"userID\"=?;");

            statement.setString(1,newUser.getFirstname());
            statement.setString(2,newUser.getLastName());
            statement.setString(3,newUser.getPassword());
            statement.setString(4,newUser.getEmailAddress());
            statement.setString(5,newUser.getDepartment());
            statement.setInt(5,newUser.getUserID());

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * A fuction that will return the whole list of users from the database.
     * @return = arraylist of users
     * @throws SQLException = will show on the console the specific message from database
     */
    @Override
    public ArrayList<User> getUsers() throws SQLException {
        ArrayList<User> temp= new ArrayList<>();

        try(Connection connection = getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT \"userID\" FROM users");
            ResultSet resultSet = statement.executeQuery();

            while(resultSet.next()){
                temp.add(getUser(resultSet.getInt("userID")));
            }

            return temp;
        }catch (SQLException e){
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * A private function that will call the connection with the database everytime where an SQL command is executed.
     * @return the connection with the server.
     * @throws SQLException = will show on the console the specific message from database
     */
    private Connection getConnection() throws SQLException{
        return DriverManager.getConnection("jdbc:postgresql://localhost:5432/postgres?currentSchema=\"Hesam\"", "postgres","1234");
    }
}
