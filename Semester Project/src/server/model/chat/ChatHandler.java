package server.model.chat;

import shared.utils.Request;
import shared.utils.chat.Message;

import java.util.List;

public interface ChatHandler {
    Request sendMessage(Message message);

    Request getAllReceptionists();

    Request getAllCustomersWhoWantsToChat(String username);

    List<Message> getAllMessages(String username, String client);
}
