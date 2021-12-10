package server.database.receptionist;

import server.database.DataBaseConnection;
import shared.utils.User.Receptionist;
import shared.utils.Request;

import java.sql.*;
import java.util.ArrayList;

public class ReceptionistDAOImpl implements ReceptionistDAO{

    public ReceptionistDAOImpl()
    {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void updateReceptionist(Receptionist receptionist, String oldUsername) {
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("UPDATE \"User\" SET (firstname,lastname,username,password)=(?,?,?,?) WHERE \"username\"=?;");
            statement.setString(1,receptionist.getFirstname());
            statement.setString(2,receptionist.getLastName());
            statement.setString(3,receptionist.getUserName());
            statement.setString(4,receptionist.getPassword());
            statement.setString(5,oldUsername);

            statement.executeUpdate();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public void removeReceptionist(Receptionist receptionist) {
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("DELETE FROM \"User\" WHERE \"username\"=?;");
            statement.setString(1,receptionist.getUserName());

            statement.executeUpdate();
        }catch (SQLException e)
        {
            System.out.println(e.getMessage());
        }
    }

    @Override
    public Receptionist getReceptionist(String username) {
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"User\" WHERE \"username\"=?;");
            statement.setString(1,username);

            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String firstname = resultSet.getString("firstname");
                String lastname =resultSet.getString("lastname");
                String password = resultSet.getString("password");
                connection.close();
                return new Receptionist(firstname,lastname,username,password);
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
    public ArrayList<Receptionist> getReceptionists() {
        ArrayList<Receptionist> list = new ArrayList<>();
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"User\" WHERE access_type = 'RECEPTIONIST';");

            ResultSet resultSet = statement.executeQuery();
            while (resultSet.next()){
                String firstname = resultSet.getString("firstname");
                String lastname =resultSet.getString("lastname");
                String username =resultSet.getString("username");
                String password = resultSet.getString("password");
                list.add(new Receptionist(firstname,lastname,username,password));
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
