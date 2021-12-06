package server.networking.chat;

import server.model.chat.ChatHandler;
import shared.networking.clientInterfaces.ChatCallBack;
import shared.networking.serverInterfaces.ChatServer;
import shared.utils.Request;
import shared.utils.chat.Message;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.List;

public class ChatServerImpl implements ChatServer {

    private ChatHandler chatHandler;
    private List<ChatCallBack> callBacks;


    public ChatServerImpl(ChatHandler chatHandler) throws RemoteException {
        this.chatHandler = chatHandler;
        callBacks = new ArrayList<>();
        UnicastRemoteObject.exportObject(this, 0);
    }

    @Override
    public void sendMessage(Message message) {
        Request request = chatHandler.sendMessage(message);
        if (request.getObject()==null) return;
        if (request.getObject() instanceof Message) {
            notifyCallBacks((Message) request.getObject());
        }
    }

    private void notifyCallBacks(Message message) {
        for (ChatCallBack i : callBacks
        ) {
            try {
                if (i.getUsername().equals(message.getUserNameReceiver()) || i.getUsername().equals(message.getUserNameSender())) {
                    i.messageReceived(message);
                }
            } catch (RemoteException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public Request getAllReceptionists() {
        return chatHandler.getAllReceptionists();
    }

    @Override
    public Request getAllCustomersWhoWantsToChat(String username) {
        return chatHandler.getAllCustomersWhoWantsToChat(username);
    }

    @Override
    public void registerChatCallBack(ChatCallBack chatCallBack) {
        this.callBacks.add(chatCallBack);
    }

    @Override
    public List<Message> getAllMessages(String username, String client) throws RemoteException {
        return chatHandler.getAllMessages(username,client);
    }


}

