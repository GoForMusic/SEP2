package client.view.customer.overview;

import client.core.ModelFactory;
import client.model.login.LoginModel;
import client.model.rooms.RoomsModel;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import shared.utils.Request;
import shared.utils.reservation.Reservation;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class overviewViewModel {
    private RoomsModel roomsModel;
    private LoginModel loginModel;
    private ObservableList<Reservation> table;

    public overviewViewModel(ModelFactory modelFactory){
        roomsModel = modelFactory.getRoomsModel();
        table = FXCollections.observableArrayList();
        loginModel = modelFactory.getLoginModel();

    }

    public ObservableList<Reservation> getTable(){
        searchByUsername();
        return table;
    }

    public void searchByUsername() {
        String username = loginModel.getUsername();
        Request request = roomsModel.searchByUsername(username);
        List<Reservation> reservations = new ArrayList<>();
        if (request.getObject() == null) {
            //error.set(request.getType());
            reservations.clear();
        } else if (request.getObject() instanceof Reservation) {
            Reservation reservationFromServer = (Reservation) request.getObject();
            List<String> roomList = reservationFromServer.getBookedRooms();
            for (String i : roomList) {
                reservations.add(new Reservation(i, reservationFromServer.getDateFrom(), reservationFromServer.getDateTo()));
            }

            //error.set(request.getType());
        }
        table.setAll(reservations);
    }


}
