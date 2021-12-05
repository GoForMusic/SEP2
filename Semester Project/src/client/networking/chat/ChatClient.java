package client.networking.chat;

import shared.utils.Request;
import shared.utils.chat.Message;

import java.util.List;

/**
 * The client class for chat that deals with communication with the server regarding chat between customer and cleaner
 */
public interface ChatClient {

    Request sendMessage(Message message);

    Request getAllReceptionists() throws Exception;

    Request getAllCustomersWhoWantsToChar(String username);}
