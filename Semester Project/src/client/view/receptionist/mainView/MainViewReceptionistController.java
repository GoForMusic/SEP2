package client.view.receptionist.mainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;



public class MainViewReceptionistController implements ViewController {

    public BorderPane customerBorderPane;
    private ViewHandler viewHandler;



    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
    }


    @FXML
    public void clickedReceptionistHome(MouseEvent mouseEvent) {
        try {
            customerBorderPane.setCenter(viewHandler.getViewRoom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    public void clickedCustomerList(MouseEvent mouseEvent) {
        try {
            customerBorderPane.setCenter(viewHandler.getCustomerList());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
