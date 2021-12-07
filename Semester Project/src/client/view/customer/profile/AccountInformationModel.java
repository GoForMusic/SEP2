package client.view.customer.profile;

import client.core.ModelFactory;
import client.model.customer.CustomerModel;
import javafx.beans.property.StringProperty;
import shared.utils.User.Customer;

public class AccountInformationModel
{
  private String userNameToSearch;
  private Customer customer;
  private CustomerModel customerModel;


  public AccountInformationModel(ModelFactory modelFactory){
   this.customerModel= modelFactory.getCustomerModel();

  }
  public void setCustomer()
  {

    this.customer = customerModel.getCustomer(userNameToSearch);

  }

  public Customer getCustomer()
  {
    return customer;
  }

  public void updateUser(Customer customer,String username)
  {
    customerModel.updateCustomer(customer,username);
  }

  public void setUserNameFromLogin(String userNameFromLogin)
  {
    userNameToSearch=userNameFromLogin;
  }
}
