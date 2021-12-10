package client.view.admin.createARoom;

import client.core.ModelFactory;
import client.model.rooms.RoomsModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.database.room.RoomDAO;
import shared.utils.room.Room;

public class CreateARoomViewModel {
    private ModelFactory modelFactory;
    private RoomsModel roomsModel;

    private StringProperty roomType;
    private StringProperty roomName;
    private StringProperty errorMessage;

    public CreateARoomViewModel(ModelFactory modelFactory){
        this.modelFactory=modelFactory;
        roomsModel = modelFactory.getRoomsModel();
        roomType = new SimpleStringProperty();
        roomName = new SimpleStringProperty();
        errorMessage = new SimpleStringProperty();
    }

    public void createRoom() {
        Room temp = new Room(roomName.get(), roomType.get());
        errorMessage.set(roomsModel.createRoom(temp).getType());
    }

    public StringProperty getRoomType(){
        return roomType;
    }

    public StringProperty getRoomName() {
        return roomName;
    }

    public StringProperty getErrorMessage() {
        return errorMessage;
    }
}

