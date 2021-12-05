package client.view.customer.mainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

public class CustomerHomePageController implements ViewController {


    public BorderPane customerBorderPane;
    private ViewHandler viewHandler;
    public BorderPane receptionistBorderPane;


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
            customerBorderPane.setCenter(viewHandler.getViewRoom());
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    @FXML
    private void clickedCustomerMyAccount(MouseEvent mouseEvent) {


    }

    //  public void clickedBookButton(MouseEvent mouseEvent) {

    // }


    @FXML
    private void clickedBookButton(MouseEvent mouseEvent) {
        try {
            receptionistBorderPane.setCenter(viewHandler.getViewRoom());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    @FXML
    private void clickedOverview(MouseEvent mouseEvent) {
        try {
            customerBorderPane.setCenter(viewHandler.getCustomerOverview());
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
