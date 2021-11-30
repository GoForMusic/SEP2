package client.view.receptionist;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

import java.awt.event.MouseEvent;

public class MainViewReceptionistController implements ViewController {

    public BorderPane customerBorderPane;
    private ViewHandler viewHandler;



    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = viewHandler;
    }


    @FXML
    private void clickedCreateCustomer(MouseEvent mouseEvent)
    {

    }
}
