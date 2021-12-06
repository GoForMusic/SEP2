package client.model.chat;

import shared.utils.Request;
import shared.utils.Subject;
import shared.utils.chat.Message;

import java.util.List;

public interface ChatModel extends Subject {
    void sendMessage(Message message);

    Request getAllReceptionists();

    Request getAllCustomersWhoWantsToChat(String username);

    List<Message> getAllMessages(String username, String client);

}
