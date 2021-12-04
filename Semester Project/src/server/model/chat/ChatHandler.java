package server.model.chat;

import shared.utils.Request;
import shared.utils.chat.Message;

public interface ChatHandler {
    Request sendMessage(Message message);

}
