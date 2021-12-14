package client.view.admin.createARoom;

import client.core.ModelFactory;
import client.model.rooms.RoomsModel;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import server.database.room.RoomDAO;
import shared.utils.room.Room;

/**
 * @author Marian
 * A class that will set up the rooms variable to GUI
 */
public class CreateARoomViewModel {
    private ModelFactory modelFactory;
    private RoomsModel roomsModel;

    private StringProperty roomType;
    private StringProperty roomName;
    private StringProperty errorMessage;

    /**
     * A constructor that initialize room modal
     * @param modelFactory
     */
    public CreateARoomViewModel(ModelFactory modelFactory){
        this.modelFactory=modelFactory;
        roomsModel = modelFactory.getRoomsModel();
        roomType = new SimpleStringProperty();
        roomName = new SimpleStringProperty();
        errorMessage = new SimpleStringProperty();
    }

    /**
     * A function that will create a room
     */
    public void createRoom() {
        Room temp = new Room(roomName.get(), roomType.get());
        errorMessage.set(roomsModel.createRoom(temp).getType());
    }

    /**
     * A function that will return a room type
     * @return room type
     */
    public StringProperty getRoomType(){
        return roomType;
    }

    /**
     * A function that will return room name
     * @return room name
     */
    public StringProperty getRoomName() {
        return roomName;
    }

    /**
     * A function that will return error message
     * @return error message
     */
    public StringProperty getErrorMessage() {
        return errorMessage;
    }
}

