package client.view.admin.createAccount;

import client.core.ModelFactory;
import client.model.create.CreateModel;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.utils.User.Usertype;

import java.util.Locale;


public class AdminCreateAccountViewModel
{



  private StringProperty firstName,lastName,userName,password,userType,errorLabel;
  private ModelFactory modelFactory;
  private CreateModel createModel;


  public StringProperty getFirstNameProperty()
  {
    return firstName;
  }
  public StringProperty getLastNameProperty()
  {
    return lastName;
  }
  public StringProperty getUserNameProperty()
  {
    return userName;
  }
  public StringProperty getPasswordProperty()
  {
    return password;
  }
  public StringProperty getUserTypeProperty()
  {
    return userType;
  }

  public StringProperty errorLabelProperty()
  {
    return errorLabel;
  }

  public AdminCreateAccountViewModel(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    createModel = modelFactory.getCreateModel();
    initializeAllProperties();
  }

  private void initializeAllProperties()
  {
    firstName = new SimpleStringProperty();
    lastName = new SimpleStringProperty();
    userName = new SimpleStringProperty();
    password = new SimpleStringProperty();
    userType = new SimpleStringProperty();
    errorLabel = new SimpleStringProperty();
  }

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
  private void clearAll()
  {
    password.set(null);
    userName.set(null);
    firstName.set(null);
    lastName.set(null);
  }

  private void clearUsernameAndPassword()
  {
    password.set(null);
    userName.set(null);
  }
}
