package client.view.receptionist.searchReservation;

import client.core.ModelFactory;
import client.model.rooms.RoomsModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.ObservableList;
import shared.utils.Request;
import shared.utils.reservation.Reservation;
import shared.utils.room.Room;

import java.time.LocalDate;

public class SearchReservationViewModel {

    private StringProperty username;
    private Room selectedRoom;
    private LocalDate selectedStartDate;
    private LocalDate selectedEndDate;
    private ObservableList<Reservation> table;
    private RoomsModel roomsModel;

    public SearchReservationViewModel(ModelFactory modelFactory) {
        roomsModel = modelFactory.getRoomsModel();
        username = new SimpleStringProperty();
    }

    public StringProperty getUsername() {
        return username;
    }

    public Room getSelectedRoom() {
        return selectedRoom;

    }

    public ObservableList<Reservation> getTable() {
        return table;
    }

    public LocalDate getSelectedEndDate() {
        return selectedEndDate;
    }

    public LocalDate getSelectedStartDate() {
        return selectedStartDate;
    }

    public void searchByUsername() {
        Request request =
    }
}
