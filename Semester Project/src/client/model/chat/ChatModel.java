package client.model.chat;

import shared.utils.Request;
import shared.utils.Subject;
import shared.utils.chat.Message;

public interface ChatModel extends Subject {
    Request sendMessage(Message message);

    Request getAllReceptionists();

    Request getAllCustomersWhoWantsToChat(String username);

}
