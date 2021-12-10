package client.view.admin.mainView;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.layout.BorderPane;

public class AdminMainViewController implements ViewController
{
  public Button EditRooms;
  @FXML private BorderPane AdminBorderPane;
  @FXML private Button AdminCreateAccount;
  private ViewHandler viewHandler;
  @FXML private Button CleanerList;
  @FXML private Button ReceptionistList;



  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;


  }

  @FXML private void AdminCreateAccountClicked(ActionEvent actionEvent)
  {
    AdminBorderPane.setCenter(viewHandler.getAdminCreateAccount());
  }

  @FXML private void CleanerList(ActionEvent actionEvent)
  {
    AdminBorderPane.setCenter(viewHandler.getCleanerList());
  }

  @FXML private void ReceptionistList(ActionEvent actionEvent)
  {
    AdminBorderPane.setCenter(viewHandler.getReceptionistList());
  }


  public void EditRooms(ActionEvent actionEvent) {
    AdminBorderPane.setCenter(viewHandler.getEditRooms());
  }
}
