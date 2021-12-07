package client.view.customer.profile;

import client.core.ModelFactory;
import client.model.customer.CustomerModel;
import javafx.beans.property.StringProperty;
import javafx.scene.control.TextField;
import shared.utils.User.Customer;

public class AccountInfoViewModel
{

  public StringProperty firstname;
  public StringProperty lastName;
  public   StringProperty userName;
  public StringProperty password;
  public String tempUsername;
 public CustomerModel customerModel;

private  Customer customer;

  public AccountInfoViewModel(ModelFactory modelFactory)
  {
 customerModel=modelFactory.getCustomerModel();

  }

  public void changeCustomer()
  {
    customer = new Customer(firstname.getName(), lastName.getName(), userName.getName(),password.getName());
customerModel.updateCustomer(customer,tempUsername);

  }
}
