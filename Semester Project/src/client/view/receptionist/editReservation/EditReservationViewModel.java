package client.view.receptionist.editReservation;

import client.core.ModelFactory;
import javafx.beans.property.ObjectProperty;
import javafx.collections.ObservableList;
import shared.utils.room.Room;

import java.time.LocalDate;

public class EditReservationViewModel {
    private ObjectProperty<LocalDate> dateFrom, dateTo;
    private ObservableList<Room> rooms;

    public EditReservationViewModel(ModelFactory modelFactory) {

    }

    public ObservableList<Room> getRoomsList() {
        return rooms;
    }
}
