package server.database.chat;

import shared.utils.Request;
import shared.utils.chat.Message;

import java.util.List;

/**
 * @author Sachin Baral
 * The DAO that deals with writing and retrieving messages from database.
 */
public interface ChatDAO {
    /**
     * Adds message to the database
     * @param message the message to be added to the database
     * @return the request object with the added message
     * @throws Exception JAVA exception converted from SQL Exception
     */
    Request addMessage(Message message) throws Exception;

    /**
     * Gets all the receptionists from the database
     * @return the request object with the receptionists
     * @throws Exception JAVA exception converted from SQL Exception
     */
    Request getAllReceptionists() throws Exception;

    /**
     * Gets all the customers who want to chat for a receptionist
     * @param username the username of the receptionist
     * @return the request object with the list of all the customers who wants to chat
     * @throws Exception JAVA exception converted from SQL Exception
     */

    Request getAllCustomersWhoWantsToChat(String username) throws Exception;

    /**
     * Gets all the messages between two users
     * @param username the username of the user
     * @param client the username of the user who the logged-in user is chatting with
     * @return the list of all the messages between them
     * @throws Exception JAVA exception converted from SQL Exception
     */

    List<Message> getAllMessages(String username, String client) throws Exception;
}
