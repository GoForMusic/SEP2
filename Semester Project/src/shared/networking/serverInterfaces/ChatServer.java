package shared.networking.serverInterfaces;

import shared.networking.clientInterfaces.ChatCallBack;
import shared.utils.Request;
import shared.utils.chat.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.List;

public interface ChatServer extends Remote {
    void sendMessage(Message message) throws RemoteException;

    Request getAllReceptionists()throws RemoteException;

    Request getAllCustomersWhoWantsToChat(String username) throws RemoteException;

    void registerChatCallBack(ChatCallBack chatCallBack) throws RemoteException;

    List<Message> getAllMessages(String username, String client) throws RemoteException;
}
