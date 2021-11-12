package server.database.Customer;

import server.database.DataBaseConnection;
import shared.utils.User.*;

import java.sql.*;
import java.util.ArrayList;

/**
 * This class is the connection with database where is the actions CREATE/UPDATE/DELETE are executed.
 * @author Adrian
 * @version 0.2
 */
public class CustomerRepositoryImpl implements CustomerRepository {
    private Connection connection;

    /**
     * A constructor where the driver for postgresql will be register
     */
    public CustomerRepositoryImpl() throws SQLException {
            DriverManager.registerDriver(new org.postgresql.Driver());
    }


    /**
     * A method that will insert a new User to the employee table
     * @param customer the user object
     * @throws SQLException
     */
    @Override
    public void insertCustomer(Customer customer) {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Customer\"(\"firstName\",\"lastName\",\"userName\",password,email) VALUES(?,?,?,?,?);");


            //set the parameters on the SQL statement
            statement.setString(1, customer.getFirstname());
            statement.setString(2, customer.getLastName());
            statement.setString(3, customer.getUserName());
            statement.setString(4, customer.getPassword());
            statement.setString(5, customer.getEmail());

            //execute update
            statement.executeUpdate();
            statement.close();

        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    /**
     * A method that will get a user from the database base on the userID
     * @param customerID user id provided for the search
     * @return return the user object
     * @throws SQLException
     */
    @Override
    public Customer getCustomer(int customerID){
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Customer\" WHERE \"Customer_id\" = ?;");

            //set the parameters on the SQL statement
            statement.setInt(1,customerID);

            //execute query
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                //store in a array all the objects from a row
                for(int i=0;i<row.length;i++) {
                    row[i] = resultSet.getObject(i+1);
                }


                    return new Customer((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4],(String)row[5]);

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
    public Customer getCustomerLogin(String userName, String password){
        Customer temp = null;
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Customer\" WHERE \"userName\" = ? AND password = ?;");
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
                temp= new Customer((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4],(String)row[5]);

            }
            resultSet.close();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return temp;
    }

    /**
     * A method that will update the User on the employee table
     * @param customerID user ID provide to search on table
     * @param newCustomer new user object that will update the existing one on database
     * @throws SQLException
     */
    @Override
    public void updateCustomer(int customerID, Customer newCustomer){
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("UPDATE \"Customer\" SET(\"firstName\", \"lastName\",\"userName\",password,email) = (?,?,?,?,?) WHERE \"Customer_id\"=?;");

            //set the userID parameters on the SQL statment
            statement.setInt(6,customerID);

            //set the parameters on the SQL statement
            statement.setString(1,newCustomer.getFirstname());
            statement.setString(2,newCustomer.getLastName());
            statement.setString(3,newCustomer.getPassword());
            statement.setString(4,newCustomer.getPassword());
            statement.setString(5,newCustomer.getEmail());


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
    public ArrayList<Customer> getCustomers(){
        ArrayList<Customer> temp = new ArrayList<>();
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Customer\";");

            //exegute command
            ResultSet resultSet = statement.executeQuery();

            while (resultSet.next()){
                Object[] row = new Object[resultSet.getMetaData().getColumnCount()];

                //store in a array all the objects from a row
                for(int i=0;i<row.length;i++) {
                    row[i] = resultSet.getObject(i+1);
                }

                temp.add(new Customer((int)row[0],(String)row[1],(String)row[2],(String)row[3],(String)row[4],(String)row[5]));


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
     * @param customerID user id provided for the search
     * @throws SQLException
     */
    @Override
    public void deleteCustomer(int customerID){
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("DELETE FROM \"Customer\" WHERE \"Customer_id\"=?;");
            statement.setInt(1, customerID);
            statement.executeUpdate();
            statement.close();
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public boolean doesUsernameExists(String username) {
        //TODO search here if the customer already exists and return the corresponding boolean...
        return false;
    }
}
