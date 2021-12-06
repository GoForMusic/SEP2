package client.view.admin.createAccount;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import shared.utils.User.Usertype;

import java.util.Collection;

public class CreateAccountController implements ViewController
{

  @FXML private TextField createFirstName;
  @FXML private TextField createUsername;
  @FXML private TextField createPassword;
  @FXML private TextField createLastName;
  @FXML private Label errorLabel;
  @FXML private ChoiceBox<String> userType;
  private String newUser;
  private final String[] user = {"Admin","Cleaner","Receptionist"};
  private ViewHandler viewHandler;
  private  AdminCreateAccountViewModel adminCreateAccountViewModel;
  private ViewModelFactory viewModelFactory;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    viewHandler = vh;
    viewModelFactory = vmf;
    adminCreateAccountViewModel = viewModelFactory.getAdminCreateAccountViewModel();
    bindEverything();
    userType.getItems().addAll(user);
    userType.setOnAction(this::getUserType);

  }

  private void bindEverything(){
    createFirstName.textProperty().bindBidirectional(
        adminCreateAccountViewModel.getFirstNameProperty());
    createLastName.textProperty().bindBidirectional(adminCreateAccountViewModel.getLastNameProperty());
    createPassword.textProperty().bindBidirectional(adminCreateAccountViewModel.getPasswordProperty());
    createUsername.textProperty().bindBidirectional(adminCreateAccountViewModel.getUserNameProperty());
    errorLabel.textProperty().bind(
        adminCreateAccountViewModel.errorLabelProperty());
    userType.valueProperty().bindBidirectional(
        adminCreateAccountViewModel.getUserTypeProperty());
  }


  private void getUserType(javafx.event.ActionEvent actionEvent)
  {
    newUser = userType.getValue();
  }

  @FXML private void createAccount(ActionEvent actionEvent)
  {
    adminCreateAccountViewModel.createAccount();
  }
}
