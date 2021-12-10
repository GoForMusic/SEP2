package client.view.admin.editRoomType;

import client.core.ModelFactory;
import client.model.roomType.EditRoomTypeModel;
import com.sun.javafx.scene.control.IntegerField;
import javafx.beans.property.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.geometry.Insets;
import javafx.scene.control.*;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import shared.utils.roomType.RoomType;

import java.util.Optional;
import java.awt.*;
import java.util.ArrayList;


public class RoomTypeViewModel {

    private ObservableList<HBox> roomTypeList;
    private BooleanProperty editRoomType;
    private StringProperty roomType, description, errorLabel;
    private IntegerProperty price;
    private RoomTypeViewModel editRoomsViewModel;
    private EditRoomTypeModel editRoomModel;

    public RoomTypeViewModel(ModelFactory modelFactory) {
        this.editRoomModel = modelFactory.getEditRoomTypeModel();

        roomTypeList = new SimpleListProperty<>();
        roomType = new SimpleStringProperty();
        description = new SimpleStringProperty();
        price = new SimpleIntegerProperty();
        errorLabel = new SimpleStringProperty();
        editRoomType = new SimpleBooleanProperty();


    }

    public void updateRoomInfo(RoomType roomType) {
        editRoomModel.updateRoomInfo(roomType);
    }

    public BooleanProperty getEditRoomType() {
        return editRoomType;
    }

    public StringProperty getRoomType() {
        return roomType;
    }

    public IntegerProperty getPrice() {
        return price;
    }

    public StringProperty getDescription() {
        return description;
    }

    public StringProperty getErrorLabel() {
        return errorLabel;
    }

    ObservableList<HBox> getRoomTypeList() {
        return roomTypeList;
    }

    public void loadRooms() {
        ArrayList<RoomType> roomTypes = editRoomModel.getRoomTypes();
        ArrayList<HBox> elements = new ArrayList<>();

        if (!roomTypes.isEmpty())
        {
            for (RoomType items : roomTypes)
            {
                HBox hBox = new HBox();
                Label label = new Label(items.getRoomType() + "|" + items.getPrice() + "|" + items.getDescription());
                label.setPrefWidth(450);
                hBox.getChildren().add(label);
                Button editButton = new Button("Edit");
                editButton.getStyleClass().add("buttonGreen");


                editButton.addEventHandler(MouseEvent.MOUSE_CLICKED, (MouseEvent mouseEvent) -> {
                    editRoomType.setValue(true);
                    roomType.setValue(items.getRoomType());
                    price.setValue(items.getPrice());
                    description.setValue(items.getDescription());

                });
                HBox.setMargin(editButton, new Insets(0, 5, 0, 0));
                hBox.getChildren().addAll(editButton);
                elements.add(hBox);


            }
            roomTypeList = FXCollections.observableArrayList(elements);

        }
    }
}

