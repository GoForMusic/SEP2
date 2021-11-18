package client.model.viewRooms;

import client.networking.viewRooms.ViewRoomClient;
import shared.utils.RoomType;

import java.time.LocalDate;

public class ViewRoomsModelImpl implements ViewRoomsModel{
    private ViewRoomClient client;

    public ViewRoomsModelImpl(ViewRoomClient viewRoomClient){
        this.client=viewRoomClient;
    }

    @Override
    public void searchRooms(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        client.searchRooms(dateFrom, dateTo, roomType);
    }
}
