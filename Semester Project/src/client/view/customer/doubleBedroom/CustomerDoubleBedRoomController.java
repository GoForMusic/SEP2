package client.view.customer.doubleBedroom;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.time.LocalDate;

public class CustomerDoubleBedRoomController implements ViewController {

    @FXML
    private AnchorPane anchorpane;
    @FXML
    private DatePicker customerDoubleDateFrom;
    @FXML
    private DatePicker customerDoubleDateTo;
    @FXML
    private Label price;
    @FXML
    private TextArea description;
    private ViewHandler viewHandler;
    private DoubleBedRoomViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        this.viewModel = vmf.getDoubleBedRoomViewModel();
        customerDoubleDateFrom.valueProperty().bindBidirectional(viewModel.getDateFrom());
        customerDoubleDateTo.valueProperty().bindBidirectional(viewModel.getDateTo());
        price.textProperty().bind(viewModel.getPricePerNight());
        description.textProperty().bind(viewModel.getDescription());
        disablePast(customerDoubleDateFrom);
        disablePast(customerDoubleDateTo);
    }
    @FXML
    private void searchRooms(){
        anchorpane.getChildren().clear();
        anchorpane.getChildren().setAll(viewHandler.getRoomList());
        viewModel.searchRooms();
    }
    private void disablePast(DatePicker dp){
        dp.setDayCellFactory(picker -> new DateCell() {
            public void updateItem(LocalDate date, boolean empty) {
                super.updateItem(date, empty);
                LocalDate today = LocalDate.now();
                setDisable(empty || date.compareTo(today) < 0 );
            }
        });
    }

}
