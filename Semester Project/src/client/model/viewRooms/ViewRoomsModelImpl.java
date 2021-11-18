package client.model.viewRooms;

import client.networking.viewRooms.ViewRoomClient;
import shared.utils.room.RoomType;

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

    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        return client.getDescriptionByCategory(roomType);
    }

    @Override
    public double getPriceByCategory(RoomType roomType) {
        return client.getPriceByCategory(roomType);
    }

}
