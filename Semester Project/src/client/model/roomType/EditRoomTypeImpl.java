package client.model.roomType;

import client.networking.roomType.RoomTypeInfoClient;
import shared.utils.roomType.RoomType;

import java.beans.PropertyChangeListener;
import java.util.ArrayList;

public class EditRoomTypeImpl implements EditRoomTypeModel{

    private RoomTypeInfoClient client;

    public EditRoomTypeImpl(RoomTypeInfoClient roomTypeInfoClient) {this.client = roomTypeInfoClient;}

    @Override
    public void updateRoomInfo(RoomType roomType) {
        client.updateRoomInfo(roomType);

    }

    @Override
    public RoomType getRoomType(String roomType) {
        return client.getRoomType(roomType);
    }

    @Override
    public ArrayList<RoomType> getRoomTypes() {
        return client.getRoomTypes();
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {

    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {

    }
}
