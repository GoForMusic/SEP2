package client.model.chat;

import client.networking.chat.ChatClient;
import shared.utils.Request;
import shared.utils.chat.Message;

import java.util.List;

public class ChatModelImpl implements ChatModel {
    private ChatClient chatClient;

    public ChatModelImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public Request sendMessage(Message message) {
        return chatClient.sendMessage(message);
    }

    @Override
    public Request getAllReceptionists() {
        try {
            return chatClient.getAllReceptionists();
        } catch (Exception e) {
            return new Request(e.getMessage(),null);
        }
    }

    @Override
    public Request getAllCustomersWhoWantsToChat(String username) {
        return chatClient.getAllCustomersWhoWantsToChar(username);
    }
}
