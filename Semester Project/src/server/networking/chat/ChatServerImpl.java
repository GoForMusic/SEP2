package server.networking.chat;

import server.model.chat.ChatHandler;
import shared.networking.serverInterfaces.ChatServer;
import shared.utils.Request;
import shared.utils.chat.Message;

public class ChatServerImpl implements ChatServer {

    private ChatHandler chatHandler;


    public ChatServerImpl(ChatHandler chatHandler) {
        this.chatHandler = chatHandler;
    }

    @Override
    public Request sendMessage(Message message) {
        return chatHandler.sendMessage(message);
    }

    @Override
    public Request getAllReceptionists() {
        return chatHandler.getAllReceptionists();
    }

    @Override
    public Request getAllCustomersWhoWantsToChat(String username) {
        return chatHandler.getAllCustomersWhoWantsToChat(username);
    }
}
