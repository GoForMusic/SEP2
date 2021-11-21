package server.model.viewRooms;


import server.database.roomType.ViewRoomTypeDAO;
import server.database.roomType.ViewRoomTypeDAOImpl;
import shared.utils.room.RoomType;

import java.time.LocalDate;

public class ViewRoomImpl implements ViewRoomHandler {

    private ViewRoomTypeDAO viewRoomTypeDAO;


    public ViewRoomImpl() {
        viewRoomTypeDAO = new ViewRoomTypeDAOImpl();
    }

    @Override
    public void searchRoom(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        // TODO ask database to search the room given the parameter....
    }

    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        return viewRoomTypeDAO.getRoomDescriptionByCategory(roomType.toString());
    }

    @Override
    public String getPriceByCategory(RoomType roomType) {

        return viewRoomTypeDAO.getRoomPriceByCategory(roomType.toString()) + "";
    }
}
