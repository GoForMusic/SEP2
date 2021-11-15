package client.view.customer;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class customerHomePageController implements ViewController {

    @FXML
    private BorderPane customerBorderPane;
    private ViewHandler viewHandler;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
    }


    @FXML
    private void clickedCustomerHome(MouseEvent mouseEvent) {

    }

    @FXML
    private void clickedCustomerViewRoom(MouseEvent mouseEvent) {
        try {
            customerBorderPane.setCenter(viewHandler.getViewRoomPane());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }

    @FXML
    private void clickedCustomerMyAccount(MouseEvent mouseEvent) {

    }


}
