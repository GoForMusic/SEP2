package client.view.receptionist.searchReservation;

import client.core.ModelFactory;
import client.model.rooms.RoomsModel;
import javafx.application.Platform;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.utils.Request;
import shared.utils.reservation.Reservation;

import java.time.LocalDate;
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
            reservations.clear();
        } else if (request.getObject() instanceof List) {
            List<Reservation> reservationFromServer = (List<Reservation>) request.getObject();
            for (Reservation i : reservationFromServer
            ) {
                if (i.getDateTo().isBefore(LocalDate.now())) continue;
                reservations.add(i);
            }
            error.set(request.getType());
            
        }
        table.setAll(reservations);
        clearLabel();
    }

    public void setUsername(String text) {
        roomsModel.setTempUsername(text);
    }
    private void clearLabel()
    {
        new Thread(()->{
                try {
                    Thread.sleep(5000);
                } catch (InterruptedException e) {

                }
                Platform.runLater(()->{
                    error.set("");
                });

            }).start();

        };


    public void removeReservation(int id)
    {
        Request request = roomsModel.removeReservation(id);
        error.set(request.getType());

    }
}
