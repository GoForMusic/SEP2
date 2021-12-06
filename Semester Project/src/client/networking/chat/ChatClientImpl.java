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

public class ChatClientImpl implements ChatClient, ChatCallBack {

    private Server server;
    private String username;
    private String userType;
    private PropertyChangeSupport support;

    public ChatClientImpl() {
        this.support = new PropertyChangeSupport(this);
        try {
            UnicastRemoteObject.exportObject(this, 0);
        } catch (RemoteException e) {
            e.printStackTrace();
        }
        this.server = GetServer.getServerFromRmi();
    }

    @Override
    public Request sendMessage(Message message) {
        try {
            return server.getChatServer().sendMessage(message);
        } catch (RemoteException e) {
            return new Request("Cannot connect to server", null);
        }
    }

    @Override
    public Request getAllReceptionists() throws Exception {
        try {
            return server.getChatServer().getAllReceptionists();
        } catch (RemoteException e) {
            return new Request("Cannot connect to server", null);
        }
    }

    @Override
    public Request getAllCustomersWhoWantsToChat(String username) {
        try {
            return server.getChatServer().getAllCustomersWhoWantsToChat(username);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }

    @Override
    public void setUsername(String username) {
        this.username = username;
    }

    @Override
    public String getUsername() throws RemoteException {
        return username;
    }

    @Override
    public void setUserType(String userType) {
        this.userType = userType;
    }

    @Override
    public String getUserType() throws RemoteException {
        return null;
    }

    @Override
    public void messageReceived(Message message) throws RemoteException {
        support.firePropertyChange(Observer.MESSAGE_RECEIVED.toString(),null,message);

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
