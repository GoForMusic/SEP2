package server.database.Reservation;

import shared.utils.Request;

import java.time.LocalDate;

public interface ReservationDAO {

    Request addReservation(String username, LocalDate startDate, LocalDate endDate, String roomName)  ;
    Request getReservationByUsername(String username);

    Request updateReservation(String username, LocalDate previousStart, LocalDate previousEnd, String roomName, LocalDate newStart, LocalDate newEnd, String newRoom);

    Request removeReservation(int id);
}
