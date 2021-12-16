package client.view.admin.createAccount;

import client.core.ModelFactory;
import client.model.create.CreateModel;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.utils.User.Usertype;

import java.util.Locale;

/**
 * @author Himal
 * A class that set-up variables for GUI
 */
public class AdminCreateAccountViewModel
{



  private StringProperty firstName,lastName,userName,password,userType,errorLabel;
  private ModelFactory modelFactory;
  private CreateModel createModel;


  /**
   * A method that will return first name
   * @return firstname
   */
  public StringProperty getFirstNameProperty()
  {
    return firstName;
  }

  /**
   * A method that will return last name
   * @return last name
   */
  public StringProperty getLastNameProperty()
  {
    return lastName;
  }

  /**
   * A method that will return username
   * @return username
   */
  public StringProperty getUserNameProperty()
  {
    return userName;
  }

  /**
   * A method that will return password
   * @return password
   */
  public StringProperty getPasswordProperty()
  {
    return password;
  }

  /**
   * A method that will return user type
   * @return user type
   */
  public StringProperty getUserTypeProperty()
  {
    return userType;
  }


  /**
   * A method that will return error label
   * @return error message
   */
  public StringProperty errorLabelProperty()
  {
    return errorLabel;
  }

  /**
   * A constructor that will initialize model
   * @param modelFactory
   */
  public AdminCreateAccountViewModel(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    createModel = modelFactory.getCreateModel();
    initializeAllProperties();
  }

  /**
   * A function that will initialize all the variables
   */
  private void initializeAllProperties()
  {
    firstName = new SimpleStringProperty();
    lastName = new SimpleStringProperty();
    userName = new SimpleStringProperty();
    password = new SimpleStringProperty();
    userType = new SimpleStringProperty();
    errorLabel = new SimpleStringProperty();
  }

  /**
   * A method that will create an account
   * @return a message
   */
  public String createAccount()
  {
    if (userName.get() == null || userName.get().isEmpty())
    {
      errorLabel.set("Username cannot be empty..");

    }
    else if (firstName.get() == null || firstName.get().isEmpty()
        || lastName.get().isEmpty()|| lastName.get()==null)
    {
      errorLabel.set("First name and last name cannot be empty..");

    }
    else if (password.get() == null || password.get().isEmpty())
    {
      errorLabel.set("Password cannot be empty..");

    }
    else if (userType.get() == null || userType.get().isEmpty())
    {
      errorLabel.set("User Type cannot be empty..");

    }
    else
    {
      String response = createModel.addUser(firstName.get(),
          lastName.get(), userName.get(), password.get(),userType.get().toUpperCase(
              Locale.ROOT)
          );
      if (!response.equals("Approved"))
      {
        errorLabel.set(response);
        clearUsernameAndPassword();
      }
      return response;

    }
    clearAll();
    return null;

  }

  /**
   * A method that will clean all the fields
   */
  private void clearAll()
  {
    password.set(null);
    userName.set(null);
    firstName.set(null);
    lastName.set(null);
  }

  /**
   * A method that will clean username and password field
   */
  private void clearUsernameAndPassword()
  {
    password.set(null);
    userName.set(null);
  }
}
