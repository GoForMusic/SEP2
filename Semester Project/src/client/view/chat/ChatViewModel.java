package client.view.chat;

import client.core.ModelFactory;
import client.model.chat.ChatModel;
import client.model.login.LoginModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.utils.Request;
import shared.utils.chat.Message;

public class ChatViewModel {
    private BooleanProperty emoji;
    private StringProperty message;
    private ChatModel chatModel;
    private LoginModel loginModel;

    public ChatViewModel(ModelFactory modelFactory) {
        this.chatModel=modelFactory.getChatModel();
        this.loginModel= modelFactory.getLoginModel();
        emoji = new SimpleBooleanProperty();
        message = new SimpleStringProperty();
    }

    public void makeEmojiInVisible() {
        emoji.set(false);
    }

    public void makeEmojiVisible() {
        emoji.set(true);
    }

    public BooleanProperty getEmojiProperty() {
        return emoji;
    }

    public boolean isEmojiVisible() {
        return emoji.get();
    }

    public StringProperty getMessage() {
        return message;
    }

    public void sendMessage() {
        if (message.get().equals("")) return;
        Request request = chatModel.sendMessage(new Message(loginModel.getUsername(), true,message.get()));
        message.set("");
    }
}
