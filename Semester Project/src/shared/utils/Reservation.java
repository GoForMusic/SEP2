package shared.utils;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

public class Reservation implements Serializable {
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private List<Room> bookedRooms;

    public Reservation(LocalDate dateFrom, LocalDate dateTo, List<Room> bookedRooms) {
        verifyDates(dateFrom, dateTo, bookedRooms);
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.bookedRooms = bookedRooms;
    }

    private void verifyDates(LocalDate dateFrom, LocalDate dateTo, List<Room> bookedRooms) {
        if (dateFrom.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The starting date cannot be on past");
        } else if (dateTo.isBefore(LocalDate.now())) {
            throw new IllegalArgumentException("The end date cannot be on past");
        } else if (dateTo.isBefore(dateFrom)) {
            throw new IllegalArgumentException("The end date cannot be before start date");
        } else if (bookedRooms.isEmpty()) {
            throw new IllegalArgumentException("Cannot create a reservation without rooms");
        }
    }

    public LocalDate getDateFrom() {
        return dateFrom;
    }

    public LocalDate getDateTo() {
        return dateTo;
    }

    public List<Room> getBookedRooms() {
        return bookedRooms;
    }

    public void setBookedRooms(List<Room> bookedRooms) {
        this.bookedRooms = bookedRooms;
    }

    public void setDateFrom(LocalDate dateFrom) {
        this.dateFrom = dateFrom;
    }

    public void setDateTo(LocalDate dateTo) {
        this.dateTo = dateTo;
    }
}
