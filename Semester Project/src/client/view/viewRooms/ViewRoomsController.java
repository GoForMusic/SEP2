package client.view.viewRooms;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

public class ViewRoomsController implements ViewController {

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

}
