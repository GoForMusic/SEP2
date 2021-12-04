package client.networking.chat;

import shared.utils.Request;
import shared.utils.chat.Message;

/**
 * The client class for chat that deals with communication with the server regarding chat between customer and cleaner
 */
public interface ChatClient {

    Request sendMessage(Message message);
}
