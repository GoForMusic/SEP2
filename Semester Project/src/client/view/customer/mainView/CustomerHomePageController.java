package client.view.customer.mainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.customer.viewRooms.ViewRoomController;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class CustomerHomePageController implements ViewController {


    public BorderPane customerBorderPane;
    private ViewHandler viewHandler;
    @FXML
    private ViewRoomController viewRoomController;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
    }

    @FXML
    private void initialize() {
//        viewRoomController.injectMainController(this);
    }


    @FXML
    private void clickedCustomerHome(MouseEvent mouseEvent) {

    }

    @FXML
    private void clickedCustomerViewRoom(MouseEvent mouseEvent) {
        try {
            customerBorderPane.setCenter(viewHandler.getViewRoom());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setContentText(e.getMessage());
            alert.show();
        }

    }

//    public void setMainSceneToLuxury() {
//        customerBorderPane.setCenter(viewHandler.getCustomerSingleBedPane());
//    }

    @FXML
    private void clickedCustomerMyAccount(MouseEvent mouseEvent) {

    }

    public BorderPane getCustomerBorderPane() {
        return customerBorderPane;
    }
}
