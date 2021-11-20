package client.view.login.createAccount;

import client.core.ModelFactory;
import client.model.create.CreateModel;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;


public class CreateAccountViewModel {
    private StringProperty signUpFirstName, signUpLastName, signUpUsername, signUpPassword, errorLabel;
    private BooleanProperty signupScene;

    private ModelFactory modelFactory;
    private CreateModel createModel;

    public CreateAccountViewModel(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        createModel= modelFactory.getCreateModel();
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
        if (signUpUsername.get()==null ||signUpUsername.get().isEmpty()){
            errorLabel.set("Username cannot be empty..");

        }
        else if ( signUpFirstName.get()==null ||signUpFirstName.get().isEmpty() || signUpLastName.get().isEmpty() ){
            errorLabel.set("First name and last name cannot be empty..");

        }
        else if (signUpPassword.get()==null||signUpPassword.get().isEmpty()){
            errorLabel.set("Password cannot be empty..");

        }
        else{
                String response= createModel.addUser(signUpFirstName.get(),signUpLastName.get(),signUpUsername.get(),signUpPassword.get());
                if (!response.equals("Approved")){
                    errorLabel.set(response);
                    clearUsernameAndPassword();
                }
                return response;


            }
        clearAll();
        return null;

    }
    private void clearAll(){
        signUpPassword.set(null);
        signUpUsername.set(null);
        signUpFirstName.set(null);
        signUpLastName.set(null);
    }
    private void clearUsernameAndPassword(){
        signUpPassword.set(null);
        signUpUsername.set(null);
    }
}
