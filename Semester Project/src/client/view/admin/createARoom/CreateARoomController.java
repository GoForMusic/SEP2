package client.view.admin.createARoom;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import shared.utils.room.RoomType;

public class CreateARoomController implements ViewController {



    private CreateARoomViewModel createARoomViewModel;

    @FXML private ComboBox<String> roomType;
    @FXML private TextField roomName;
    @FXML private Label errorLabel;





    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {

            createARoomViewModel = vmf.getCreateARoomViewModel();
            bindEverything();
            roomType.setItems(FXCollections.observableArrayList(RoomType.SINGLE.toString(),RoomType.DOUBLE.toString(),RoomType.LUXURY.toString()));
            roomType.getSelectionModel().selectFirst();
    }

    public void onAdd(ActionEvent actionEvent) {
        createARoomViewModel.createRoom();
    }



    public void onNameTheRoom(ActionEvent actionEvent) {

    }
    private void bindEverything()
    {
        roomType.valueProperty().bindBidirectional(createARoomViewModel.getRoomType());
        errorLabel.textProperty().bindBidirectional(createARoomViewModel.getErrorMessage());
        roomName.textProperty().bindBidirectional(createARoomViewModel.getRoomName());
    }
}
