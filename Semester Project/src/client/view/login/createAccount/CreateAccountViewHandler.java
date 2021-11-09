package client.view.login.createAccount;

import client.core.ModelFactory;
import javafx.beans.property.BooleanProperty;
import javafx.beans.property.SimpleBooleanProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreateAccountViewHandler {
    private StringProperty signUpFirstName, signUpLastName, signUpUsername, signUpPassword;
    private BooleanProperty signupScene;

    private ModelFactory modelFactory;

    public CreateAccountViewHandler(ModelFactory modelFactory) {
        this.modelFactory = modelFactory;
        initializeAllProperties();
    }

    private void initializeAllProperties() {
        signUpFirstName = new SimpleStringProperty();
        signUpLastName = new SimpleStringProperty();
        signUpPassword = new SimpleStringProperty();
        signUpUsername = new SimpleStringProperty();
        signupScene = new SimpleBooleanProperty();
    }
    public void playSignUpAnimation(){
        signupScene.setValue(true);
    }
    public void playSignInAnimation(){
        signupScene.setValue(false);
    }
}
