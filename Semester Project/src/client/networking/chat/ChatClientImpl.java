package client.networking.chat;

import client.networking.GetServer;
import shared.networking.clientInterfaces.ChatCallBack;
import shared.networking.serverInterfaces.Server;
import shared.utils.Observer;
import shared.utils.Request;
import shared.utils.chat.Message;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.List;

/**
 * @author Sachin
 * A class that use all the function from ChatClient and ChatCallBack implementation
 */
public class ChatClientImpl implements ChatClient, ChatCallBack {

    private Server server;
    private String username;
    private String userType;
    private PropertyChangeSupport support;

    /**
     * A construction that will set-up the connection with RMI
     */
    public ChatClientImpl() {
        this.support = new PropertyChangeSupport(this);
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.server = GetServer.getServerFromRmi();
        try {
            server.getChatServer().registerChatCallBack(this);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
    }

    /**
     * A function that send message
     * @param message
     */
    @Override
    public void sendMessage(Message message) {
        try {
            server.getChatServer().sendMessage(message);
        } catch (RemoteException e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    /**
     * A function that get all the receptionist
     * @return a list of all the receptions
     * @throws Exception
     */
    @Override
    public Request getAllReceptionists() throws Exception {
        try {
            return server.getChatServer().getAllReceptionists();
        } catch (RemoteException e) {
            return new Request("Cannot connect to server", null);
        }
    }

    /**
     * A function get all customers
     * @param username
     * @return return list of customers
     */
    @Override
    public Request getAllCustomersWhoWantsToChat(String username) {
        try {
            return server.getChatServer().getAllCustomersWhoWantsToChat(username);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }

    /**
     * A function to set username
     * @param username
     */
    @Override
    public void setUsername(String username) {
        System.out.println("ChatClient ......username set as"+username);
        this.username = username;
    }

    /**
     * A function that return a username
     * @return username
     * @throws RemoteException
     */
    @Override
    public String getUsername() throws RemoteException {
        return username;
    }

    /**
     * A function that set user type
     * @param userType
     */
    @Override
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * A function that will return a list of messages
     * @param username
     * @param client
     * @return a list of messages
     */
    @Override
    public List<Message> getALlMessages(String username, String client) {
        try {
            return server.getChatServer().getAllMessages(username,client);
        } catch (RemoteException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * A function that return user type
     * @return usertype
     * @throws RemoteException
     */
    @Override
    public String getUserType() throws RemoteException {
        return null;
    }

    /**
     * A function that will receive a message
     * @param message
     * @throws RemoteException
     */
    @Override
    public void messageReceived(Message message) throws RemoteException {
        System.out.println("Property change fireddddd");
        support.firePropertyChange(Observer.MESSAGE_RECEIVED.toString(),null,message);

    }

    /**
     * A function that change listener
     * @param eventName
     * @param listener
     */
    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    /**
     * A function that remove listener
     * @param eventName
     * @param listener
     */
    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
