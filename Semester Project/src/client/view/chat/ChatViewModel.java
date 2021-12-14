package client.view.chat;

import client.core.ModelFactory;
import client.model.chat.ChatModel;
import client.model.login.LoginModel;
import javafx.application.Platform;
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
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Circle;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import shared.utils.Observer;
import shared.utils.Request;
import shared.utils.User.Usertype;
import shared.utils.chat.Message;

import java.beans.PropertyChangeEvent;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Scahin
 * A class that will implement chat functions
 */
public class ChatViewModel {
    private BooleanProperty emoji;
    private StringProperty message, usernameReceiver;
    private ChatModel chatModel;
    private LoginModel loginModel;
    private double clientListBoxPrefWidth;
    private List<HBox> clientContainer;
    private VBox chatBox;
    private StringProperty client;

    /**
     * A constructor that will initialize every varaible
     * @param modelFactory
     */
    public ChatViewModel(ModelFactory modelFactory) {
        this.chatModel = modelFactory.getChatModel();
        this.loginModel = modelFactory.getLoginModel();
        initializeProperties();
        clientContainer = new ArrayList<>();
        chatBox = new VBox();
        loadClients();
        chatModel.addListener(Observer.MESSAGE_RECEIVED.toString(), this::updateMessage);
    }


    /**
     * A method that will return the container
     * @return container
     */
    public List<HBox> getContainer() {
        return clientContainer;
    }

    /**
     * A method that will return the chat box
     * @return chat box
     */
    public VBox getChatBox() {
        return chatBox;
    }

    /**
     * A method that will set client list box pref width
     * @param clientListBoxPrefWidth
     */
    public void setClientListBoxPrefWidth(double clientListBoxPrefWidth) {
        System.out.println(clientListBoxPrefWidth);
        this.clientListBoxPrefWidth = clientListBoxPrefWidth;
    }

    /**
     * A method that will make emojy invisible
     */
    public void makeEmojiInVisible() {
        emoji.set(false);
    }

    /**
     * A method that will make emojy visible
     */
    public void makeEmojiVisible() {
        emoji.set(true);
    }

    /**
     * A method that will return emoji
     * @return emoji
     */
    public BooleanProperty getEmojiProperty() {
        return emoji;
    }

    /**
     * A method that will return emoji
     * @return emoji
     */
    public boolean isEmojiVisible() {
        return emoji.get();
    }

    /**
     * A method that will return the message
     * @return message
     */
    public StringProperty getMessage() {
        return message;
    }

    /**
     * A method that will send a message
     */
    public void sendMessage() {
        if (message.get().equals("")) return;
        if (usernameReceiver.get() == null) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("User not selected");
            alert.setHeaderText("User not selected");
            alert.setContentText("Please select a user to send a message");
            alert.getButtonTypes().setAll(ButtonType.OK);
            alert.showAndWait();
        } else {
            chatModel.sendMessage(new Message(loginModel.getUsername(), usernameReceiver.get(), message.get()));
            message.set("");
        }
    }

    /**
     * A method that will initialize everything
     */
    private void initializeProperties() {
        emoji = new SimpleBooleanProperty();
        emoji.set(false);
        message = new SimpleStringProperty();
        usernameReceiver = new SimpleStringProperty();
        client = new SimpleStringProperty();
        if (loginModel.getUserType().equals(Usertype.RECEPTIONIST.toString())) {
            client.set("Customers");
        } else if (loginModel.getUserType().equals(Usertype.CUSTOMER.toString())) {
            client.set("Receptionists");
        }
    }

    /**
     * A method that will return all receptionist
     * @return all the receptionist
     */
    private Request getALlReceptionists() {
        return chatModel.getAllReceptionists();
    }

    /**
     * A method that will return all the customers
     * @return customers
     */
    private Request getCustomers() {
        return chatModel.getAllCustomersWhoWantsToChat(loginModel.getUsername());
    }

    /**
     * A method that will load clients
     */
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
            Circle img = getCircle();
            container.getChildren().add(img);
            Label user = new Label(client);
            user.getStyleClass().add("online-label");
            container.getChildren().add(user);
            container.setOnMouseClicked(mouseEvent -> {
                loadMessages(client);
            });

            clientContainer.add(container);
        }
    }

    /**
     * A method that will load messages
     * @param client
     */
    private void loadMessages(String client) {
        usernameReceiver.set(client);

        chatBox.getChildren().clear();
        List<Message> allMessages = chatModel.getAllMessages(loginModel.getUsername(), client);

        for (Message message : allMessages
        ) {
            updateUI(message);
        }


    }

    /**
     * A method that will update message
     * @param event
     */
    private void updateMessage(PropertyChangeEvent event) {
//        System.out.println("View model is here");
        if (event.getNewValue() instanceof Message) {
            Message tempMessage = (Message) event.getNewValue();
//            System.out.println("Recieved is messsage");
//            System.out.println("The sender is " + tempMessage.getUserNameSender());
//            System.out.println("The selected is " + usernameReceiver.get());
            if (usernameReceiver.get().equals(tempMessage.getUserNameReceiver()) || usernameReceiver.get().equals(tempMessage.getUserNameSender())) {
                System.out.println(usernameReceiver.get());
                Platform.runLater(() -> {
                    updateUI(tempMessage);
                });

            }
        }

    }

    /**
     * A method that will update UI
     * @param tempMessage
     */
    private void updateUI(Message tempMessage) {
        Text text = new Text(tempMessage.getMessageBody());
        text.setFill(Color.WHITE);
        text.getStyleClass().add("message");

        TextFlow tempFLow = new TextFlow();
        if (!loginModel.getUsername().equals(tempMessage.getUserNameSender())) {
            Text txtName = new Text(tempMessage.getUserNameSender() + "\n");
            txtName.getStyleClass().add("txtName");
            tempFLow.getChildren().add(txtName);
        }
        tempFLow.getChildren().add(text);
        tempFLow.setMaxWidth(180);

        TextFlow flow = new TextFlow(tempFLow);

        HBox hBox = new HBox(12);
        Circle img = getCircle();
        if (!loginModel.getUsername().equals(tempMessage.getUserNameSender())) {

            tempFLow.getStyleClass().add("tempFlowFlipped");
            flow.getStyleClass().add("textFlowFlipped");
            chatBox.setAlignment(Pos.TOP_LEFT);
            hBox.setAlignment(Pos.CENTER_LEFT);
            hBox.getChildren().add(img);
            hBox.getChildren().add(flow);
        } else {
            text.setFill(Color.WHITE);
            tempFLow.getStyleClass().add("tempFLow");
            flow.getStyleClass().add("textFlow");
            hBox.setAlignment(Pos.BOTTOM_RIGHT);
            hBox.getChildren().add(flow);
            hBox.getChildren().add(img);
        }
        hBox.getStyleClass().add("hbox");
        chatBox.getChildren().add(hBox);
    }

    /**
     * A method that will return a circle
     * @return circle
     */
    private Circle getCircle() {
        Circle img = new Circle(28, 28, 14);
        try {
            Image image = new Image(new FileInputStream("Semester Project/src/client/view/images/user.png"));
            img.setFill(new ImagePattern(image));
        } catch (Exception e) {
            System.out.println("Failed loading image");
        }
        img.getStyleClass().add("imageView");
        return img;
    }

    /**
     * A method that will return the client
     * @return client
     */
    public StringProperty getClientProperty() {
        return this.client;
    }
}
