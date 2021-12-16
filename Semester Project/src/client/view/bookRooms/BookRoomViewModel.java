package client.view.bookRooms;

import client.core.ModelFactory;
import client.model.login.LoginModel;
import client.model.rooms.RoomsModel;
import javafx.application.Platform;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import server.database.Reservation.ReservationDAOImp;
import shared.utils.Observer;
import shared.utils.Request;
import shared.utils.User.Usertype;
import shared.utils.room.Room;

import java.beans.PropertyChangeEvent;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

/**
 * @author Sachin
 * A class that will set-up values for book list
 */
public class BookRoomViewModel {
    private RoomsModel roomsModel;
    private LoginModel loginModel;
    private ObservableList<Room> listRooms;
    private List<Room> selectedRooms;
    private StringProperty error;
    private BooleanProperty showTextField;
    private StringProperty usernameUsedByReceptionist;


    /**
     * A constructor that will initialize al lthe variables
     * @param modelFactory
     */
    public BookRoomViewModel(ModelFactory modelFactory) {
        roomsModel = modelFactory.getRoomsModel();
        this.loginModel = modelFactory.getLoginModel();
        listRooms = FXCollections.observableArrayList();
        selectedRooms= new ArrayList<>();
        roomsModel.addListener(Observer.AVAILABLEROOMS.toString(), this::roomFromServer);
        error = new SimpleStringProperty();
        showTextField= new SimpleBooleanProperty();
        usernameUsedByReceptionist= new SimpleStringProperty();
        doActionOnTextField();

    }

    /**
     * A function that will do a specific action base on the user type
     */
    private void doActionOnTextField() {
        if (loginModel.getUserType().equals(Usertype.CUSTOMER.toString())){
            showTextField.set(false);
        }else if (loginModel.getUserType().equals(Usertype.RECEPTIONIST.toString())){
            showTextField.set(true);
        }
    }


    /**
     * A function that will remove an element
     * @param event
     */
    private void roomFromServer(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            listRooms.clear();
            List<Room> rooms = (List<Room>) event.getNewValue();
            listRooms.addAll(rooms);
        });
    }

    /**
     * A function that will return a list of rooms
     * @return a list of rooms
     */
    public ObservableList<Room> getRoomList() {
        return listRooms;
    }

    /**
     * A function that will book a room
     */
    public void bookRoom() {
        if (loginModel.getUserType().equals(Usertype.CUSTOMER.toString())){
            Request request = roomsModel.bookRoom(loginModel.getUsername(), selectedRooms, roomsModel.getTempStartDate(), roomsModel.getTempEndDate());
            error.set(request.getType());
        }else if (loginModel.getUserType().equals(Usertype.RECEPTIONIST.toString())){
            Request request = roomsModel.bookRoom(usernameUsedByReceptionist.get(), selectedRooms, roomsModel.getTempStartDate(), roomsModel.getTempEndDate());
            error.set(request.getType());
        }
        listRooms.remove(selectedRooms);
        selectedRooms.clear();
    }


    /**
     * A function that will set selected room
     * @param selectedRooms
     */
    public void setSelectedRoom(ObservableList<Room> selectedRooms) {
        for (Room i : selectedRooms
        ) {
            this.selectedRooms.add(i);
        }
    }

    /**
     * A function that will return room status
     * @return room status
     */
    public BooleanProperty showStatus(){
        return showTextField;
    }

    /**
     * A function that will return username used by receptionist
     * @return receptionist username
     */
    public StringProperty getUsernameUsedByReceptionist() {
        return usernameUsedByReceptionist;
    }

    /**
     * A function that will return an error message
     * @return error message
     */
    public StringProperty getError() {
        return error;
    }
}
