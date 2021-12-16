package client.view.bookRooms;
import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import javafx.scene.control.TextField;
import shared.utils.room.Room;

public class BookRoomController implements ViewController {

    @FXML
    private ListView<Room> roomList;
    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private BookRoomViewModel viewModel;
    @FXML
    private Label error;
    @FXML
    private TextField username;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=vh;
        this.viewModelFactory=vmf;
        this.viewModel = vmf.getDisplayRoomsViewModel();
        initializeRoomList();
        error.textProperty().bind(viewModel.getError());
        username.visibleProperty().bind(viewModel.showStatus());
        username.textProperty().bindBidirectional(viewModel.getUsernameUsedByReceptionist());
        roomList.setItems(viewModel.getRoomList());

    }
    @FXML
    private void bookRoom(){
        viewModel.setSelectedRoom(roomList.getSelectionModel().getSelectedItems());
        viewModel.bookRoom();
       initializeRoomList();
    }
    private void initializeRoomList(){
        roomList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);


    }

}
