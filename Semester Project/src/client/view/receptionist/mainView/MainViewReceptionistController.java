package client.view.receptionist.mainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;



public class MainViewReceptionistController implements ViewController {


    private ViewHandler viewHandler;
    public BorderPane receptionistBorderPane;



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

    }

    @FXML
    public void clickedBookCustomer(MouseEvent mouseEvent){
        try{
            receptionistBorderPane.setCenter(viewHandler.getViewRoom());
        }
        catch (Exception e){
            e.printStackTrace();
        }

    }


}
