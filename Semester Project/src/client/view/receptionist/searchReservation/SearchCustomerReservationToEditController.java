package client.view.receptionist.searchReservation;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import shared.utils.reservation.Reservation;

import java.time.LocalDate;

public class SearchCustomerReservationToEditController implements ViewController {
    private ViewHandler viewHandler;

    @FXML
    private Label error;
    @FXML
    private TextField username;
    @FXML
    private TableView<Reservation> tableView;
    @FXML
    private TableColumn<Reservation, String> room;
    @FXML
    private TableColumn<Reservation, LocalDate> startDate;
    @FXML
    private TableColumn<Reservation, LocalDate> endDate;

    private SearchReservationViewModel viewModel;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        viewModel = vmf.getSearchReservationViewModel();
        username.textProperty().bindBidirectional(viewModel.getUsername());
        error.textProperty().bind(viewModel.getError());
        initializeTable();
    }

    @FXML
    private void searchByUsername() {
        viewModel.searchByUsername();
    }

    private void initializeTable() {
        room.setCellValueFactory(new PropertyValueFactory<Reservation, String>("tempRoom"));
        startDate.setCellValueFactory(new PropertyValueFactory<>("dateTo"));
        endDate.setCellValueFactory(new PropertyValueFactory<>("dateFrom"));
        tableView.setItems(viewModel.getTable());
    }
}
