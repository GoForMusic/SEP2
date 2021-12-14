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

/**
 * @author Sachin
 * A class that will implement the edit reservation on GUI
 */
public class EditReservationViewModel {
    private ObjectProperty<LocalDate> dateFrom, dateTo;
    private ObservableList<Room> rooms;
    private ObjectProperty<RoomType> roomType;
    private ObservableList<RoomType> comboBox;
    private RoomsModel roomsModel;
    private StringProperty error;
    private StringProperty newRoom;

    /**
     * A constructor
     * @param modelFactory
     */
    public EditReservationViewModel(ModelFactory modelFactory) {
        this.roomsModel = modelFactory.getRoomsModel();
        initializeEverything();

    }

    /**
     * A method used for search
     */
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

    /**
     * A method that will return room list
     * @return room list
     */
    public ObservableList<Room> getRoomsList() {
        return rooms;
    }

    /**
     * A method that will return data from
     * @return date from
     */
    public ObjectProperty<LocalDate> getDateFrom() {
        return dateFrom;
    }

    /**
     * A method that will return date to
     * @return date to
     */
    public ObjectProperty<LocalDate> getDateTo() {
        return dateTo;
    }

    /**
     * A method that will return room type
     * @return room type
     */
    public ObjectProperty<RoomType> getRoomType() {
        return roomType;
    }

    /**
     * A method that will initialize dates
     */
    private void initializeDates() {
        dateFrom.set(roomsModel.getSelectedReservation().getDateFrom());
        dateTo.set(roomsModel.getSelectedReservation().getDateTo());
    }

    /**
     * A method that will return combo box
     * @return combo box
     */
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

    /**
     * A method that will return list of rooms
     * @return list of rooms
     */
    public ObservableList<Room> getRooms() {

        return rooms;
    }

    /**
     * A method that will return error message
     * @return error message
     */
    public StringProperty getError() {
        return error;
    }

    /**
     * A method that will return new room details
     * @return new room
     */
    public StringProperty getNewRoom() {
        return newRoom;
    }

    /**
     * A method that will initialize everything
     */
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

    /**
     * A method that will update reservation
     */
    public void update() {
        Request request = roomsModel.updateReservation(roomsModel.getUsername(), roomsModel.getSelectedReservation().getDateFrom(), roomsModel.getSelectedReservation().getDateTo(),
                roomsModel.getSelectedReservation().getTempRoom(), dateFrom.get(), dateTo.get(), newRoom.get());
        error.set(request.getType());
    }

    /**
     * A method that will set selected room
     * @param selectedItem
     */
    public void setSelectedRoom(Room selectedItem) {
        newRoom.set(selectedItem.getName());
    }
}
