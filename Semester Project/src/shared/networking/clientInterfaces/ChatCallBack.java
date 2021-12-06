package shared.networking.clientInterfaces;

import shared.utils.chat.Message;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface ChatCallBack extends Remote {
    void setUsername(String username) throws RemoteException;

    String getUsername() throws RemoteException;

    void setUserType(String userType) throws RemoteException;

    String getUserType() throws RemoteException;

    void messageReceived(Message message) throws RemoteException;

}
