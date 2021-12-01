package server.database.customer;

import server.database.DataBaseConnection;
import shared.utils.Request;
import shared.utils.User.Customer;

import java.sql.*;
import java.util.ArrayList;

public class CustomerDAOImpl implements CustomerDAO {

    public CustomerDAOImpl() {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateCustomer(Customer customer, String oldUsername) {
//        try(Connection connection = DataBaseConnection.getConnection()){
//            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"User\" WHERE \"username\"=?;");
//            statement.setString(1,oldUsername);
//
//            ResultSet resultSet = statement.executeQuery();
//            if (resultSet.next()){
//                String firstname = resultSet.getString("firstname");
//                String lastname =resultSet.getString("lastname");
//                String password = resultSet.getString("password");
//                connection.close();
//                return new Customer(firstname,lastname,username,password);
//            }
//            else{
//                connection.close();
//            }
//        }catch (SQLException e)
//        {
//            System.out.println(e.getMessage());
//        }
    }


    @Override
    public void removeCustomer(Customer customer) {

    }

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

    @Override
    public ArrayList<Customer> getCustomers() {
        ArrayList<Customer> list = new ArrayList<>();
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("select * from \"User\"");

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
