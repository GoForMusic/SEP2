package server.model.viewRooms;

import shared.utils.room.RoomType;

import java.time.LocalDate;

public class ViewRoomImpl implements ViewRoomHandler{


    @Override
    public void searchRoom(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        // TODO ask database to search the room given the parameter....
    }

    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        // TODO: 11/18/2021  ask database to return the description of the Room Type ....
        return null;
    }

    @Override
    public double getPriceByCategory(RoomType roomType) {
        // TODO: 11/18/2021 ask database about the price of room..
        return 0;
    }
}
