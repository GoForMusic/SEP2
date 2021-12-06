package client.view.cleaner;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.layout.HBox;


public class CleanerHomePageController implements ViewController {

    @FXML private ListView<HBox> roomToBeClean;
    private CleanerHomePageViewModel cleanerHomePageVIewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        cleanerHomePageVIewModel = vmf.getCleanerHomePageViewModel();
        loadRooms();
    }

    private void loadRooms()
    {
        cleanerHomePageVIewModel.loadRooms();
        roomToBeClean.setItems(cleanerHomePageVIewModel.getRoomList());
    }
}
