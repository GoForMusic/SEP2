package client.view.customer.bookRooms;

import client.core.ModelFactory;
import client.model.login.LoginModel;
import client.model.viewRooms.ViewRoomsModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.utils.Observer;
import shared.utils.room.Room;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class BookRoomViewModel {
    private ViewRoomsModel viewRoomsModel;
    private LoginModel loginModel;
    private ObservableList<Room> listRooms;

    public BookRoomViewModel(ModelFactory modelFactory) {
        viewRoomsModel = modelFactory.getViewRoomsModel();
        this.loginModel = modelFactory.getLoginModel();
        listRooms = FXCollections.observableArrayList();
        viewRoomsModel.addListener(Observer.AVAILABLEROOMS.toString(), this::roomFromServer);

    }

    private void roomFromServer(PropertyChangeEvent event) {
        Platform.runLater(() -> {
            listRooms.clear();
            List<Room> rooms = (List<Room>) event.getNewValue();
            listRooms.addAll(rooms);
        });
    }

    public ObservableList<Room> getRoomList() {
        return listRooms;

    }

    public void bookRoom() {

    }

    public void setSelectedRoom(List<Object> selectedRooms) {

    }
}
