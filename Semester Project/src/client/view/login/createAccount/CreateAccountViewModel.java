package client.view.login.createAccount;

import client.core.ModelFactory;
import client.model.create.CreateModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import shared.utils.User.Usertype;

/**
 * @author Sachin
 * A class that will create a new user and set the values to database
 */
public class CreateAccountViewModel
{
  private StringProperty signUpFirstName, signUpLastName, signUpUsername, signUpPassword, errorLabel;
  private BooleanProperty signupScene;

  private ModelFactory modelFactory;
  private CreateModel createModel;

  /**
   * A constructor
   * @param modelFactory
   */
  public CreateAccountViewModel(ModelFactory modelFactory)
  {
    this.modelFactory = modelFactory;
    createModel = modelFactory.getCreateModel();
    initializeAllProperties();
  }

  /**
   * A method that will initialize everything
   */
  private void initializeAllProperties()
  {
    signUpFirstName = new SimpleStringProperty();
    signUpLastName = new SimpleStringProperty();
    signUpPassword = new SimpleStringProperty();
    signUpUsername = new SimpleStringProperty();
    signupScene = new SimpleBooleanProperty();
    errorLabel = new SimpleStringProperty();
  }

  /**
   * A method that will start play sign-up animation
   */
  public void playSignUpAnimation()
  {
    signupScene.setValue(true);
  }

  /**
   * A method that will start play sign-in animation
   */
  public void playSignInAnimation()
  {
    signupScene.setValue(false);
  }

  /**
   * a method that will return first name
   * @return first name
   */
  public StringProperty getSignUpFirstName()
  {
    return signUpFirstName;
  }

  /**
   * A method that will return last name
   * @return last name
   */
  public StringProperty getSignUpLastName()
  {
    return signUpLastName;
  }

  /**
   * A method that will return username
   * @return username
   */
  public StringProperty getSignUpUsername()
  {
    return signUpUsername;
  }

  /**
   * A method that will return a password
   * @return password
   */
  public StringProperty getSignUpPassword()
  {
    return signUpPassword;
  }

  /**
   * A method that will return an error label
   * @return error label
   */
  public StringProperty getErrorLabel()
  {
    return errorLabel;
  }

  /**
   * A method that will return sign-up scene
   * @return sign-up scene
   */
  public BooleanProperty getSignupScene()
  {
    return signupScene;
  }

  /**
   * A method that will create an account
   * @return create an account
   */
  public String createAccount()
  {
    if (signUpUsername.get() == null || signUpUsername.get().isEmpty())
    {
      errorLabel.set("Username cannot be empty..");

    }
    else if (signUpFirstName.get() == null || signUpFirstName.get().isEmpty()
        || signUpLastName.get().isEmpty())
    {
      errorLabel.set("First name and last name cannot be empty..");

    }
    else if (signUpPassword.get() == null || signUpPassword.get().isEmpty())
    {
      errorLabel.set("Password cannot be empty..");

    }
    else
    {
      // Approved
      String response = createModel.addUser(signUpFirstName.get(),
          signUpLastName.get(), signUpUsername.get(), signUpPassword.get(),
          Usertype.CUSTOMER.toString());
      if (!response.equals("Approved"))
      {
        errorLabel.set(response);
        clearUsernameAndPassword();
      }
      return response;

    }

    return null;

  }


  /**
   * A method that will clean username and password fields
   */
  private void clearUsernameAndPassword()
  {
    signUpPassword.set(null);
    signUpUsername.set(null);
  }
}
