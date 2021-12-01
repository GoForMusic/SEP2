package client.view.receptionist.editReservation;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import shared.utils.User.Usertype;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import javax.swing.text.LabelView;
import java.time.LocalDate;

public class EditReservationController implements ViewController {
    private ViewHandler viewHandler;
    @FXML
    private DatePicker dateFrom,dateTo;
    @FXML
    private ListView<Room> roomList;
    @FXML
    private ComboBox<RoomType> userType;
    @FXML
    private Label error;
    @FXML
    private Label newRoom;

    private EditReservationViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=vh;
        viewModel= vmf.getEditReservationViewModel();
        roomList.setItems(viewModel.getRoomsList());
        dateFrom.valueProperty().bindBidirectional(viewModel.getDateFrom());
        dateTo.valueProperty().bindBidirectional(viewModel.getDateTo());
        disablePast(dateFrom);
        disablePast(dateTo);
        userType.setItems(viewModel.getComboBox());
        userType.valueProperty().bindBidirectional(viewModel.getRoomType());
        error.textProperty().bind(viewModel.getError());
        newRoom.textProperty().bind(viewModel.getNewRoom());
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
    @FXML
    private void onSearch(){
        viewModel.search();
    }
    @FXML
    private void onUpdate(){
        viewModel.setSelectedRoom(roomList.getSelectionModel().getSelectedItem());
        viewModel.update();
    }
}
