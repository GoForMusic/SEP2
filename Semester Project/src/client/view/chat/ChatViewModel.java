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
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.ImagePattern;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Circle;
import shared.utils.Request;
import shared.utils.User.Usertype;
import shared.utils.chat.Message;

import java.io.File;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;


public class ChatViewModel {
    private BooleanProperty emoji;
    private StringProperty message, usernameReceiver;
    private ChatModel chatModel;
    private LoginModel loginModel;
    private double clientListBoxPrefWidth;
    private List<HBox> clientContainer;
    private HBox chatBox;

    public ChatViewModel(ModelFactory modelFactory) {
        this.chatModel = modelFactory.getChatModel();
        this.loginModel = modelFactory.getLoginModel();
        initializeProperties();
        clientContainer = new ArrayList<>();
        chatBox = new HBox();
        loadClients();
    }

    public List<HBox> getContainer() {
        return clientContainer;
    }

    public HBox getChatBox() {
        return chatBox;
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
        if (usernameReceiver.get()==null){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("User not selected");
            alert.setHeaderText("User not selected");
            alert.setContentText("Please select a user to send a message");
            alert.getButtonTypes().setAll(ButtonType.OK);
            alert.showAndWait();
        }
        else{
            Request request = chatModel.sendMessage(new Message(loginModel.getUsername(), usernameReceiver.get(), message.get()));
            message.set("");
        }

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

    private void loadClients() {
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
            HBox container = new HBox();
            container.setAlignment(Pos.CENTER_LEFT);
            container.setSpacing(10);
            container.setPrefWidth(clientListBoxPrefWidth);
            container.setPadding(new Insets(3));
            container.getStyleClass().add("online-user-container");
            Circle img = new Circle(28,28,14);
            try {
                Image image = new Image(new FileInputStream("Semester Project/src/client/view/images/user.png"));
                img.setFill(new ImagePattern(image));
            } catch (Exception e) {
                System.out.println("Failed loading image");
            }
            img.getStyleClass().add("imageView");
            container.getChildren().add(img);


            ;
            Label user = new Label(client);
            user.getStyleClass().add("online-label");
           container.getChildren().add(user);

            clientContainer.add(container);
        }

    }




}
