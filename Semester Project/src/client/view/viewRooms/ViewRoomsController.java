package client.view.viewRooms;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ViewRoomsController implements ViewController {
    @FXML private AnchorPane layer2;
    @FXML
    private Button viewRoom;

    @FXML
    private ViewRoomsController viewRoomsController;
    @FXML
    private DatePicker dateFrom;

    @FXML
    private DatePicker dateTO;



    private ViewHandler viewHandler;
    private ViewRoomsViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.viewModel = vmf.getViewRoomsViewModel();
        bindEverything();
    }


    private void bindEverything(){
        // TODO bind the date pickers here...
        // TODO also bind other stuffs here...
    }
    @FXML
    private void onSearchButton(){
        viewModel.search();
    }

    @FXML
    private void viewRoomTypeAction(ActionEvent actionEvent)

    {

    }
}
