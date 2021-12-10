package server.model.roomType;

import shared.utils.roomType.RoomType;

import java.util.ArrayList;

public interface RoomTypeListHandler {
    void updateRoomType(RoomType roomType);
    RoomType getRoomType(String type);
    ArrayList<RoomType> getRoomTypes();
}
