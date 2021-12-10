package client.view.customer.overview;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import shared.utils.reservation.Reservation;

import java.time.LocalDate;

public class overviewController implements ViewController {

    private ViewHandler viewHandler;
    @FXML
    private TableView<Reservation> tableView;
    @FXML
    private TableColumn<Reservation, String> room;
    @FXML
    private TableColumn<Reservation, LocalDate> startDate;
    @FXML
    private TableColumn<Reservation, LocalDate> endDate;
    public AnchorPane customerAnchorPane;
    private overviewViewModel overviewViewModel;





    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
        overviewViewModel = vmf.getOverviewViewModel();
        initializeTable();

    }

    private void initializeTable(){
        room.setCellValueFactory(new PropertyValueFactory<Reservation, String>("tempRoom"));
        startDate.setCellValueFactory(new PropertyValueFactory<>("dateFrom"));
        endDate.setCellValueFactory(new PropertyValueFactory<>("dateTo"));
        tableView.setItems(overviewViewModel.getTable());
    }


    }



