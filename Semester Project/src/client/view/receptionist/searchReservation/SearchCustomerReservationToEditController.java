package client.view.receptionist.searchReservation;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import shared.utils.reservation.Reservation;

import java.time.LocalDate;

public class SearchCustomerReservationToEditController implements ViewController {
    private ViewHandler viewHandler;
    @FXML
    private AnchorPane anchorPane;
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
    @FXML private void onEdit(){
         Reservation r =tableView.getSelectionModel().getSelectedItem();
       // System.out.println(r.getTempRoom());
        viewModel.setUsername(username.getText());
         viewModel.setSelectedReservation(r);
         if (r!= null){
             anchorPane.getChildren().clear();
             anchorPane.getChildren().setAll(viewHandler.getEditReservation());
         }
    }
    private void initializeTable() {
        room.setCellValueFactory(new PropertyValueFactory<Reservation, String>("tempRoom"));
        startDate.setCellValueFactory(new PropertyValueFactory<>("dateFrom"));
        endDate.setCellValueFactory(new PropertyValueFactory<>("dateTo"));
        tableView.setItems(viewModel.getTable());
    }

    public void removedReservation(ActionEvent actionEvent)
    {
        viewModel.removeReservation(tableView.getSelectionModel().getSelectedItem().getId());
        searchByUsername();
    }
}
