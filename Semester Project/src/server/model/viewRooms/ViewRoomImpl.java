package server.model.viewRooms;


import server.database.room.RoomDAO;
import server.database.room.RoomDAOImpl;
import server.database.roomType.ViewRoomTypeDAO;
import server.database.roomType.ViewRoomTypeDAOImpl;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.time.LocalDate;
import java.util.List;

/**
 * A implementation that will link rooms with db
 * @author Adrian
 * @version 1
 */
public class ViewRoomImpl implements ViewRoomHandler {

    private ViewRoomTypeDAO viewRoomTypeDAO;
    private RoomDAO roomDAO;

    /**
     * A constructor that will initialize the db links class
     */
    public ViewRoomImpl() {
        viewRoomTypeDAO = new ViewRoomTypeDAOImpl();
        roomDAO = new RoomDAOImpl();
    }

    /**
     * A method that will search for the avaible rooms base on the parameters
     * @param dateFrom the date to search from
     * @param dateTo the date to search upto
     * @param roomType the category of the room to search
     */
    @Override
    public void searchRoom(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {

        List<Room> rooms = roomDAO.getAllAvailableRoomsByType(roomType.toString(),dateFrom,dateTo);
        System.out.println(rooms.get(0));
    }

    /**
     * A method that will get the descriptions base on the roomtype
     * @param roomType
     * @return the specific description
     */
    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        return viewRoomTypeDAO.getRoomDescriptionByCategory(roomType.toString());
    }

    /**
     * A method that will get the price base on the roomtype
     * @param roomType
     * @return
     */
    @Override
    public String getPriceByCategory(RoomType roomType) {

        return viewRoomTypeDAO.getRoomPriceByCategory(roomType.toString()) + "";
    }
}
