package client.networking.chat;

import shared.utils.Request;
import shared.utils.Subject;
import shared.utils.chat.Message;

import java.util.List;

/**
 * @author Sachin Baral
 * The client class for chat that deals with communication with the server regarding chat between customer and cleaner
 */
public interface ChatClient extends Subject {

    void sendMessage(Message message);

    Request getAllReceptionists() throws Exception;

    Request getAllCustomersWhoWantsToChat(String username);

    void setUsername(String username);

    void setUserType(String userType);

    List<Message> getALlMessages(String username, String client);
}
