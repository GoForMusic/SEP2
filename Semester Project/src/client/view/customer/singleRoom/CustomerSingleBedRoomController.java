package client.view.customer.singleRoom;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.DatePicker;

public class CustomerSingleBedRoomController implements ViewController {
    @FXML
    private DatePicker customerSingleDateFrom;
    @FXML
    private DatePicker customerSingleDateto;
    private ViewHandler viewHandler;

    private SingleRoomViewModel viewModel;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = viewHandler;
        this.viewModel = vmf.getSingleRoomViewModel();
        customerSingleDateFrom.valueProperty().bindBidirectional(viewModel.getDateFrom());
        customerSingleDateto.valueProperty().bindBidirectional(viewModel.getDateTo());
    }


    private ViewModelFactory viewModelFactory;

    public void customerSingleDateFromPressed(ActionEvent actionEvent) {

    }

    public void customerSingleDateToPressed(ActionEvent actionEvent) {

    }

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=viewHandler;
        this.viewModelFactory=vmf;
    }

}
