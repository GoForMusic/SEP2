package client.view.chat;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
//import com.jfoenix.controls.JFXDrawer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;


public class ChatRoomController implements ViewController {
    private ViewHandler viewHandler;
    private ChatViewModel viewModel;

    @FXML
    private AnchorPane rootPane;
    @FXML
    private Label client;

    @FXML
    private AnchorPane detailPane;

    @FXML
    private AnchorPane chatPane;

    @FXML
    private TextArea txtMsg;

    @FXML
    private VBox chatBox;

    @FXML
    private Button btnSend;

    @FXML
    private ScrollPane scrollPane;

    @FXML
    private TextFlow emojiList;

    @FXML
    private Button btnEmoji;
    @FXML
   // private JFXDrawer drawerPane;

   // @FXML
    private ScrollPane clientListScroll;

    @FXML
    private VBox clientListBox;
    @FXML
    private Button btnClose;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        viewModel = vmf.getChatViewModel();
        manageEmojiList();
        bindEverything();
        viewModel.setClientListBoxPrefWidth(clientListBox.getPrefWidth());
        clientListBox.getChildren().clear();
        clientListBox.getChildren().setAll(viewModel.getContainer());
        chatBox.getChildren().setAll(viewModel.getChatBox());

    }

    @FXML
    private void sendAction(ActionEvent event) {
        viewModel.sendMessage();
    }

    @FXML
    private void emojiAction(ActionEvent event) {
        if (viewModel.isEmojiVisible()) {
            viewModel.makeEmojiInVisible();
        } else {
            viewModel.makeEmojiVisible();
        }
    }

    private void manageEmojiList() {
        for (Node text : emojiList.getChildren()
        ) {
            text.setOnMouseClicked(mouseEvent -> {
                txtMsg.setText(txtMsg.getText() + " " + ((Text) text).getText());
                viewModel.makeEmojiInVisible();
            });
        }
        scrollPane.vvalueProperty().bind(chatBox.heightProperty());
    }

    private void bindEverything() {
        emojiList.visibleProperty().bind(viewModel.getEmojiProperty());
        txtMsg.textProperty().bindBidirectional(viewModel.getMessage());
        client.textProperty().bind(viewModel.getClientProperty());
    }

}
