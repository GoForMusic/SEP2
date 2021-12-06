package client.model.chat;

import client.networking.chat.ChatClient;
import shared.utils.Observer;
import shared.utils.Request;
import shared.utils.chat.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

public class ChatModelImpl implements ChatModel {
    private ChatClient chatClient;
    private PropertyChangeSupport support;

    public ChatModelImpl(ChatClient chatClient) {
        support = new PropertyChangeSupport(this);
        this.chatClient = chatClient;
        chatClient.addListener(Observer.MESSAGE_RECEIVED.toString(), this::messageReceived);
    }

    private void messageReceived(PropertyChangeEvent event) {
        System.out.println("Model fires property change");
        support.firePropertyChange(event);
    }

    @Override
    public void sendMessage(Message message) {
        chatClient.sendMessage(message);
    }

    @Override
    public Request getAllReceptionists() {
        try {
            return chatClient.getAllReceptionists();
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public Request getAllCustomersWhoWantsToChat(String username) {
        return chatClient.getAllCustomersWhoWantsToChat(username);
    }

    @Override
    public List<Message> getAllMessages(String username, String client) {
        return chatClient.getALlMessages(username,client);
    }


    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
