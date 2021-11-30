package client.view.receptionist.editReservation;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;

public class EditReservationController implements ViewController {
    private ViewHandler viewHandler;
    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler=vh;
    }
}
