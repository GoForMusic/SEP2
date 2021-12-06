package server.database.login;

import server.database.DataBaseConnection;
import shared.utils.Request;
import shared.utils.User.*;

import java.sql.*;


/**
 * @author Sachin Baral
 * @version 1.0
 */
public class LoginDAOImpl implements LoginDAO{
//    private LoginDAOImpl instance;

    public LoginDAOImpl() throws SQLException {
        DriverManager.registerDriver(new org.postgresql.Driver());
    }
//    public  LoginDAO getInstance(){
//        if (instance==null){
//            try {
//                instance= new LoginDAOImpl();
//            } catch (SQLException e) {
//                e.printStackTrace();
//            }
//        }
//        return instance;
//    }

    @Override
    public Request login(String username, String password ) throws SQLException {
        try(Connection connection = DataBaseConnection.getConnection()){
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"User\" WHERE \"username\"=? and \"password\"=?;");
            statement.setString(1,username);
            statement.setString(2,password);
            ResultSet resultSet = statement.executeQuery();
            if (resultSet.next()){
                String firstname = resultSet.getString("firstname");
                String lastname =resultSet.getString("lastname");
                String accessType = resultSet.getString("access_type");
                connection.close();
                return getUserType(firstname,lastname,username,accessType);
            }
            else{
                connection.close();
                return new Request("Username or password incorrect",null);
            }
        }catch (SQLException e)
        {
            return new Request(e.getMessage(),null);
        }
    }

    private Request getUserType(String firstname, String lastname,String username, String accessType) {
        if (accessType.equals(Usertype.ADMIN.toString())){
            return new Request(Usertype.ADMIN.toString(),new Admin(firstname,lastname,username));
        }
        else if (accessType.equals(Usertype.RECEPTIONIST.toString())){
            return new Request(Usertype.RECEPTIONIST.toString(), new Receptionist(firstname,lastname,username));
        } else if (accessType.equals(Usertype.CUSTOMER.toString())) {
            return new Request(Usertype.CUSTOMER.toString(), new Customer(firstname,lastname,username));
        } else if(accessType.equals(Usertype.CLEANER.toString())){
            return new Request(Usertype.CLEANER.toString(),new Cleaner(firstname,lastname,username));
        }else
        return new Request("Something went wrong in database",null);
    }
}
