package client.view.chat;

import client.core.ModelFactory;
import client.model.chat.ChatModel;
import client.model.login.LoginModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import shared.utils.Request;
import shared.utils.User.Usertype;
import shared.utils.chat.Message;

import java.io.File;
import java.util.List;


public class ChatViewModel {
    private BooleanProperty emoji;
    private StringProperty message, usernameReceiver;
    private ChatModel chatModel;
    private LoginModel loginModel;
    private double clientListBoxPrefWidth;
    private HBox clientContainer;

    public ChatViewModel(ModelFactory modelFactory) {
        this.chatModel = modelFactory.getChatModel();
        this.loginModel = modelFactory.getLoginModel();
        initializeProperties();
        clientContainer = new HBox();
        loadClients();
    }

    public HBox getClientContainer() {
        return clientContainer;
    }

    public void setClientListBoxPrefWidth(double clientListBoxPrefWidth) {
        System.out.println(clientListBoxPrefWidth);
        this.clientListBoxPrefWidth = clientListBoxPrefWidth;
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
        Request request = chatModel.sendMessage(new Message(loginModel.getUsername(), usernameReceiver.get(), message.get()));
        message.set("");
    }

    private void initializeProperties() {
        emoji = new SimpleBooleanProperty();
        emoji.set(false);
        message = new SimpleStringProperty();
        usernameReceiver = new SimpleStringProperty();
    }

    private Request getALlReceptionists() {
        return chatModel.getAllReceptionists();
    }

    private Request getCustomers() {
        return chatModel.getAllCustomersWhoWantsToChat(loginModel.getUsername());
    }

    public void loadClients() {
        Request responseFromServer = null;
        if (loginModel.getUserType().equals(Usertype.RECEPTIONIST.toString())) {
            System.out.println("Receptionist");
            responseFromServer = getCustomers();
        } else if (loginModel.getUserType().equals(Usertype.CUSTOMER.toString())) {
            responseFromServer = getALlReceptionists();
        }
        if (!(responseFromServer.getObject() instanceof List)) {
            System.out.println("List not returned");
            System.out.println(responseFromServer.getObject());
            System.out.println(responseFromServer.getType());
            return;
        }
        List<String> allClients = (List<String>) responseFromServer.getObject();
        for (String client : allClients
        ) {
            if (client.equals(loginModel.getUsername())) continue;
            clientContainer.setAlignment(Pos.CENTER_LEFT);
            clientContainer.setSpacing(10);
            clientContainer.setPadding(new Insets(3));
            clientContainer.setPrefWidth(clientListBoxPrefWidth);
            clientContainer.getStyleClass().add("online-user-container");
            Circle img = new Circle(30, 30, 15);
            String path = new File(String.format("user.png", client)).toURI().toString();
            img.setFill(new ImagePattern(new Image(path)));
            clientContainer.getChildren().add(img);

            VBox userDetailContainer = new VBox();
            userDetailContainer.setPrefWidth(clientListBoxPrefWidth);
            Label lblUsername = new Label(client);
            lblUsername.getStyleClass().add("online-label");
            userDetailContainer.getChildren().add(lblUsername);

            //TODO the user stuff..
            clientContainer.getChildren().add(userDetailContainer);
        }

    }


}
