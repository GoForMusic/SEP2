package client.model.chat;

import shared.utils.Request;
import shared.utils.chat.Message;

import java.util.List;

public interface ChatModel {
    Request sendMessage(Message message);

    Request getAllReceptionists();

    Request getAllCustomersWhoWantsToChat(String username);
}
