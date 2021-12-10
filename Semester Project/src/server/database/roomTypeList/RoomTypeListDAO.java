package server.database.roomTypeList;

import shared.utils.roomType.RoomType;

import java.util.ArrayList;

public interface RoomTypeListDAO {
    void updateRoomType(RoomType roomType);
    RoomType getRoomType(String type);
    ArrayList<RoomType> getRoomTypes();

}
