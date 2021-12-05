package shared.networking.serverInterfaces;

import shared.utils.Request;
import shared.utils.chat.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatServer extends Remote {
    Request sendMessage(Message message) throws RemoteException;

    Request getAllReceptionists()throws RemoteException;

    Request getAllCustomersWhoWantsToChat(String username) throws RemoteException;
}
