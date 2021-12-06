package client.view.cleaner;

import client.core.ModelFactory;
import client.model.rooms.RoomsModel;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleListProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import shared.utils.room.Room;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class CleanerHomePageViewModel {

    private ObservableList<HBox> roomList;
    private RoomsModel roomsModel;

    public CleanerHomePageViewModel(ModelFactory modelFactory) {
        this.roomsModel = modelFactory.getRoomsModel();

        roomList = new SimpleListProperty<>();
    }

    public void updateRoomStatus(Room room){

    }

    public void loadRooms(){
        List<Room> rooms = roomsModel.getRooms();
        ArrayList<HBox> elements = new ArrayList<>();

        if(!rooms.isEmpty()){
                for(Room item: rooms)
                {
                    if(!item.isCleanOrNot()){
                    HBox hBox = new HBox();
                    //add the item title and author as well the specific details
                    Label label = new Label(item.getName() + " | " + item.getType() + " | "+ item.isCleanOrNot());
                    label.setPrefWidth(450);
                    hBox.getChildren().add(label);
                    //add edit button
                    Button editButton = new Button("Update");
                    editButton.getStyleClass().add("buttonGreen");

                    //edit item button event handler using lambda method
                    editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                        Room localRoomUpdated = new Room(item.getName(), item.getType());
                        localRoomUpdated.setClean(true);
                        roomsModel.updateRoom(localRoomUpdated);
                        loadRooms();
                    });


                    HBox.setMargin(editButton,new Insets(0,5,0,0));
                    hBox.getChildren().addAll(editButton);
                    elements.add(hBox);
                }
            }
            roomList = FXCollections.observableArrayList(elements);
        }
    }

    public ObservableList<HBox> getRoomList()
    {
        return roomList;
    }


}
