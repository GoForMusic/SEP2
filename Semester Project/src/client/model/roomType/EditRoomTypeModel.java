package client.model.roomType;

import shared.utils.roomType.RoomType;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public interface EditRoomTypeModel {
    void updateRoomInfo(RoomType roomType);
    RoomType getRoomType(String roomType);
    ArrayList<RoomType> getRoomTypes();

    void addListener(String eventName, PropertyChangeListener listener);

    void removeListener(String eventName, PropertyChangeListener listener);
}
