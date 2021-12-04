package client.model.chat;

import client.networking.chat.ChatClient;

public class ChatModelImpl implements ChatModel {
    private ChatClient chatClient;

    public ChatModelImpl(ChatClient chatClient) {
        this.chatClient = chatClient;
    }
}
