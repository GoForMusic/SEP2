package client.view.receptionist.editReservation;

import client.core.ModelFactory;
import client.model.rooms.RoomsModel;
import javafx.beans.property.ObjectProperty;
import javafx.beans.property.SimpleObjectProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.utils.Request;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EditReservationViewModel {
    private ObjectProperty<LocalDate> dateFrom, dateTo;
    private ObservableList<Room> rooms;
    private ObjectProperty<RoomType> roomType;
    private ObservableList<RoomType> comboBox;
    private RoomsModel roomsModel;
    private StringProperty error;
    private StringProperty newRoom;

    public EditReservationViewModel(ModelFactory modelFactory) {
        this.roomsModel = modelFactory.getRoomsModel();
        initializeEverything();

    }

    public void search() {
        if (roomType.get()==null){
            error.set("Please select a room type ..");
            return;
        }
        Request request = roomsModel.searchRooms(dateFrom.get(), dateTo.get(), roomType.get());
        if (request.getObject() == null) {
            error.set(request.getType());
            return;
        }
        if (request.getObject() instanceof List) {
            rooms.setAll((List<Room>) request.getObject());
        }
        else
        {
            error.set("List was expected but got something else");
        }
    }

    public ObservableList<Room> getRoomsList() {
        return rooms;
    }

    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }

    public ObjectProperty<LocalDate> getDateTo() {
        return dateTo;
    }

    public ObjectProperty<RoomType> getRoomType() {
        return roomType;
    }

    private void initializeDates() {
        dateFrom.set(roomsModel.getSelectedReservation().getDateFrom());
        dateTo.set(roomsModel.getSelectedReservation().getDateTo());
    }

    public ObservableList<RoomType> getComboBox() {
        if (comboBox == null) {
            ArrayList<RoomType> combo = new ArrayList<>();
            combo.add(RoomType.SINGLE);
            combo.add(RoomType.DOUBLE);
            combo.add(RoomType.LUXURY);
            comboBox = FXCollections.observableArrayList(combo);
        }
        return comboBox;
    }

    public ObservableList<Room> getRooms() {

        return rooms;
    }

    public StringProperty getError() {
        return error;
    }

    public StringProperty getNewRoom() {
        return newRoom;
    }

    private void initializeEverything() {
        roomType = new SimpleObjectProperty<>();
        dateTo = new SimpleObjectProperty<>();
        dateFrom = new SimpleObjectProperty<>();
        error = new SimpleStringProperty();
        newRoom = new SimpleStringProperty();
        newRoom.set(roomsModel.getSelectedReservation().getTempRoom());
        rooms = FXCollections.observableArrayList();
        initializeDates();
    }

    public void update() {
        Request request = roomsModel.updateReservation(roomsModel.getUsername(), roomsModel.getSelectedReservation().getDateFrom(), roomsModel.getSelectedReservation().getDateTo(),
                roomsModel.getSelectedReservation().getTempRoom(), dateFrom.get(), dateTo.get(), newRoom.get());
        error.set(request.getType());
    }

    public void setSelectedRoom(Room selectedItem) {
        newRoom.set(selectedItem.getName());
    }
}
