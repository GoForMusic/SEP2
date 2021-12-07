package client.view.receptionist.mainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;


public class MainViewReceptionistController implements ViewController {

    private ViewHandler viewHandler;
    @FXML
    private BorderPane borderPane;


    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        this.viewHandler = vh;
    }


    @FXML
    private void clickedCreateCustomer(ActionEvent mouseEvent) {

    }

    @FXML
    private void reservation(ActionEvent actionEvent) {
       borderPane.setCenter(viewHandler.getReceptionistReservation());
    }

    @FXML
    private void home(ActionEvent event) {

    }

    @FXML
    private  void clickedBook(MouseEvent mouseEvent) {
        borderPane.setCenter(viewHandler.getViewRoom());
    }

    @FXML
    private void roomList(MouseEvent mouseEvent) {
        borderPane.setCenter(viewHandler.getRoomListReceptionist());
    }

    @FXML
    private void chat(ActionEvent event) {
        borderPane.setCenter(viewHandler.getChatView());
    }
}
