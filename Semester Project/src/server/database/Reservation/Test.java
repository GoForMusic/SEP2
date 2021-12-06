package server.database.Reservation;

import shared.utils.Request;

import java.time.LocalDate;
import java.util.Date;

public class Test {
    public static void main(String[] args) {

        ReservationDAO reservationDAO = ReservationDAOImp.getInstance();
        Request request = reservationDAO.removeReservation("sachin123",LocalDate.now() , LocalDate.now().plusDays(1));
        System.out.println(request.getType());

    }
}
