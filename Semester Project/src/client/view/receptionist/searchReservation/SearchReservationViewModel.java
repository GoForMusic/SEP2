package client.view.receptionist.searchReservation;

import client.core.ModelFactory;
import client.model.rooms.RoomsModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.utils.Request;
import shared.utils.reservation.Reservation;

import java.util.ArrayList;
import java.util.List;

public class SearchReservationViewModel {

    private StringProperty username, error;
    private ObservableList<Reservation> table;
    private RoomsModel roomsModel;

    public SearchReservationViewModel(ModelFactory modelFactory) {
        roomsModel = modelFactory.getRoomsModel();
        username = new SimpleStringProperty();
        error = new SimpleStringProperty();
        table = FXCollections.observableArrayList();
    }

    public StringProperty getUsername() {
        return username;
    }

    public StringProperty getError() {
        return error;
    }

    public ObservableList<Reservation> getTable() {
        return table;
    }

    public void setSelectedReservation(Reservation selectedReservation) {
        if (selectedReservation==null){
            error.set("Select a reservation to edit..");
            return;
        }
        roomsModel.setSelectedReservation(selectedReservation);
    }

    public void searchByUsername() {
        Request request = roomsModel.searchByUsername(username.get());
        List<Reservation> reservations = new ArrayList<>();
        if (request.getObject() == null) {
            error.set(request.getType());

        } else if (request.getObject() instanceof Reservation) {
            Reservation reservationFromServer = (Reservation) request.getObject();
            List<String> roomList = reservationFromServer.getBookedRooms();
            for (String i : roomList) {
                reservations.add(new Reservation(i, reservationFromServer.getDateFrom(), reservationFromServer.getDateTo()));
            }

            error.set(request.getType());
        }
        table.setAll(reservations);
    }

    public void setUsername(String text) {
        roomsModel.setTempUsername(text);
    }

    public void removeReservation(Reservation reservation)
    {

        System.out.println(username.getValue() + "   " + reservation.getDateFrom() + "     "+ reservation.getDateTo());
        Request request = roomsModel.removeReservation(username.getValue(), reservation.getDateFrom(),reservation.getDateTo());
        error.set(request.getType());
        searchByUsername();

    }
}

