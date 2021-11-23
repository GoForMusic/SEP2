package server.model.viewRooms;


import server.database.room.RoomDAO;
import server.database.room.RoomDAOImpl;
import server.database.roomType.ViewRoomTypeDAO;
import server.database.roomType.ViewRoomTypeDAOImpl;
import shared.utils.Observer;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.List;

public class ViewRoomImpl implements ViewRoomHandler {

    private ViewRoomTypeDAO viewRoomTypeDAO;
    private RoomDAO roomDAO;
    private PropertyChangeSupport support;


    public ViewRoomImpl() {
        viewRoomTypeDAO = new ViewRoomTypeDAOImpl();
        // todo singleton
        roomDAO = new RoomDAOImpl();
        support= new PropertyChangeSupport(this);
    }

    @Override
    public void searchRoom(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        try {
            List<Room> allAvailableRoomsByType = roomDAO.getAllAvailableRoomsByType(roomType.toString(), dateFrom, dateTo);
            support.firePropertyChange(Observer.AVAILABLEROOMS.toString(),null,allAvailableRoomsByType);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        return viewRoomTypeDAO.getRoomDescriptionByCategory(roomType.toString());
    }

    @Override
    public String getPriceByCategory(RoomType roomType) {

        return viewRoomTypeDAO.getRoomPriceByCategory(roomType.toString()) + "";
    }

    @Override
    public void addListener(String eventName, PropertyChangeListener listener) {
        support.addPropertyChangeListener(eventName, listener);
    }

    @Override
    public void removeListener(String eventName, PropertyChangeListener listener) {
        support.removePropertyChangeListener(eventName, listener);
    }
}
