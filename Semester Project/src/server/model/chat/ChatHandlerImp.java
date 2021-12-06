package server.model.chat;

import server.database.chat.ChatDAO;
import server.database.chat.ChatDAOImpl;
import shared.utils.Request;
import shared.utils.chat.Message;

import java.util.List;

public class ChatHandlerImp implements ChatHandler {

    private ChatDAO chatDAO;

    public ChatHandlerImp() {
    }

    @Override
    public Request sendMessage(Message message) {
        try {
            return ChatDAOImpl.getInstance().addMessage(message);
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public Request getAllReceptionists() {
        try {
            return ChatDAOImpl.getInstance().getAllReceptionists();
        } catch (Exception e) {
            return new Request(e.getMessage(), null);
        }
    }

    @Override
    public Request getAllCustomersWhoWantsToChat(String username) {
        try {
            return ChatDAOImpl.getInstance().getAllCustomersWhoWantsToChat(username);
        } catch (Exception e) {
            return new Request(e.getMessage(),null);
        }
    }

    @Override
    public List<Message> getAllMessages(String username, String client) {
        try {
            return ChatDAOImpl.getInstance().getAllMessages(username,client);
        } catch (Exception e) {
            e.printStackTrace();
            return null;
        }
    }
}
