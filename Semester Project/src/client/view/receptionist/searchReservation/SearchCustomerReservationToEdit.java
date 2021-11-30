package client.view.receptionist.searchReservation;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;

public class SearchCustomerReservationToEdit implements ViewController {
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=vh;

    }
}
