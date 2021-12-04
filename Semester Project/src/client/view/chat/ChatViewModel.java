package client.view.chat;

import client.core.ModelFactory;
import client.model.chat.ChatModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.utils.Request;

public class ChatViewModel {
    private BooleanProperty emoji;
    private StringProperty message;
    private ChatModel chatModel;

    public ChatViewModel(ModelFactory modelFactory) {
        this.chatModel=modelFactory.getChatModel();
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
        Request request = chatModel.sendMessage(message.get());
        message.set("");



    }
}
