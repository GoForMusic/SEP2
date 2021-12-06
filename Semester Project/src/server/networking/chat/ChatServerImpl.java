package server.networking.chat;

import server.model.chat.ChatHandler;
import shared.networking.clientInterfaces.ChatCallBack;
import shared.networking.serverInterfaces.ChatServer;
import shared.utils.Request;
import shared.utils.chat.Message;

import java.beans.PropertyChangeListener;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class ChatServerImpl implements ChatServer {

    private ChatHandler chatHandler;


    public ChatServerImpl(ChatHandler chatHandler) throws RemoteException {
        this.chatHandler = chatHandler;
        UnicastRemoteObject.exportObject(this,0);
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

