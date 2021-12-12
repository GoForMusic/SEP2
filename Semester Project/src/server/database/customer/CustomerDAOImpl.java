package server.database.customer;

import server.database.DataBaseConnection;
import shared.utils.Request;
import shared.utils.User.Customer;

import java.sql.*;
import java.util.ArrayList;

/**
 * @author Adrian
 * A class that will implement all the customerDAO interface functions
 */
public class CustomerDAOImpl implements CustomerDAO {

    /**
     * A constructor that will initialize the db driver
     */
    public CustomerDAOImpl() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * A function that will update customer to db
     * @param customer
     * @param oldUsername
     */
    @Override
    public void updateCustomer(Customer customer, String oldUsername) {
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("UPDATE \"User\" SET (firstname,lastname,username,password)=(?,?,?,?) WHERE \"username\"=?;");
            statement.setString(1,customer.getFirstname());
            statement.setString(2,customer.getLastName());
            statement.setString(3,customer.getUserName());
            statement.setString(4,customer.getPassword());
            statement.setString(5,oldUsername);

            statement.executeUpdate();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }


    /**
     * A function that will remove customer to db
     * @param customer
     */
    @Override
    public void removeCustomer(Customer customer) {
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM \"User\" WHERE \"username\"=?;");
            statement.setString(1,customer.getUserName());

            statement.executeUpdate();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    /**
     * A function that will get customer from db
     * @param username
     * @return a customer
     */
    @Override
    public Customer getCustomer(String username) {
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"User\" WHERE \"username\"=?;");
            statement.setString(1,username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String firstname = resultSet.getString("firstname");
                String lastname =resultSet.getString("lastname");
                String password = resultSet.getString("password");
                connection.close();
                return new Customer(firstname,lastname,username,password);
            }
            else{
                connection.close();
            }
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        return null;
    }

    /**
     * A function that will get a list of customers from db
     * @return list of customers
     */
    @Override
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> list = new ArrayList<>();
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("select * from \"User\" WHERE access_type='CUSTOMER'");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String firstname = resultSet.getString("firstname");
                String lastname =resultSet.getString("lastname");
                String username =resultSet.getString("username");
                String password = resultSet.getString("password");
                list.add(new Customer(firstname,lastname,username,password));
            }
            connection.close();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
        System.out.println(list);
        return list;
    }
}
