package client.view.customer;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.layout.BorderPane;

public class ViewRoomController implements ViewController
{

  private ViewHandler viewHandler;
  private customerHomePageController customerHomePageController;
  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    viewHandler = vh;

  }

  public void customerDoubleRoomClicked(ActionEvent actionEvent)
  {

  }

  public void customerLuxuryRoomClicked(ActionEvent actionEvent)
  {
  }

  @FXML private void customerSingleRoomClicked(ActionEvent actionEvent)
  {
     customerHomePageController.customerBorderPane.setCenter(
         viewHandler.getCustomerSingleBedPane());
  }
}
