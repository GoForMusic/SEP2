package server.model.roomType;

import server.database.roomTypeList.RoomTypeListDAO;
import server.database.roomTypeList.RoomTypeListDAOImpl;
import shared.utils.roomType.RoomType;

import java.sql.SQLException;
import java.util.ArrayList;

public class RoomTypeListHandlerImpl implements RoomTypeListHandler {

    private RoomTypeListDAO roomTypeListDAO;

    public RoomTypeListHandlerImpl() throws SQLException
    {
        roomTypeListDAO = new RoomTypeListDAOImpl();
    }

    @Override
    public void updateRoomType(RoomType roomType) {
        roomTypeListDAO.updateRoomType(roomType);
    }

    @Override
    public RoomType getRoomType(String type) {
        return roomTypeListDAO.getRoomType(type);
    }

    @Override
    public ArrayList<RoomType> getRoomTypes() {
        return roomTypeListDAO.getRoomTypes();
    }
}
