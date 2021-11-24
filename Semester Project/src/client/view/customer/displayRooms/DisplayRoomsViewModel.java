package client.view.customer.displayRooms;

import client.core.ModelFactory;
import client.model.viewRooms.ViewRoomsModel;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.utils.Observer;
import shared.utils.room.Room;

import java.beans.PropertyChangeEvent;
import java.util.List;

public class DisplayRoomsViewModel {
    private ViewRoomsModel viewRoomsModel;
    private ObservableList<Room> listRooms;

    public DisplayRoomsViewModel(ModelFactory modelFactory) {
        viewRoomsModel = modelFactory.getViewRoomsModel();
        listRooms = FXCollections.observableArrayList();
        viewRoomsModel.addListener(Observer.AVAILABLEROOMS.toString(), this::roomFromServer);
    }

    private void roomFromServer(PropertyChangeEvent event) {
        Platform.runLater(()->{
            listRooms.clear();
            List<Room> rooms = (List<Room>) event.getNewValue();
            listRooms.addAll(rooms);
        });

    }

    public ObservableList<Room> getRoomList() {
        return listRooms;
    }
}
