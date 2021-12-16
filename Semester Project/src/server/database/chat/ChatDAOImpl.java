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

/**
 * @author Sachin
 * A class that will implement ChatDAO interface function
 */
public class ChatDAOImpl implements ChatDAO {

    private static ChatDAO instance;
    private static Lock lock = new ReentrantLock();

    /**
     * A constructor that will initialize the link with db driver
     * @throws Exception
     */
    private ChatDAOImpl() throws Exception {
        try {
            DriverManager.registerDriver(new org.postgresql.Driver());
        } catch (SQLException e) {
            throw new Exception(e);
        }
    }

    /**
     * A function used for singleton
     * @return instance
     * @throws Exception
     */
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


    /**
     * A function that will add a message to the database
     * @param message the message to be added to the database
     * @return message
     * @throws Exception
     */
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

    /**
     * A function that will get all the receptionist
     * @return list of receptionist
     * @throws Exception
     */
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

    /**
     * A function that will get all customers who wants to chat
     * @param username the username of the receptionist
     * @return a list of customers
     * @throws Exception
     */
    @Override
    public Request getAllCustomersWhoWantsToChat(String username) throws Exception {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT DISTINCT \"Username_Sender\" from \"Message\" WHERE \"Username_Receiver\" =?;");
            statement.setString(1, username);
            ResultSet resultSet = statement.executeQuery();
            List<String> customers = new ArrayList<>();
            while (resultSet.next()) {
                customers.add(resultSet.getString("Username_Sender"));
            }
            return new Request("Customers wanting to chat", customers);
        } catch (SQLException throwables) {
            throwables.printStackTrace();
            throw new Exception(throwables.getMessage());
        }
    }

    /**
     * A function that will get all the messages
     * @param username the username of the user
     * @param client the username of the user who the logged-in user is chatting with
     * @return list of messages
     * @throws Exception
     */
    @Override
    public List<Message> getAllMessages(String username, String client) throws Exception {
        try (Connection connection = DataBaseConnection.getConnection()) {
            PreparedStatement statement = connection.prepareStatement("SELECT * FROM \"Message\" WHERE \"Username_Sender\"=? AND \"Username_Receiver\"=? OR \"Username_Sender\"=? AND \"Username_Receiver\"=?; ");
            statement.setString(1, username);
            statement.setString(2, client);
            statement.setString(3, client);
            statement.setString(4, username);
            ResultSet resultSet = statement.executeQuery();
            List<Message> allMessages = new ArrayList<>();
            while (resultSet.next()) {
                String usernameSender = resultSet.getString("Username_Sender");
                String usernameReceiver = resultSet.getString("Username_Receiver");
                String messageBody = resultSet.getString("Message_Body");
                Message message = new Message(usernameSender, usernameReceiver, messageBody);
                allMessages.add(message);
            }
            return allMessages;
        } catch (SQLException throwables) {
            throw new Exception(throwables.getMessage());
        }
    }
}
