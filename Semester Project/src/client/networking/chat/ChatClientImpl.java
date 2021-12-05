package client.networking.chat;

import client.networking.GetServer;
import shared.networking.serverInterfaces.Server;
import shared.utils.Request;
import shared.utils.chat.Message;

import java.rmi.RemoteException;

public class ChatClientImpl implements ChatClient {

    private Server server;

    public ChatClientImpl() {
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
    public Request getAllCustomersWhoWantsToChar(String username) {
        try {
            return server.getChatServer().getAllCustomersWhoWantsToChat(username);
        } catch (RemoteException e) {
            e.printStackTrace();
            return new Request("Cannot connect to server", null);
        }
    }
}
