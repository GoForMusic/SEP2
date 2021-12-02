package client.view.customer.luxuryRoom;


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

public class CustomerLuxuryRoomController implements ViewController {

    @FXML
    private AnchorPane anchorPane;
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
        customerLuxuryDateTo.valueProperty().bindBidirectional(viewModel.getDateTo());
        price.textProperty().bind(viewModel.getPrice());
        description.textProperty().bind(viewModel.getDescription());
        disablePast(customerLuxuryDateFrom);
        disablePast(customerLuxuryDateTo);
    }
    @FXML
    private void searchRooms(){
        anchorPane.getChildren().clear();
        anchorPane.getChildren().setAll(viewHandler.getRoomList());
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




