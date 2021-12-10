package client.networking.roomType;

import shared.utils.roomType.RoomType;

import java.util.ArrayList;

public interface RoomTypeInfoClient {
    void updateRoomInfo(RoomType roomType);
    RoomType getRoomType(String roomType);
    ArrayList<RoomType> getRoomTypes();

}
