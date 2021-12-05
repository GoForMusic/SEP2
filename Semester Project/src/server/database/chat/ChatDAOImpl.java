package server.database.chat;

import server.database.DataBaseConnection;
import shared.utils.Request;
import shared.utils.User.Usertype;
import shared.utils.chat.Message;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

public class ChatDAOImpl implements ChatDAO {

    private static ChatDAO instance;
    private static Lock lock = new ReentrantLock();

    private ChatDAOImpl() throws Exception {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    public static ChatDAO getInstance() throws Exception {
        if (instance == null) {
            synchronized (lock) {
                if (instance == null) {
                    instance = new ChatDAOImpl();
                }
            }
        }
        return instance;
    }


    @Override
    public Request addMessage(Message message) throws Exception {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Message\"(\"Username_Sender\", \"Username_Receiver\",\"Message_Body\") VALUES (?,?,?);");
            statement.setString(1, message.getUserNameSender());
            statement.setString(2, message.getUserNameReceiver());
            statement.setString(3, message.getMessageBody());
            statement.executeUpdate();
            return new Request("Message sent", message);
        } catch (SQLException throwables) {
            throw new Exception(throwables.getMessage());
        }
    }

    @Override
    public Request getAllReceptionists() throws Exception {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT \"username\" FROM \"User\" WHERE \"access_type\"=?;");
            statement.setString(1, Usertype.RECEPTIONIST.toString());
            ResultSet resultSet = statement.executeQuery();
            List<String> receptionists = new ArrayList<>();
            while (resultSet.next()) {
                receptionists.add(resultSet.getString("username"));
            }
            return new Request("All receptionists", receptionists);
        } catch (SQLException throwables) {
            throw new Exception(throwables.getMessage());
        }
    }

    @Override
    public Request getAllCustomersWhoWantsToChat(String username) throws Exception {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT \"Username_Sender\" from \"Message\" WHERE \"Username_Receiver\" =?;");
            statement.setString(1,username);
            ResultSet resultSet = statement.executeQuery();
            List<String> customers = new ArrayList<>();
            while (resultSet.next()) {
                customers.add(resultSet.getString("Username_Sender"));
            }
            return new Request("Customers wanting to chat",customers);
        } catch (SQLException throwables) {
            throw new Exception(throwables.getMessage());
        }
    }
}
