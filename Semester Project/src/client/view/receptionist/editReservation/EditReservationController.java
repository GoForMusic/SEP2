package client.view.receptionist.editReservation;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import shared.utils.room.Room;

import javax.swing.text.LabelView;
import java.time.LocalDate;

public class EditReservationController implements ViewController {
    private ViewHandler viewHandler;
    @FXML
    private DatePicker dateFrom,dateTo;
    @FXML
    private ListView<Room> roomList;
    private EditReservationViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=vh;
        viewModel= vmf.getEditReservationViewModel();
        roomList.setItems(viewModel.getRoomsList());
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
