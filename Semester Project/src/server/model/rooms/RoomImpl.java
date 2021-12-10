package server.model.rooms;


import server.database.Reservation.ReservationDAO;
import server.database.Reservation.ReservationDAOImp;
import server.database.room.RoomDAO;
import server.database.room.RoomDAOImpl;
import server.database.roomType.ViewRoomTypeDAO;
import server.database.roomType.ViewRoomTypeDAOImpl;
import shared.utils.Observer;
import shared.utils.Request;
import shared.utils.reservation.Reservation;
import shared.utils.room.Room;
import shared.utils.room.RoomType;

import java.beans.PropertyChangeListener;
import java.beans.PropertyChangeSupport;
import java.sql.SQLException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class RoomImpl implements RoomHandler {

    private ViewRoomTypeDAO viewRoomTypeDAO;
    private RoomDAO roomDAO;
    private PropertyChangeSupport support;
    private ReservationDAO reservationDAO;


    public RoomImpl() {
        viewRoomTypeDAO = new ViewRoomTypeDAOImpl();
        reservationDAO = ReservationDAOImp.getInstance();
        roomDAO = new RoomDAOImpl();
        support = new PropertyChangeSupport(this);
    }

    @Override
    public Request searchRoom(LocalDate dateFrom, LocalDate dateTo, RoomType roomType) {
        try {
            List<Room> allAvailableRoomsByType = roomDAO.getAllAvailableRoomsByType(roomType.toString(), dateFrom, dateTo);
            System.out.println(allAvailableRoomsByType);
            //TODO remove the stupid observer pattern and then do it the synchronous way..
            support.firePropertyChange(Observer.AVAILABLEROOMS.toString(), null, allAvailableRoomsByType);
            return new Request("Available rooms",allAvailableRoomsByType);
        } catch (SQLException e) {
            return new Request(e.getMessage(),null);
        }
    }

    @Override
    public String getDescriptionByCategory(RoomType roomType) {
        return viewRoomTypeDAO.getRoomDescriptionByCategory(roomType.toString());
    }

    @Override
    public ArrayList<Room> getRooms() {
       ArrayList<Room> roomList = new ArrayList<>();
        try {
            roomList= roomDAO.getAllRooms();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return roomList;
    }

    @Override
    public void updateRoom(Room room) {
        try {
            roomDAO.updateRoom(room);
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    @Override
    public String getPriceByCategory(RoomType roomType) {

        return viewRoomTypeDAO.getRoomPriceByCategory(roomType.toString()) + "";
    }

    @Override
    public Request bookRoom(Reservation reservation) {
        System.out.println("Reached the final method");
        String username = reservation.getUsername();
        List<String> selected = reservation.getBookedRooms();
        LocalDate startDate = reservation.getDateFrom();
        LocalDate endDate = reservation.getDateTo();
        Request temp =new Request("Error", null);
        for (String i : selected) {
            try {
              temp= reservationDAO.addReservation(username, startDate, endDate, i);
            } catch (Exception e) {
                return new Request(e.getMessage(), null);
            }
        }

        return temp;
    }

    @Override
    public Request searchByUsername(String username) {
      return reservationDAO.getReservationByUsername(username);
    }

    @Override
    public Request updateReservation(String username, LocalDate previousStart, LocalDate previousEnd, String roomName, LocalDate newStart, LocalDate newEnd, String newRoom) {
        return reservationDAO.updateReservation(username,previousStart,previousEnd,roomName,newStart,newEnd,newRoom);
    }

    @Override public Request removeReservation(int id)
    {
        return reservationDAO.removeReservation(id);
    }

    @Override
    public Request createRoom(Room room) {
        try {
            roomDAO.create(room);
            return new Request("Room created",null);
        } catch (SQLException e) {
            return new Request(e.getMessage(),null);
        }
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
