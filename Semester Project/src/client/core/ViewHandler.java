package client.core;

import client.view.ViewController;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

import java.io.IOException;

/**
 * @author Sachin Baral
 * @author himal
 * A class that deals with loading fxml files and loading stages.
 */

public class ViewHandler {
    private Scene customerMainView;
    private Scene receptionistMainView;
    private Scene loginScene;
    private Stage stage;
    private ViewModelFactory vmf;
    private Scene adminMainView;

    public ViewHandler(ViewModelFactory vmf, Stage stage) {
        this.vmf = vmf;
        this.stage = stage;
        stage.setResizable(false);
    }
  public ViewHandler(ViewModelFactory vmf, Stage stage)
  {
    this.vmf = vmf;
    this.stage = stage;
    stage.setResizable(false);
  }

    public void start() {
        //  stage = new Stage();
  public void start()
  {
    //  stage = new Stage();

        openLogin();
//        test();
        //   openCustomerMainView();
    }

    /**
     * Opens the login scene in a new Stage
     */
    public void openLogin() {
        if (loginScene == null) {
            Parent root = loadFXML("../view/login/Login.fxml");
            loginScene = new Scene(root);
            stage.setTitle("Login");
        }
        stage.setScene(loginScene);
        stage.show();
    }
     openLogin();
      //openAdminMainView();
    //   openCustomerMainView();
  }

  /**
   * Opens the login scene in a new Stage
   */
  public void openLogin()
  {
    if (loginScene == null)
    {
      Parent root = loadFXML("../view/login/Login.fxml");
      loginScene = new Scene(root);
      stage.setTitle("Login");
    }
    stage.setScene(loginScene);
    stage.show();
  }

  /**
   * Opens the main view for customers
   */
  public void openCustomerMainView()
  {
    if (customerMainView == null)
    {
      Parent root = loadFXML("../view/customer/mainView/customerHomePage.fxml");
      customerMainView = new Scene(root);
      stage.setTitle("Customer");
    }
    stage.setScene(customerMainView);
    stage.show();
  }

  // To load Customer Main view
  public void openAdminMainView()
  {
    if (adminMainView == null)
    {
      Parent root = loadFXML("../view/admin/mainView/AdminMainView.fxml");
      adminMainView = new Scene(root);
      stage.setTitle("Admin");
    }
    stage.setScene(adminMainView);
    stage.show();
  }

  //To Load ReceptionistMainView
  public void openReceptionistMainView()
  {
    if (receptionistMainView == null)
    {
      Parent root = loadFXML("../view/receptionist/mainView/MainViewReceptionist.fxml");
      receptionistMainView = new Scene(root);
      stage.setTitle("Receptionist");
    }
    stage.setScene(receptionistMainView);
    stage.show();

  }
  //    private void test(){
  //        Parent root = getSingleRoom();
  //        Scene scene = new Scene(root);
  //        stage.setScene(scene);
  //        stage.show();
  //    }

  public Parent getViewRoom()
  {
    return loadFXML("../view/viewRoomsTypes/viewRoom.fxml");
  }

  public Parent getSingleRoom()
  {
    return loadFXML("../view/customer/singleRoom/SingleRoom.fxml");
  }

  public Parent getDoubleRoom()
  {
    return loadFXML("../view/customer/doubleBedroom/DoubleBedRoom.fxml");
  }

  public Parent getLuxuryRoom()
  {
    return loadFXML("../view/customer/luxuryRoom/LuxuryRoom.fxml");
  }

  public Parent getAdminCreateAccount(){
    return loadFXML("../view/admin/createAccount/CreateAccount.fxml");
  }
  private Parent loadFXML(String path)
  {
    FXMLLoader loader = new FXMLLoader();
    loader.setLocation(getClass().getResource(path));
    Parent root = null;
    try
    {
      root = loader.load();
    }
    catch (IOException e)
    {
      e.printStackTrace();
    }
    ViewController ctrl = loader.getController();
    ctrl.init(this, vmf);
    return root;
  }

    public Parent getRoomList() {
        return loadFXML("../view/bookRooms/BookRoom.fxml");
    }

    public Parent getSearchReservation() {
        return loadFXML("../view/receptionist/searchReservation/SearchCustomerReservation.fxml");
    }


  public Parent getCustomerList() {
    return loadFXML("../view/receptionist/customerList/customerList.fxml");
  }

  public Parent getReceptionistCreateCustomerAccount() {
    return loadFXML("../view/receptionist/CreateCustomerAccount/CreateAccount.fxml");
  }
}
