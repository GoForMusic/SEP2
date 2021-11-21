package client.view.customer.luxuryRoom;


import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class CustomerLuxuryRoomController implements ViewController {
    @FXML
    private DatePicker customerLuxuryDateFrom;
    @FXML
    private DatePicker customerLuxuryDateTo;
    @FXML
    private Label price;
    @FXML
    private TextArea description;

    private ViewHandler viewHandler;
    private LuxuryRoomViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.viewModel = vmf.getLuxuryRoomViewModel();
        customerLuxuryDateFrom.valueProperty().bindBidirectional(viewModel.getDateFrom());
        customerLuxuryDateTo.valueProperty().bindBidirectional(viewModel.getDateFrom());
        price.textProperty().bind(viewModel.getPrice());
        description.textProperty().bind(viewModel.getDescription());
    }
}




