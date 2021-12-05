package server.database.chat;

import shared.utils.Request;
import shared.utils.chat.Message;

public interface ChatDAO {
    Request addMessage(Message message) throws Exception;

    Request getAllReceptionists() throws Exception;

    Request getAllCustomersWhoWantsToChat(String username) throws Exception;
}