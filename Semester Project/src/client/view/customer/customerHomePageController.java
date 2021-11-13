package client.view.customer;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.BorderPane;

import java.io.IOException;

public class customerHomePageController
{
  @FXML private BorderPane customerBorderPane;

  @FXML private void clickedCustomerHome(MouseEvent mouseEvent)
  {

  }

  @FXML private void clickedCustomerViewRoom(MouseEvent mouseEvent)
  {
    loadViews("viewRoom");
  }

  @FXML private void clickedCustomerMyAccount(MouseEvent mouseEvent)
  {
    loadViews("viewRoom");
  }
  private void loadViews(String filename){
    Parent root = null;
    try
    {
     root= FXMLLoader.load(getClass().getResource("../customer"+filename+".fxml"));
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    customerBorderPane.setCenter(root);
  }
}
