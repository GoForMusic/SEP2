package client.view.customer.profile;

import client.core.ViewHandler;
import client.core.ViewModelFactory;
import client.view.ViewController;
import javafx.beans.property.StringProperty;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import shared.utils.User.Customer;

public class AccountInformationController implements ViewController
{

  @FXML private TextField firstName;
  @FXML private TextField lastName;
  @FXML private TextField username;
  @FXML private TextField password;
  private Customer customer;
  private ViewHandler viewHandler;
  private  AccountInformationModel accountInformationModel;

  @Override public void init(ViewHandler vh, ViewModelFactory vmf)
  {
    viewHandler=vh;
  accountInformationModel = vmf.getCustomerAccountInfoModel();
  customer= accountInformationModel.getCustomer();
    username.setEditable(false);
    editable(false);
    binding();
  }



  private void editable(boolean b)
  {
    firstName.setEditable(b);
    lastName.setEditable(b);
    password.setEditable(b);


  }

  private void binding()
  {
    firstName.setText(customer.getFirstname());
    lastName.setText(customer.getLastName());
    username.setText(customer.getUserName());
    password.setText(customer.getPassword());

  }


  public void editPresserd(ActionEvent actionEvent)
  {
    editable(true);


  }

  public void savePressed(ActionEvent actionEvent)
  {
    Customer customer1 = new Customer(firstName.getText(),lastName.getText(),
        username.getText(),password.getText());

    accountInformationModel.updateUser(customer1, customer.getUserName());
  }
}
