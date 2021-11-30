package server.database.Reservation;

import shared.utils.Request;

import java.time.LocalDate;

public interface ReservationDAO {

    Request addReservation(String username, LocalDate startDate, LocalDate endDate, String roomName)  ;
    Request getReservationByUsername(String username);
}