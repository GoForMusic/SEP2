package client.view.customer.doubleBedroom;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

public class CustomerDoubleBedRoomController implements ViewController {

    @FXML
    private DatePicker customerDoubleDateFrom;
    @FXML
    private DatePicker customerDoubleDateTo;
    private ViewHandler viewHandler;
    private DoubleBedRoomViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.viewModel = vmf.getDoubleBedRoomViewModel();
        customerDoubleDateFrom.valueProperty().bindBidirectional(viewModel.getDateFrom());
        customerDoubleDateTo.valueProperty().bindBidirectional(viewModel.getDateTo());
    }

}
