package client.view.receptionist.mainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;
import shared.utils.User.Receptionist;

import java.awt.event.ActionEvent;


public class MainViewReceptionistController implements ViewController {

    @FXML
    private BorderPane receptionistBorderPane;
    private ViewHandler viewHandler;




    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
    }


    @FXML
    public void clickedReceptionistHome(MouseEvent mouseEvent) {
        try {
            receptionistBorderPane.setCenter(viewHandler.getViewRoom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clickedCustomerList(MouseEvent mouseEvent) {
        try {
            receptionistBorderPane.setCenter(viewHandler.getCustomerList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clickedCreateCustomerAccount(MouseEvent mouseEvent)
    {
        try {
            receptionistBorderPane.setCenter(viewHandler.getReceptionistCreateCustomerAccount());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }



}
