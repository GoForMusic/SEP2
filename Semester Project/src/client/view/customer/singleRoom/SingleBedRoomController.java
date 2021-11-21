package client.view.customer.singleRoom;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.text.TextFlow;


/**
 * @author Sachin Baral
 * The controller that handles the single room view
 */
public class SingleBedRoomController implements ViewController {
    @FXML
    private DatePicker customerSingleDateFrom;
    @FXML
    private DatePicker customerSingleDateto;
    @FXML
    private TextArea description;
    private ViewHandler viewHandler;
    @FXML
    private Label price;
//    @FXML

    private SingleRoomViewModel viewModel;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.viewModel = vmf.getSingleRoomViewModel();
        customerSingleDateFrom.valueProperty().bindBidirectional(viewModel.getDateFrom());
        customerSingleDateto.valueProperty().bindBidirectional(viewModel.getDateTo());
        price.textProperty().bind(viewModel.getPrice());
        description.textProperty().bind(viewModel.getDescription());
    }


}

