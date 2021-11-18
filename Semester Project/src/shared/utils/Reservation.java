package shared.utils;

import shared.utils.User.Customer;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.List;

/**
 * @author Sachin Baral
 * The reservation object storing the start and end dates, and the list of rooms that are booked
 */
public class Reservation implements Serializable {
    private Customer customer;
    private LocalDate dateFrom;
    private LocalDate dateTo;
    private List<Room> bookedRooms;

    /**
     * A four argument constructor that takes customer, dateFrom , dateTo and the list of booked rooms
     * @param customer    the customer who books the room
     * @param dateFrom    the starting date of the reservation
     * @param dateTo      the end date of the reservation
     * @param bookedRooms the list of rooms that the customer wants to book
     */
    public Reservation(Customer customer, LocalDate dateFrom, LocalDate dateTo, List<Room> bookedRooms) {
        verifyData(customer, dateFrom, dateTo, bookedRooms);
        this.customer = customer;
        this.dateFrom = dateFrom;
        this.dateTo = dateTo;
        this.bookedRooms = bookedRooms;
    }

    private void verifyData(Customer customer, LocalDate dateFrom, LocalDate dateTo, List<Room> bookedRooms) {
        if (customer == null) {
            throw new IllegalArgumentException("Cannot create a reservation without customer");
        }
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

    public Customer getCustomer() {
        return customer;
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

    /**
     * Equals method for the reservation
     * @param obj the object to compare
     * @return true, if the object is equal , else false.
     */
    public boolean equals(Object obj) {
        if (!(obj instanceof Reservation)) {
            return false;
        }
        Reservation temp = (Reservation) obj;
        if (temp.getCustomer().equals(this.customer)) {
            if (temp.getDateFrom().equals(this.dateFrom) && temp.getDateTo().equals(this.getDateTo())) {
                if (temp.getBookedRooms().equals(this.bookedRooms)) {
                    return true;
                }
            }
        }
        return false;
    }
}
