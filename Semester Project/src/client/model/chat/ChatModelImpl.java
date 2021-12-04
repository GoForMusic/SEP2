package client.model.chat;

import client.networking.chat.ChatClient;
import shared.utils.Request;
import shared.utils.chat.Message;

public class ChatModelImpl implements ChatModel {
    private ChatClient chatClient;

    public ChatModelImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }

    @Override
    public Request sendMessage(Message message) {
        return chatClient.sendMessage(message);
    }
}
