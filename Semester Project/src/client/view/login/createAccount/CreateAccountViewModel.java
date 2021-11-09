package client.view.login.createAccount;

import client.core.ModelFactory;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreateAccountViewModel {
    private StringProperty signUpFirstName, signUpLastName, signUpUsername, signUpPassword, errorLabel;
    private BooleanProperty signupScene;

    private ModelFactory modelFactory;

    public CreateAccountViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        initializeAllProperties();
    }

    private void initializeAllProperties() {
        signUpFirstName = new SimpleStringProperty();
        signUpLastName = new SimpleStringProperty();
        signUpPassword = new SimpleStringProperty();
        signUpUsername = new SimpleStringProperty();
        signupScene = new SimpleBooleanProperty();
        errorLabel = new SimpleStringProperty();
    }

    public void playSignUpAnimation() {
        signupScene.setValue(true);
    }

    public void playSignInAnimation() {
        signupScene.setValue(false);
    }

    public StringProperty getSignUpFirstName() {
        return signUpFirstName;
    }

    public StringProperty getSignUpLastName() {
        return signUpLastName;
    }

    public StringProperty getSignUpUsername() {
        return signUpUsername;
    }

    public StringProperty getSignUpPassword() {
        return signUpPassword;
    }

    public StringProperty getErrorLabel() {
        return errorLabel;
    }

    public BooleanProperty getSignupScene() {
        return signupScene;
    }

    public String createAccount() {
        if (signUpUsername.get().isEmpty()){
            errorLabel.set("Username cannot be empty");
            return null;
        }
        else if (signUpFirstName.get().isEmpty() || signUpLastName.get().isEmpty() ){
            errorLabel.set("First name and last name cannot be empty");
            return null;
        }
        else if (signUpPassword.get().isEmpty()){
            errorLabel.set("Password invalid");
            return null;
        }
        else{
            c
        }

    }
}
