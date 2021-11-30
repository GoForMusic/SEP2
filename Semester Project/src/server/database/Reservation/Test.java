package server.database.Reservation;

import shared.utils.Request;

import java.time.LocalDate;

public class Test {
    public static void main(String[] args) {
        ReservationDAO reservationDAO = ReservationDAOImp.getInstance();
        Request request = reservationDAO.addReservation("sachin123", LocalDate.now(), LocalDate.now().plusDays(1), "S1");
        System.out.println(request.getType());
    }
}
