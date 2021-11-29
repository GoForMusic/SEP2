package client.view.customer.bookRooms;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.SelectionMode;
import shared.utils.room.Room;

import java.util.Arrays;

public class BookRoomController implements ViewController {

    @FXML
    private ListView<Room> roomList;
    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private BookRoomViewModel viewModel;
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=vh;
        this.viewModelFactory=vmf;
        this.viewModel = vmf.getDisplayRoomsViewModel();
        initializeRoomList();

    }
    @FXML
    private void bookRoom(){
     viewModel.setSelectedRoom(roomList.getSelectionModel().getSelectedItems());
        viewModel.bookRoom();
    }
    private void initializeRoomList(){
        roomList.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);
        roomList.setItems(viewModel.getRoomList());

    }

}
