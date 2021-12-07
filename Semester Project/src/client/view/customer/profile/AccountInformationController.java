package client.view.customer.profile;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import shared.utils.User.Customer;

public class AccountInformationController implements ViewController
{

  @FXML private AnchorPane anchorPane;
  @FXML private TextField firstName;
  @FXML private TextField lastName;
  @FXML private TextField username;
  @FXML private TextField password;
   private ViewHandler viewHandler;
  private AccountInfoViewModel viewModel;
  private  String tempUsername;

  private Customer customer;


  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    viewHandler=vh;
   viewModel = vmf.getCustomerAccountInfoModel();
  editable(false);
  binding();

  }

  public void binding(){
    firstName.textProperty().bindBidirectional(viewModel.firstname);
    lastName.textProperty().bindBidirectional(viewModel.lastName);
    username.textProperty().bindBidirectional(viewModel.userName);
    password.textProperty().bind(viewModel.password);
  }

  public void editable(Boolean bolean){
    firstName.setEditable(bolean); ;
    lastName.setEditable(bolean);
    username.setEditable(bolean);
    password.setEditable(bolean);
  }

  public void editPressed(ActionEvent actionEvent)
  {
    editable(true);

  }

  public void savePressed(ActionEvent   actionEvent)
  {
    viewModel.changeCustomer();

  }

}
