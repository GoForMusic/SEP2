package shared.utils.reservation;

import shared.utils.room.Room;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Sachin Baral
 * The reservation object storing the start and end dates, and the list of rooms that are booked
 */
public class Reservation implements Serializable {
    private String username;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private List<String> bookedRooms;
    private String tempRoom;
    private int id;

    /**
     * A four argument constructor that takes customer, dateFrom , dateTo and the list of booked rooms
     *
     * @param username    the customer username who books the room
     * @param dateFrom    the starting date of the reservation
     * @param dateTo      the end date of the reservation
     * @param bookedRooms the list of rooms that the customer wants to book
     */
    public Reservation(String username, LocalDate dateFrom, LocalDate dateTo, List<String> bookedRooms) throws Exception {
        verifyData(username, dateFrom, dateTo, bookedRooms);
        this.username = username;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.bookedRooms = bookedRooms;

    }

    /**
     * A 3 argument constructor
     * @param tempRoom
     * @param dateFrom
     * @param dateTo
     */
    public Reservation(String tempRoom, LocalDate dateFrom, LocalDate dateTo){
        this.tempRoom=tempRoom;
        this.dateFrom=dateFrom;
        this.dateTo=dateTo;
    }

    /**
     * A 4 argument constructor
     * @param tempRoom
     * @param dateFrom
     * @param dateTo
     * @param id
     */
    public Reservation(String tempRoom, LocalDate dateFrom, LocalDate dateTo,int id){
        this.tempRoom=tempRoom;
        this.dateFrom=dateFrom;
        this.dateTo=dateTo;
        this.id=id;
    }

    /**
     * A function that will verify data
     * @param username
     * @param dateFrom
     * @param dateTo
     * @param bookedRooms
     * @throws Exception
     */
    private void verifyData(String username, LocalDate dateFrom, LocalDate dateTo, List<String> bookedRooms) throws Exception {
        if (username == null) {
            throw new Exception("Cannot create a reservation without customer");
        }
        if (dateFrom==null || dateTo==null){
            throw new Exception("Start date or end date missing");
        } else if (dateTo.isBefore(dateFrom)) {
            throw new Exception("The end date cannot be before start date");
        } else if (bookedRooms == null || bookedRooms.isEmpty()) {
            throw new Exception("Cannot create a reservation without rooms");
        }
    }

    /**
     * A function that will set room
     * @param tempRoom
     */
    public void setTempRoom(String tempRoom) {
        this.tempRoom = tempRoom;
    }

    /**
     * A function that will get room
     * @return room
     */
    public String getTempRoom() {
        return tempRoom;
    }

    /**
     * A function that will get date from
     * @return date from
     */
    public LocalDate getDateFrom() {
        return dateFrom;
    }

    /**
     * A function that will get data to
     * @return
     */
    public LocalDate getDateTo() {
        return dateTo;
    }

    /**
     * A function that will get a list of booked rooms
     * @return list of booked rooms
     */
    public List<String> getBookedRooms() {
        return bookedRooms;
    }

    /**
     * A function that will return username
     * @return username
     */
    public String getUsername() {
        return username;
    }

    /**
     * A function that will return id
     * @return id
     */
    public int getId()
    {
        return id;
    }

    /**
     * A function that will set booked room
     * @param bookedRooms
     */
    public void setBookedRooms(List<String> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    /**
     * A function that will set date from
     * @param dateFrom
     */
    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    /**
     * A function that will set date to
     * @param dateTo
     */
    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }


}
