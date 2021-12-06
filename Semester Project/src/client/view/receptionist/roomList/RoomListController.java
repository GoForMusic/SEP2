package client.view.receptionist.roomList;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.cleaner.CleanerHomePageViewModel;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;

public class RoomListController implements ViewController {

    @FXML private ListView<HBox> roomList;
    private CleanerHomePageViewModel cleanerHomePageViewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        cleanerHomePageViewModel = vmf.getCleanerHomePageViewModel();
        loadRooms();
    }

    private void loadRooms()
    {
        cleanerHomePageViewModel.loadRooms(true);
        roomList.setItems(cleanerHomePageViewModel.getRoomList());
    }


}
