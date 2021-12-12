package client.model.chat;

import client.networking.chat.ChatClient;
import shared.utils.Observer;
import shared.utils.Request;
import shared.utils.chat.Message;

import java.beans.PropertyChangeEvent;
import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.util.List;

/**
 * @author Sachin
 * A class that will implement all the ChatModel interface functions
 */
public class ChatModelImpl implements ChatModel {
    private ChatClient chatClient;
    private PropertyChangeSupport support;

    /**
     * A construction that will initialize the chat client and add a listener
     */
    public ChatModelImpl(ChatClient chatClient) {
        support = new PropertyChangeSupport(this);
        this.chatClient = chatClient;
        chatClient.addListener(Observer.MESSAGE_RECEIVED.toString(), this::messageReceived);
    }

    /**
     * A private function that will fireproprty change
     */
    private void messageReceived(PropertyChangeEvent event) {
        System.out.println("Model fires property change");
        support.firePropertyChange(event);
    }

    /**
     * A function that will send a message
     */
    @Override
    public void sendMessage(Message message) {
        chatClient.sendMessage(message);
    }

    /**
     * A function that will get all the receptionist
     */
    @Override
    public Request getAllReceptionists() {
        try {
            return chatClient.getAllReceptionists();
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    /**
     * A function that will get all the customers who is asking for help
     */
    @Override
    public Request getAllCustomersWhoWantsToChat(String username) {
        return chatClient.getAllCustomersWhoWantsToChat(username);
    }

    /**
     * A function that will get all the messages
     * @return List of all messages
     */
    @Override
    public List<Message> getAllMessages(String username, String client) {
        return chatClient.getALlMessages(username,client);
    }

    /**
     * A function that will change the property listener
     */
    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);

    }

    /**
     * A function that will remove the listener
     */
    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
