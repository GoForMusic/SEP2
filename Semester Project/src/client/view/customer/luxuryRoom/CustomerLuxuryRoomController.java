package client.view.customer.luxuryRoom;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

public class CustomerLuxuryRoomController implements ViewController {
    @FXML
    private DatePicker customerLuxuryDateFrom;
    @FXML
    private DatePicker customerLuxuryDateTo;
    private ViewHandler viewHandler;
    private LuxuryRoomViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.viewModel = vmf.getLuxuryRoomViewModel();
        customerLuxuryDateFrom.valueProperty().bindBidirectional(viewModel.getDateFrom());
        customerLuxuryDateTo.valueProperty().bindBidirectional(viewModel.getDateFrom());
    }


}
