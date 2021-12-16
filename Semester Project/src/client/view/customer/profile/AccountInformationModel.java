package client.view.customer.profile;

import client.core.ModelFactory;
import client.model.customer.CustomerModel;
import javafx.beans.property.StringProperty;
import shared.utils.User.Customer;

/**
 * @author Sachin
 * A class that will update username
 */
public class AccountInformationModel
{
  private String userNameToSearch;
  private Customer customer;
  private CustomerModel customerModel;


  /**
   * A constructor that will initialize the model
   * @param modelFactory
   */
  public AccountInformationModel(ModelFactory modelFactory){
   this.customerModel= modelFactory.getCustomerModel();

  }

  /**
   * A method that will set the customer
   */
  public void setCustomer()
  {

    this.customer = customerModel.getCustomer(userNameToSearch);

  }

  /**
   * A method that will return the customer
   * @return
   */
  public Customer getCustomer()
  {
    return customer;
  }

  /**
   * A method that will update the customer
   * @param customer
   * @param username
   */
  public void updateUser(Customer customer,String username)
  {
    customerModel.updateCustomer(customer,username);
  }

  /**
   * A method that will set username from login
   * @param userNameFromLogin
   */
  public void setUserNameFromLogin(String userNameFromLogin)
  {

    userNameToSearch=userNameFromLogin;
  }
}
