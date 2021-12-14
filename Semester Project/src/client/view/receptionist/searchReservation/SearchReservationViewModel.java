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

/**
 * @author Sachin
 * A class that will search reservation on HUI
 */
public class SearchReservationViewModel {

    private StringProperty username, error;
    private ObservableList<Reservation> table;
    private RoomsModel roomsModel;

    /**
     * Constructor
     * @param modelFactory
     */
    public SearchReservationViewModel(ModelFactory modelFactory) {
        roomsModel = modelFactory.getRoomsModel();
        username = new SimpleStringProperty();
        error = new SimpleStringProperty();
        table = FXCollections.observableArrayList();
    }

    /**
     * A method that will return username
     * @return username
     */
    public StringProperty getUsername() {
        return username;
    }

    /**
     * A method that will return error message
     * @return error message
     */
    public StringProperty getError() {
        return error;
    }

    /**
     * A method that will return a table
     * @return a table
     */
    public ObservableList<Reservation> getTable() {
        return table;
    }

    /**
     * A method that will set selected reservation
     * @param selectedReservation
     */
    public void setSelectedReservation(Reservation selectedReservation) {
        if (selectedReservation==null){
            error.set("Select a reservation to edit..");
            return;
        }
        roomsModel.setSelectedReservation(selectedReservation);
    }

    /**
     * A method that will search by username
     */
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

    /**
     * A method that will set username
     * @param text
     */
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


    /**
     * A method that will remove reservation
     * @param id
     */
    public void removeReservation(int id)
    {
        Request request = roomsModel.removeReservation(id);
        error.set(request.getType());

    }
}
