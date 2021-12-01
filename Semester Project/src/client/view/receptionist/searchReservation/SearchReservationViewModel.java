package client.view.receptionist.searchReservation;

import client.core.ModelFactory;
import client.model.rooms.RoomsModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.utils.Request;
import shared.utils.reservation.Reservation;
import shared.utils.room.Room;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class SearchReservationViewModel {

    private StringProperty username, error;
    private Room selectedRoom;
    private LocalDate selectedStartDate;
    private LocalDate selectedEndDate;
    private ObservableList<Reservation> table;
    private RoomsModel roomsModel;

    public SearchReservationViewModel(ModelFactory modelFactory) {
        roomsModel = modelFactory.getRoomsModel();
        username = new SimpleStringProperty();
        error = new SimpleStringProperty();
        table= FXCollections.observableArrayList();
    }

    public StringProperty getUsername() {

        return username;
    }

    public StringProperty getError() {
        return error;
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
        Request request = roomsModel.searchByUsername(username.get());
        List<Reservation> reservations = new ArrayList<>();
        if (request.getObject() == null) {
            error.set(request.getType());
            reservations.clear();
        } else if (request.getObject() instanceof Reservation) {
            Reservation reservationFromServer = (Reservation) request.getObject();
            List<String> roomList = reservationFromServer.getBookedRooms();
            for (String i : roomList
            ) {
                reservations.add(new Reservation(i,reservationFromServer.getDateFrom(),reservationFromServer.getDateTo()));
            }

            error.set(request.getType());
        }
        table.setAll(reservations);
    }
}
