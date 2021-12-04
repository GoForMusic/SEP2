package server.database.chat;

import server.database.DataBaseConnection;
import shared.utils.Request;
import shared.utils.chat.Message;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
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
            PreparedStatement statement = connection.prepareStatement("INSERT INTO \"Message\"(\"Username\",\"Message_Body\") VALUES (?,?)");



        } catch (SQLException throwables) {
            throw new Exception(throwables.getMessage());
        }
    }
}
