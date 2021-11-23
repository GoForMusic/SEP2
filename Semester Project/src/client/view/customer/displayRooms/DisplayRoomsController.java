package client.view.customer.displayRooms;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import shared.utils.room.Room;

public class DisplayRoomsController implements ViewController {

    @FXML
    private ListView<Room> roomList;
    private ViewHandler viewHandler;
    private ViewModelFactory viewModelFactory;
    private DisplayRoomsViewModel viewModel;
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=vh;
        this.viewModelFactory=vmf;
        this.viewModel = vmf.getDisplayRoomsViewModel();
        roomList.setItems(viewModel.getRoomList());
    }
    @FXML
    private void bookRoom(){
        //todo booking room here....
    }
}
