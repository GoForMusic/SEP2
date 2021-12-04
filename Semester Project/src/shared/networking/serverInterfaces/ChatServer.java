package shared.networking.serverInterfaces;

import shared.utils.Request;
import shared.utils.chat.Message;

public interface ChatServer {
    Request sendMessage(Message message);
}
