package client.view.customer;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import client.view.mainView.CustomerHomePageController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;

import javax.security.auth.login.AccountNotFoundException;
import java.io.IOException;
import java.net.URL;

public class ViewRoomController implements ViewController {

    private ViewHandler viewHandler;
    @FXML private AnchorPane anchorPane;
    @FXML private CustomerHomePageController customerHomePageController;

    @Override
    public void init(ViewHandler vh, ViewModelFactory vmf) {
        viewHandler = vh;

    }

    public void customerDoubleRoomClicked(ActionEvent actionEvent) {
    }

    public void customerLuxuryRoomClicked(ActionEvent actionEvent) {
    }

    @FXML
    private void customerSingleRoomClicked(ActionEvent actionEvent) throws IOException {
//      viewHandler.getMainController().setMainSceneToLuxury();
        anchorPane.getChildren().clear();
        anchorPane.getChildren().setAll(viewHandler.getSingleRoom());
//        anchorPane.getChildren().setAll(getCustomerSingleBedPane());
    }

  public void injectMainController(CustomerHomePageController customerHomePageController) {
        this.customerHomePageController=customerHomePageController;
  }
//    private Pane getPane(String fileSource){
//        URL fileUrl = getClass().getResource(fileSource);
//        try {
//            return new FXMLLoader().load(fileUrl);
//        } catch (IOException e) {
//            throw new RuntimeException("Cannot link the view..");
//        }
//    }
//    public Pane getCustomerSingleBedPane(){
//        return getPane("../view/mainView/customerHomePage.fxml");
//    }
}
