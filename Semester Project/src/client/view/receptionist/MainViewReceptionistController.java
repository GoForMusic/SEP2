package client.view.receptionist;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;
import java.awt.event.MouseEvent;

public class MainViewReceptionistController implements ViewController {

    public BorderPane receptionistBorderPane;
    private ViewHandler viewHandler;



    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
    }


    @FXML
    private void clickedCreateCustomer(MouseEvent mouseEvent)
    {

    }

    @FXML
    private void clickedBookCustomer(MouseEvent mouseEvent){
        try{
            receptionistBorderPane.setCenter(viewHandler.getViewRoom());
        }
        catch (Exception e){
            e.printStackTrace();
        }
    }
}
