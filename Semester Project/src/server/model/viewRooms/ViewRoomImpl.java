package server.model.viewRooms;

import shared.utils.RoomType;

import java.time.LocalDate;

public class ViewRoomImpl implements ViewRoomHandler{


    @Override
    public void searchRoom(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        // TODO ask database to search the room given the parameter....
    }
}
