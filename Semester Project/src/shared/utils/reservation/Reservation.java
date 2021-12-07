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
     * Will only be used for the tableView ....
     * @param tempRoom the room name
     * @param dateFrom the start date of the booking
     * @param dateTo the endDate of the booking.
     *
     */
    public Reservation(String tempRoom, LocalDate dateFrom, LocalDate dateTo){
        this.tempRoom=tempRoom;
        this.dateFrom=dateFrom;
        this.dateTo=dateTo;
    }
    public Reservation(String tempRoom, LocalDate dateFrom, LocalDate dateTo,int id){
        this.tempRoom=tempRoom;
        this.dateFrom=dateFrom;
        this.dateTo=dateTo;
        this.id=id;
    }


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

    public void setTempRoom(String tempRoom) {
        this.tempRoom = tempRoom;
    }

    public String getTempRoom() {
        return tempRoom;
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public List<String> getBookedRooms() {
        return bookedRooms;
    }

    public String getUsername() {
        return username;
    }

    public int getId()
    {
        return id;
    }

    public void setBookedRooms(List<String> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }

    /**
     * Equals method for the reservation
     * @param obj the object to compare
     * @return true, if the object is equal , else false.
     */
//    public boolean equals(Object obj) {
//        if (!(obj instanceof Reservation)) {
//            return false;
//        }
//        Reservation temp = (Reservation) obj;
//        if (temp.getUsername().equals(this.username)) {
//            if (temp.getDateFrom().equals(this.dateFrom) && temp.getDateTo().equals(this.getDateTo())) {
//                if (temp.getBookedRooms().equals(this.bookedRooms)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
}
