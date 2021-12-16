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
  @FXML private Button ReceptionistList;
     @FXML private Button CleanerList;
    @FXML private Button EditRoomType;
    @FXML private BorderPane AdminBorderPane;
  @FXML private Button AdminCreateAccount;
  private ViewHandler viewHandler;



  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    this.viewHandler = vh;


  }

  @FXML private void AdminCreateAccountClicked(ActionEvent actionEvent)
  {
    AdminBorderPane.setCenter(viewHandler.getAdminCreateAccount());


  }

    public void AdminCreateARoomClicked(ActionEvent actionEvent) {
      AdminBorderPane.setCenter(viewHandler.getAdminCreateRoom());
    }

  @FXML private void EditRoomTypeClicked(ActionEvent actionEvent)
  {
    AdminBorderPane.setCenter(viewHandler.getEditRoomType());
  }

  public void ReceptionistListClicked(ActionEvent actionEvent) {
    AdminBorderPane.setCenter(viewHandler.getReceptionistList());

  }

  public void CleanerListClicked(ActionEvent actionEvent) {
    AdminBorderPane.setCenter(viewHandler.getCleanerList());
  }


}
